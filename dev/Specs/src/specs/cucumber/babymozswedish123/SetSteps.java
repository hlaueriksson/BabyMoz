package specs.cucumber.babymozswedish123;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import specs.TestSupport;

import javax.xml.xpath.XPathExpressionException;

import static junit.framework.Assert.assertEquals;

public class SetSteps {

    private Document document;

    @Given("^the set is loaded for the Swedish 123 app$")
    public void the_set_is_loaded_for_the_Swedish_app() throws Exception {

        String path = "\\BabyMozSwedish123\\res\\xml\\set.xml";
        document = TestSupport.readXml(path);
    }

    @Then("^the first symbol is \"([^\"]*)\"$")
    public void the_first_symbol_is(String symbol) throws XPathExpressionException {

        Node node = TestSupport.getNode(document, "//symbol[1]");
        String text = node.getAttributes().getNamedItem("text").getNodeValue();

        assertEquals(symbol, text);
    }

    @Then("^the last symbol is \"([^\"]*)\"$")
    public void the_last_symbol_is(String symbol) throws XPathExpressionException {

        Node node = TestSupport.getNode(document, "//symbol[last()]");
        String text = node.getAttributes().getNamedItem("text").getNodeValue();

        assertEquals(symbol, text);
    }
}
