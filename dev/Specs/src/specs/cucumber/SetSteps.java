package specs.cucumber;

import cucumber.annotation.en.Then;
import org.w3c.dom.Node;
import specs.TestSupport;

import javax.xml.xpath.XPathExpressionException;

import static junit.framework.Assert.assertEquals;

public class SetSteps {

    private DocumentContext context;
    public SetSteps(DocumentContext context) { this.context = context; }

    @Then("^the first symbol is \"([^\"]*)\"$")
    public void the_first_symbol_is(String symbol) throws XPathExpressionException {

        Node node = TestSupport.getNode(context.getDocument(), "//symbol[1]");
        String text = node.getAttributes().getNamedItem("text").getNodeValue();

        assertEquals(symbol, text);
    }

    @Then("^the last symbol is \"([^\"]*)\"$")
    public void the_last_symbol_is(String symbol) throws XPathExpressionException {

        Node node = TestSupport.getNode(context.getDocument(), "//symbol[last()]");
        String text = node.getAttributes().getNamedItem("text").getNodeValue();

        assertEquals(symbol, text);
    }
}
