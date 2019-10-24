package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class TestCucumber2 {
    CucumberPom2 cp;
    public  TestCucumber2(){
        cp=new CucumberPom2();
        cp.open_browser();

    }
    @Given("^open browser2$")
    public  void open_browser(){

    }
    @Then("^input data \"([^\"]*)\" \"([^\"]*)\"$")
    public void input_data(String height,String weight) throws IOException {
        cp.input_data(height,weight);
    }


    @Then("^assert  result \"([^\"]*)\"$")
    public void assert_result(String result) throws IOException {
        cp.assert_result(result);
    }

    @After
    public void quit_browser() {
        cp.quit_browser();
    }


    public static void main(String[] args) {
        System.out.println("it is main!");
    }
}
