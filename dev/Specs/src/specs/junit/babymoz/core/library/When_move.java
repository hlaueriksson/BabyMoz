package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Direction;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class When_move extends Given_Library {

    @Test
    public void then_the_screens_should_be_in_a_consecutive_loop()
    {
        // Forward

        assertEquals("[1]", library.getScreen().getContent().toString()); // start

        library.move(Direction.NEXT);
        assertEquals("A", library.getScreen().getContent().toString());

        library.move(Direction.NEXT);
        assertEquals("B", library.getScreen().getContent().toString());

        library.move(Direction.NEXT);
        assertEquals("C", library.getScreen().getContent().toString());

        library.move(Direction.NEXT);
        assertEquals("[1]", library.getScreen().getContent().toString()); // back to start again

        // Backward

        library.move(Direction.PREVIOUS);
        assertEquals("C", library.getScreen().getContent().toString());

        library.move(Direction.PREVIOUS);
        assertEquals("B", library.getScreen().getContent().toString());

        library.move(Direction.PREVIOUS);
        assertEquals("A", library.getScreen().getContent().toString());

        library.move(Direction.PREVIOUS);
        assertEquals("[1]", library.getScreen().getContent().toString()); // back to start again
    }
}
