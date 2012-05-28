package specs.cucumber;

import com.hoffenkloffen.babymoz.core.Direction;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import specs.FakeBaseActivity;
import specs.TestSupport;

public class BaseActivitySteps {

    private BaseActivityContext context;
    public BaseActivitySteps(BaseActivityContext context) { this.context = context; }

    @Given("^that the app is started$")
    public void that_the_app_is_started() {

        FakeBaseActivity activity = TestSupport.fakeBaseActivity();

        context.setActivity(activity);
    }

    @When("^a new symbol is displayed$")
    public void a_new_symbol_is_displayed() {

        context.getActivity().update(Direction.NEXT);
    }
}
