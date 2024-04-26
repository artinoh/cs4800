public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        document.insertString("Hello");
        document.changeDefaultProperty("Calibri", 14, "Blue");
        document.insertString("World");
        document.changeDefaultProperty("Verdana", 16, "Black");
        document.insertString("CS");
        document.changeDefaultProperty("Arial", 12, "Red");
        document.insertString("4800");

        document.print();
        document.save("HomeworkSeven.txt");

        Document loadedDocument = new Document();
        loadedDocument.load("LoadExample.txt");
    }
}