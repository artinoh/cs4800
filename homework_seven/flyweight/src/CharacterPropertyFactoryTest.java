import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}