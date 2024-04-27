import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Document {
    private List<Character> letters;

    public Document() {
        this.letters = new ArrayList<>();
    }

    public void setletter(char letter, CharacterProperties letterProperties) {
        letters.add(new Character(letter, letterProperties));
    }


    public List<Character> getLetters() {
        return letters;
    }

    public void saveToFile(String file) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            for (Character ch : letters) {
                out.write("["
                        + ch.getLetterProperties().getFont() + "|"
                        + ch.getLetterProperties().getSize() + "|"
                        + ch.getLetterProperties().getColor() + "]"+ ch.getLetter());
                out.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadDFromFile(String file, PropertiesFactory bank) {
        letters.clear();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String row;
            while ((row = in.readLine()) != null) {
                int lastIndex = row.indexOf(']');
                String propertiesPart = row.substring(1, lastIndex);
                char character = row.charAt(lastIndex + 1);

                String[] properties = propertiesPart.split("\\|");
                if (properties.length == 3) {
                    String font = properties[0];
                    int size = Integer.parseInt(properties[1]);
                    String color = properties[2];
                    CharacterProperties characteristic = bank.getletterProperties(font, size, color);
                    letters.add(new Character(character, characteristic));
                }
            }
        } catch (IOException e) {
            System.err.println("File: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Format: " + e.getMessage());
        }
    }
}
