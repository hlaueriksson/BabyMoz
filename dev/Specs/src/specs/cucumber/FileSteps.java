package specs.cucumber;

import cucumber.annotation.en.Then;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class FileSteps {

    private FileContext context;
    public FileSteps(FileContext context) { this.context = context; }

    @Then("^I should see:$")
    public void I_should_see(DataTable keywords) {

        String text = context.getText().toLowerCase();

        for (DataTableRow row : keywords.getGherkinRows()) {
            String keyword = row.getCells().get(0).toLowerCase();
            assertThat(text, containsString(keyword));
        }
    }
}
