import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharacterPropertiesTest {

    @Test
    public void testProperties() {
        CharacterProperties props = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Arial", props.getFont());
        assertEquals(12, props.getSize());
        assertEquals("Red", props.getColor());
    }
}
