public class CharacterProperties {
    private int size;
    private String font;
    private String color;

    public CharacterProperties(String font, int size, String color) {
        this.size = size;
        this.font = font;
        this.color = color;
    }
    public int getSize() {
        return size;
    }
    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }
}
