/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cucumbertest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author JoÃ£o Melo <code>- jota.viworkx@gmail.com</code>
 */
public class RunCalculatorSteps {
    @Given("^I have a sensor$")
    public void i_have_a_sensor() throws Throwable {
        System.out.print("I have a sensor\n");
    }
    
    @When("^the value is above (\\d+)$")
    public void the_value_is_above(int arg1) throws Throwable {
        System.out.print(arg1);
        if(arg1 >= 40){
            System.out.print("Value " + arg1 + " is above the expected max!!!!\n");
            return;
            
        }
        else {if(arg1 <= -10){
            System.out.print("Value " + arg1 + " is above the expected min!!!!\n");
            return;
        }}
        System.out.print("Value is normal");
        
    }
    
    @Then("^the system should give me a signal$")
    public void the_system_should_give_me_a_signal() throws Throwable {
        System.out.print("Turn on air conditioner\n");
        
    }
}
