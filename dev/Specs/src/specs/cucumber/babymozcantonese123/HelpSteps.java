package specs.cucumber.babymozcantonese123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class HelpSteps {

    private FileContext context;
    public HelpSteps(FileContext context) { this.context = context; }

    @Given("^I opened the help view in the Cantonese 123 app$")
    public void I_opened_the_help_view_in_the_Cantonese_123_app() throws IOException {

        String path = "\\BabyMozCantonese123\\assets\\en\\help.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
