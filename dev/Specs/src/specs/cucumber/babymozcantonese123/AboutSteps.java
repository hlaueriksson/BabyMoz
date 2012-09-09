package specs.cucumber.babymozcantonese123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class AboutSteps {

    private FileContext context;
    public AboutSteps(FileContext context) { this.context = context; }

    @Given("^I opened the about view in the Cantonese 123 app$")
    public void I_opened_the_about_view_in_the_Cantonese_123_app() throws IOException {

        String path = "\\BabyMozCantonese123\\assets\\about.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
