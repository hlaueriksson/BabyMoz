package specs.cucumber;

import specs.FakeBaseActivity;

public class BaseActivityContext {

    private FakeBaseActivity activity;

    public FakeBaseActivity getActivity() {
        return activity;
    }

    public void setActivity(FakeBaseActivity activity) {
        this.activity = activity;
    }
}
