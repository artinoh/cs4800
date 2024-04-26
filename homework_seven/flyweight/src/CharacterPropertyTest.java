import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertyTest {

    @Test
    public void testConstructorAndGetters() {
        String expectedFont = "Arial";
        int expectedSize = 12;
        String expectedColor = "red";

        CharacterProperty property = new CharacterProperty(expectedFont, expectedSize, expectedColor);

        assertEquals(expectedFont, property.getFont());
        assertEquals(expectedSize, property.getSize());
        assertEquals(expectedColor, property.getColor());
    }

    @Test
    public void TestEqualsSameObject() {
        CharacterProperty property = new CharacterProperty("Arial", 12, "red");

        assertEquals(property, property);
        assertNotEquals(property, null);
        assertNotEquals(property, new Object());
    }

    @Test
    public void TestEqualsDifferentObject() {
        CharacterProperty property1 = new CharacterProperty("Arial", 12, "red");
        CharacterProperty property2 = new CharacterProperty("Arial", 14, "red");

        assertNotEquals(property1, property2);
    }

}
