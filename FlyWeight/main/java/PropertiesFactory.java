import java.util.HashMap;
import java.util.Map;
public class PropertiesFactory {
    private Map<String, CharacterProperties> letterProperties;
    public PropertiesFactory() {
        this.letterProperties = new HashMap<>();
    }
    public CharacterProperties getletterProperties(String font, int size, String color) {
        String characterKey = size + font + color;
        if (!letterProperties.containsKey(characterKey)) {
            letterProperties.put(characterKey, new CharacterProperties(font, size, color));
        }
        return letterProperties.get(characterKey);
    }
}

