import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentTest {

    @Test
    public void testAddAndGetLetters() {
        Document document = new Document();
        CharacterProperties props = new CharacterProperties("Arial", 12, "Blue");
        document.setletter('a', props);
        assertEquals(1, document.getLetters().size());
        assertEquals('a', document.getLetters().get(0).getLetter());
    }

    @Test
    public void testFileSaveAndLoad() {
        // This test would need a mock framework to properly isolate file dependencies
        Document document = new Document();
        PropertiesFactory factory = new PropertiesFactory();
        document.setletter('a', factory.getletterProperties("Arial", 12, "Blue"));
        document.saveToFile("test.txt");

        Document newDoc = new Document();
        newDoc.loadDFromFile("test.txt", factory);
        Character loadedChar = newDoc.getLetters().get(0);

        assertEquals('a', loadedChar.getLetter());
        assertEquals("Arial", loadedChar.getLetterProperties().getFont());
        assertEquals(12, loadedChar.getLetterProperties().getSize());
        assertEquals("Blue", loadedChar.getLetterProperties().getColor());
    }
}
