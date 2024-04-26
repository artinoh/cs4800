import java.util.ArrayList;
import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

public class Document {
    private ArrayList<SimpleEntry<Character, CharacterProperty>> characters = new ArrayList<>();
    private CharacterProperty defaultProperty;

    public Document() {
        defaultProperty = CharacterPropertyFactory.getCharacterProperty("Arial", 12, "Black");
    }

    public CharacterProperty getDefaultProperty() {
        return defaultProperty;
    }

    public ArrayList<SimpleEntry<Character, CharacterProperty>> getCharacters() {
        return characters;
    }

    public void changeDefaultProperty(CharacterProperty property) {
        defaultProperty = property;
    }

    public void changeDefaultProperty(String font, int size, String color) {
        defaultProperty = CharacterPropertyFactory.getCharacterProperty(font, size, color);
    }

    public void insert(char c, CharacterProperty property) {
        characters.add(new SimpleEntry<>(c, property));
    }

    public void insert(char c) {
        characters.add(new SimpleEntry<>(c, defaultProperty));
    }

    public void insertString(String s) {
        for (char c : s.toCharArray()) {
            insert(c);
        }
    }

    public void insertString(String s, CharacterProperty property) {
        for (char c : s.toCharArray()) {
            insert(c, property);
        }
    }

    public void pop() {
        if (!characters.isEmpty()) {
            characters.removeLast();
        }
    }

    public void save(String filename) {
        System.out.println("Saving to " + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Simply write the output of toString to the file
            writer.write(this.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while saving the document: " + e.getMessage());
        }
    }

    public void  modifyAt(int index, CharacterProperty property) {
        if (index >= 0 && index < characters.size()) {
            characters.get(index).setValue(property);
        }
    }

    public void load(String filename) {
        System.out.println("\nLoading from " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {

                //Parse property lines stored at bottom
                //CharacterProperty|Arial,12,Black|0,1,2,3,4,5,6,7,8,9,10,11,12
                if (line.startsWith("CharacterProperty")) {
                    String[] parts = line.split("\\|");
                    String[] propertyParts = parts[1].split(",");
                    CharacterProperty property = CharacterPropertyFactory.getCharacterProperty(propertyParts[0], Integer.parseInt(propertyParts[1]), propertyParts[2]);
                    String[] indexes = parts[2].split(",");
                    for (String index : indexes) {
                        modifyAt(Integer.parseInt(index), property);
                    }
                } else {
                    for (char c : line.toCharArray()) {
                        insert(c);
                    }

                }
            }
        }
        catch(IOException e) {
                System.out.println("An error occurred." + e.getMessage());
        }
        print();
    }


    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder documentSb = new StringBuilder();
        StringBuilder propertySb = new StringBuilder();
        HashMap<CharacterProperty, ArrayList<Integer>> properties = new HashMap<>();
        for (int i = 0; i < characters.size(); i++) {
            SimpleEntry<Character, CharacterProperty> entry = characters.get(i);
            documentSb.append(entry.getKey());
            if (!properties.containsKey(entry.getValue())) {
                properties.put(entry.getValue(), new ArrayList<>());
            }
            properties.get(entry.getValue()).add(i);
        }
        propertySb.append("\n\n");
        for (CharacterProperty property : properties.keySet()) {
            propertySb.append(property.toString());
            for (int index : properties.get(property)) {
                propertySb.append(index).append(",");
            }
            propertySb.deleteCharAt(propertySb.length() - 1);
            propertySb.append("\n");
        }
        return documentSb.toString() + "\n" + propertySb.toString();
    }

}
