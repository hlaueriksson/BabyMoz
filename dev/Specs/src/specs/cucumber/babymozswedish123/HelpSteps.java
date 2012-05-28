package specs.cucumber.babymozswedish123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class HelpSteps {

    private FileContext context;
    public HelpSteps(FileContext context) { this.context = context; }

    @Given("^I opened the help view in the Swedish 123 app$")
    public void I_opened_the_help_view_in_the_Swedish_app() throws IOException {

        String path = "\\BabyMozSwedish123\\assets\\help.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
