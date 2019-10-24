import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class TestNg {

    @Test(dataProvider="data")
    public void TestBMI(String height, String weight, String testBMI) throws InterruptedException{

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://cn.onlinebmicalculator.com/");
        driver.findElement(By.name("f_height")).clear();
        driver.findElement(By.name("f_height")).sendKeys(height);
        driver.findElement(By.name("f_weight")).clear();
        driver.findElement(By.name("f_weight")).sendKeys(weight);
        driver.findElement(By.name("f_submit")).click();

        Thread.sleep(1000);
        String result = driver.findElement(By.xpath("//span[@class='bmi_val bmi_val_normal']")).getText();
        Assert.assertTrue(testBMI.equals(result));
        driver.close();
    }

    @DataProvider(name="data")
    public Object[][] dataSource(){

        Object [][] data = new Object[][]{
                {"180", "60", "18.5" }
                ,{ "180", "70", "21.6" },
                { "170", "65", "22.5" },
                { "160", "50", "19.5" }
        };
        return data;
    }


}
