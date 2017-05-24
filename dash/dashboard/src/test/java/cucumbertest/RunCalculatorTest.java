/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cucumbertest;

/**
 *
 * @author JoÃ£o Melo <code>- jota.viworkx@gmail.com</code>
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:cucumber/Temperature.feature"
)
public class RunCalculatorTest {
    
}
