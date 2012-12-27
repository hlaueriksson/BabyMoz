package specs.cucumber.babymozswedish123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.FileContext;

import java.io.IOException;

public class AboutSteps {

    private FileContext context;
    public AboutSteps(FileContext context) { this.context = context; }

    @Given("^I opened the about view in the Swedish 123 app$")
    public void I_opened_the_about_view_in_the_Swedish_123_app() throws IOException {

        String path = "\\BabyMozSwedish123\\assets\\en\\about.html";
        String text = TestSupport.readFile(path);

        context.setText(text);
    }
}
