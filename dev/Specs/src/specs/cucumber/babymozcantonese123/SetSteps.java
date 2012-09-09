package specs.cucumber.babymozcantonese123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.DocumentContext;

public class SetSteps {

    private DocumentContext context;
    public SetSteps(DocumentContext context) { this.context = context; }

    @Given("^the set is loaded for the Cantonese 123 app$")
    public void the_set_is_loaded_for_the_Cantonese_123_app() throws Exception {

        String path = "\\BabyMozCantonese123\\res\\xml\\set.xml";
        context.setDocument(TestSupport.readXml(path));
    }
}
