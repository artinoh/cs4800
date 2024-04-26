import java.util.Objects;

public class CharacterProperty {
    private final String font;
    private final int size;
    private final String color;

    public CharacterProperty(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CharacterProperty|" + font + "," + size + "," + color + "|";
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, size, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterProperty that = (CharacterProperty) o;
        return size == that.size &&
                font.equals(that.font) &&
                color.equals(that.color);
    }
}
