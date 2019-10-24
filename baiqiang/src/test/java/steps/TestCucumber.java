package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.io.IOException;

public class TestCucumber {
    CucumberPom cp;
    @Given("^open browser$")
    public  void open_browser(){
    cp=new CucumberPom();
    cp.open_browser("https://www.osgeo.cn/app/sc804");
    }
    @Then("^input data$")
    public void input_data() throws IOException {
        //获取准备向浏览器输入的测试数据
        cp.get_data("data.xlsx");
        //输入测试数据
        cp.input_data();

    }


    @Then("^assert  result$")
    public void assert_result() throws IOException {
        cp.assert_result();
    }



    public static void main(String[] args) {
        System.out.println("it is main!");
    }
}
