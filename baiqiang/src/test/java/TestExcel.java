import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class TestExcel {
    public  static void test() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cn.onlinebmicalculator.com/");
        driver.manage().window().maximize();
        File xlsFile = new File("data.xlsx");
        // 获得工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlsFile));
        // 获得工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取工作表行数
        int rows = sheet.getPhysicalNumberOfRows();
        //按行遍历
        for (int i = 0; i < rows; i++) {
            // 获取第i行数据
            XSSFCell height = sheet.getRow(i).getCell(0);
            XSSFCell weight = sheet.getRow(i).getCell(1);
            String  bmi = sheet.getRow(i).getCell(2).toString();
            driver.findElement(By.name("f_height")).sendKeys(height.toString());
            driver.findElement(By.name("f_weight")).sendKeys(weight.toString());
            driver.findElement(By.name("f_submit")).click();
            String result = driver.findElement(By.xpath("//span[@class='bmi_val bmi_val_normal']")).getText();
            Assert.assertTrue(bmi.equals(result));
            driver.findElement(By.name("f_height")).clear();
            driver.findElement(By.name("f_weight")).clear();
        }
//        System.out.println("pass!");
        driver.quit();
    }
        public static void main(String[] args){
            try {
                test();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }


