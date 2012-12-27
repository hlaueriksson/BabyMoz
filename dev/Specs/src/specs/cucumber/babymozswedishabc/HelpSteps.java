package specs.cucumber.babymozswedishabc;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class HelpSteps {

    private FileContext context;
    public HelpSteps(FileContext context) { this.context = context; }

    @Given("^I opened the help view in the Swedish ABC app$")
    public void I_opened_the_help_view_in_the_Swedish_ABC_app() throws IOException {

        String path = "\\BabyMozSwedishAbc\\assets\\en\\help.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
