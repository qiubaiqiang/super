package steps;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CucumberPom {
    private WebDriver driver;
    private XSSFSheet sheet;
    private String fileName;
    //打开浏览器
    public  void open_browser(String url){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    //向浏览器输入数据并返回结果
    public List input_data() throws IOException {
        sheet=get_data(fileName);
        List result =new ArrayList();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            // 获取第i行数据
            String height = sheet.getRow(i).getCell(0).toString();
            String weight = sheet.getRow(i).getCell(1).toString();
            driver.findElement(By.name("heigth")).clear();
            driver.findElement(By.name("weight")).clear();
            driver.findElement(By.name("heigth")).sendKeys(height);
            driver.findElement(By.name("weight")).sendKeys(String.valueOf((int)Float.parseFloat(weight)));
            driver.findElement(By.xpath("//*[@id=\"done\"]")).click();
            result.add(driver.findElement(By.xpath("//*[@id=\"vBMI\"]/b")).getText());

        }
        return result;

    }
    //断言数据有效性
    public  void  assert_result() throws IOException {
        List result=input_data();
        sheet=get_data(fileName);
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
        String  bmi = sheet.getRow(i).getCell(2).toString();
        Assert.assertTrue(bmi.equals(result.get(i)));}
        driver.quit();
    }
    //根据Excel文件获取工作表
    public XSSFSheet get_data(String fileName) throws IOException{
        this.fileName=fileName;
        File xlsFile = new File(fileName);
        // 获得工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlsFile));
        // 获得工作表
        return workbook.getSheetAt(0);
    }
}











