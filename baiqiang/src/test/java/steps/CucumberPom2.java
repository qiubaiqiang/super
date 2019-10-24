package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CucumberPom2 {
    private WebDriver driver;
    @FindBy(xpath ="//*[@id=\"height\"]" ) private WebElement height;
    @FindBy(xpath ="//*[@id=\"weight\"]" ) private WebElement weight;
    @FindBy(xpath ="//*[@id=\"done\"]" ) private WebElement button;
    @FindBy(xpath ="//*[@id=\"vBMI\"]/b" ) private WebElement bmi;

    //打开浏览器
    public  void open_browser(){
        driver = new ChromeDriver();
        driver.get("https://www.osgeo.cn/app/sc804");
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
//        driver.get(url);
//        driver.manage().window().maximize();
    }
    //向浏览器输入数据并返回结果
    public void input_data(String height,String weight) throws IOException {
//            driver.findElement(By.name("heigth")).clear();
//            driver.findElement(By.name("weight")).clear();
//            driver.findElement(By.name("heigth")).sendKeys(height);
//            driver.findElement(By.name("weight")).sendKeys(weight);
//            driver.findElement(By.xpath("//*[@id=\"done\"]")).click();
            this.height.clear();
            this.weight.clear();
            this.height.sendKeys(height);
            this.weight.sendKeys(weight);
            this.button.click();

    }
    //断言数据有效性
    public  void  assert_result(String result) throws IOException {
        Assert.assertTrue(result.equals(this.bmi.getText()));

    }
    public void quit_browser(){
        driver.quit();
    }
}











