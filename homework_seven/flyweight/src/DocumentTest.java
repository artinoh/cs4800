import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentTest {

    @Test
    public void testInsertCharacter_UsesDefaultProperty() {
        Document document = new Document();
        document.insert('a');

        assertEquals(1, document.getCharacters().size());
        assertEquals('a', document.getCharacters().getFirst().getKey());
        assertEquals(document.getDefaultProperty(), document.getCharacters().getFirst().getValue());
    }

    @Test
    public void testInsertCharacter_WithCustomProperty() {
        CharacterProperty property = new CharacterProperty("Times New Roman", 14, "Blue");
        Document document = new Document();
        document.insert('b', property);

        assertEquals(1, document.getCharacters().size());
        assertEquals('b', document.getCharacters().getFirst().getKey());
        assertEquals(property, document.getCharacters().getFirst().getValue());
    }

    @Test
    public void testChangeDefaultProperty_UpdatesProperty() {
        Document document = new Document();
        CharacterProperty property = new CharacterProperty("Calibri", 18, "Red");
        document.changeDefaultProperty(property);

        assertEquals(property, document.getDefaultProperty());
    }


    @Test
    public void testChangeDefaultProperty_WithParams() {
        Document document = new Document();
        document.changeDefaultProperty("Comic Sans", 20, "Yellow");

        assertEquals(20, document.getDefaultProperty().getSize());
        assertEquals("Yellow", document.getDefaultProperty().getColor());
        assertEquals("Comic Sans", document.getDefaultProperty().getFont());
    }


    @Test
    public void testPop_DoesNothingOnEmptyDocument() {
        Document document = new Document();
        document.pop();

        assertEquals(0, document.getCharacters().size());
    }

    @Test
    public void testPop_RemovesLastCharacter() {
        Document document = new Document();
        document.insert('a');
        document.insert('b');

        document.pop();

        assertEquals(1, document.getCharacters().size());
        assertEquals('a', document.getCharacters().getFirst().getKey());
    }
}