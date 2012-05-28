package specs.cucumber.babymozswedishabc;

import cucumber.annotation.en.Given;
import specs.TestSupport;
import specs.cucumber.DocumentContext;

public class SetSteps {

    private DocumentContext context;
    public SetSteps(DocumentContext context) { this.context = context; }

    @Given("^the set is loaded for the Swedish ABC app$")
    public void the_set_is_loaded_for_the_Swedish_ABC_app() throws Exception {

        String path = "\\BabyMozSwedishAbc\\res\\xml\\set.xml";
        context.setDocument(TestSupport.readXml(path));
    }
}
