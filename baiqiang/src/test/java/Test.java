import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Test{

    public  static void test(){
        int [ ][ ]  arr={{180,60},{180,70},{170,65},{160,50}};
        WebElement height;
        WebElement weight;
        WebElement submit;
        WebElement height1;
        WebElement weight1;
        WebElement bmi;
//        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver2.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cn.onlinebmicalculator.com/");
        driver.manage().window().maximize();
        for (int [] a:arr
             ) {
            height = driver.findElement(By.name("f_height"));
            weight = driver.findElement(By.name("f_weight"));
            submit = driver.findElement(By.name("f_submit"));
            height.sendKeys(Integer.toString(a[0]));
            weight.sendKeys(Integer.toString(a[1]));
            submit.click();
             driver.findElement(By.name("f_height")).clear();
             driver.findElement(By.name("f_weight")).clear();
            bmi= driver.findElement(By.className("bmi_val_normal"));
            System.out.println("身高："+a[0]+"\t体重："+a[1]+"\tBMI值为："+bmi.getText());
        }

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


