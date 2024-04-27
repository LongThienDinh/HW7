import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    @Test
    public void testCharacterInitialization() {
        CharacterProperties props = new CharacterProperties("Arial", 12, "Blue");
        Character character = new Character('a', props);
        assertEquals('a', character.getLetter());
        assertEquals(props, character.getLetterProperties());
    }

    @Test
    public void testSetLetterProperties() {
        CharacterProperties props = new CharacterProperties("Arial", 12, "Blue");
        CharacterProperties newProps = new CharacterProperties("Calibri", 14, "Black");
        Character character = new Character('a', props);
        character.setLetterProperties(newProps);
        assertEquals(newProps, character.getLetterProperties());
    }
}
