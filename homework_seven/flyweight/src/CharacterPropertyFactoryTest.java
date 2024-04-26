import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertyFactoryTest {

    @Test
    public void TestReturnsExistingObject() {
        String font = "Arial";
        int size = 12;
        String color = "red";

        CharacterProperty property = new CharacterProperty(font, size, color);
        CharacterProperty returnedProperty = CharacterPropertyFactory.getCharacterProperty(font, size, color);

        HashMap<CharacterProperty, CharacterProperty> properties = CharacterPropertyFactory.getProperties();
        assertEquals(1, properties.size());
    }

    @Test
    public void testGetCharacterProperty_CreatesNewObjectForUniqueProperties() {
        String font1 = "Arial";
        int size1 = 12;
        String color1 = "red";

        String font2 = "Times New Roman";
        int size2 = 14;
        String color2 = "blue";

        CharacterProperty property1 = CharacterPropertyFactory.getCharacterProperty(font1, size1, color1);
        CharacterProperty property2 = CharacterPropertyFactory.getCharacterProperty(font2, size2, color2);

        assertNotSame(property1, property2);
    }
}