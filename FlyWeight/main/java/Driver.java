public class Driver {
    public static void main(String[] args) {
        PropertiesFactory propertiesFactory = new PropertiesFactory();
        Document document = new Document();

        String text = "HelloWorldCS5800";

        CharacterProperties propertiesRedArial12 = propertiesFactory.getletterProperties("Arial", 12, "Red");
        CharacterProperties propertiesBlueCalibri14 = propertiesFactory.getletterProperties("Calibri", 14, "Blue");
        CharacterProperties propertiesBlackVerdana16 = propertiesFactory.getletterProperties("Verdana", 16, "Black");
        CharacterProperties propertiesBlueArial12 = propertiesFactory.getletterProperties("Arial", 12, "Blue");

        CharacterProperties[] propertiesArray = {propertiesRedArial12, propertiesBlueCalibri14, propertiesBlackVerdana16, propertiesBlueArial12};

        for (int i = 0; i < text.length(); i++) {
            int propertyIndex = (i / 3) % propertiesArray.length;
            document.setletter(text.charAt(i), propertiesArray[propertyIndex]);
        }

        document.saveToFile("output.txt");

        document.loadDFromFile("output.txt", propertiesFactory);
        for (Character c : document.getLetters()) {
            System.out.println("[" + c.getLetterProperties().getFont() + "|"
                    + c.getLetterProperties().getSize() + "|"
                    + c.getLetterProperties().getColor() + "]" + c.getLetter());
        }
        System.out.println();
    }
}
