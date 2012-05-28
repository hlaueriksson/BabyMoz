package specs.cucumber;

import com.hoffenkloffen.babymoz.core.Audio;
import com.hoffenkloffen.babymoz.core.Library;
import com.hoffenkloffen.babymoz.core.Set;
import com.hoffenkloffen.babymoz.core.Symbol;
import cucumber.annotation.en.Given;

public class LibrarySteps {

    private LibraryContext context;
    public LibrarySteps(LibraryContext context) { this.context = context; }

    // Screen

    @Given("^that a screen is initiated$")
    public void that_a_screen_is_initiated() {

        Audio audio = new Audio();
        audio.setFilename("set");
        audio.setDuration(2000);

        Set set = new Set();
        set.setAudio(audio);
        set.addItem(new Symbol("A"));

        Library library = new Library(set);
        library.setColors(new int[] {1, 2, 3});
        library.setAnimations(new int[] {1, 2, 3});
        library.init(); // NOTE: initiates all screens

        context.setLibrary(library);
    }
}
