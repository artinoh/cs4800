import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;


public class CharacterPropertyFactory {
    private static final HashMap<CharacterProperty, CharacterProperty> properties = new HashMap<>();

    public static CharacterProperty getCharacterProperty(String font, int size, String color) {
        CharacterProperty property = new CharacterProperty(font, size, color);
        return properties.computeIfAbsent(property, p -> property);
    }

    public static HashMap<CharacterProperty, CharacterProperty> getProperties() {
        return properties;
    }
}
