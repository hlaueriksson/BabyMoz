package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Direction;
import com.hoffenkloffen.babymoz.core.Welcome;
import org.junit.Test;
import specs.TestSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class When_shuffle extends Given_Library {

    protected void when()
    {
        library.shuffle();
    }

    @Test
    public void then_the_welcome_screens_should_appear_first()
    {
        Welcome welcome = (Welcome) library.getScreen().getContent();

        assertNotNull(welcome);
    }

    @Test
    public void then_the_other_screens_should_appear_in_random_order()
    {
        String result = "";

        for(int i = 0; i < library.getSet().getItems().size(); i++)
        {
            result += library.getScreen();
            library.move(Direction.NEXT);
        }

        assertThat(result, not(equalTo(TestSupport.toString(library.getSet()))));
    }
}
