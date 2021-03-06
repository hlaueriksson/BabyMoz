package specs.cucumber.babymozswedish123;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.DocumentContext;

public class SetSteps {

    private DocumentContext context;
    public SetSteps(DocumentContext context) { this.context = context; }

    @Given("^the set is loaded for the Swedish 123 app$")
    public void the_set_is_loaded_for_the_Swedish_123_app() throws Exception {

        String path = "\\BabyMozSwedish123\\res\\xml\\set.xml";
        context.setDocument(TestSupport.readXml(path));
    }
}
