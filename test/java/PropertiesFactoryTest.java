import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PropertiesFactoryTest {

    @Test
    public void testGetLetterProperties() {
        PropertiesFactory factory = new PropertiesFactory();
        CharacterProperties props1 = factory.getletterProperties("Arial", 12, "Blue");
        CharacterProperties props2 = factory.getletterProperties("Arial", 12, "Blue");
        assertSame(props1, props2);
    }
}
