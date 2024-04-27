public class Character {
    private char letter;
    private CharacterProperties letterProperties;

    public Character(char letter, CharacterProperties letterProperties) {
        this.letter = letter;
        this.letterProperties = letterProperties;
    }
    public CharacterProperties getLetterProperties() {
        return letterProperties;
    }
    public char getLetter() {
        return letter;
    }
    public void setLetterProperties(CharacterProperties letterProperties) {
        this.letterProperties = letterProperties;
    }
}