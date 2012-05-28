package specs.cucumber.babymozswedishabc;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class AboutSteps {

    private FileContext context;
    public AboutSteps(FileContext context) { this.context = context; }

    @Given("^I opened the about view in the Swedish ABC app$")
    public void I_opened_the_about_view_in_the_Swedish_ABC_app() throws IOException {

        String path = "\\BabyMozSwedishAbc\\assets\\about.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
