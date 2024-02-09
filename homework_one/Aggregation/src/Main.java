public class Main {
    public static void main(String[] args) {
        Instructor professorNima = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor professorJohn = new Instructor("Keivan", "Navi", "3-2637");

        Textbook cleanCode = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook designPatterns = new Textbook("Design Patterns", "Erich Gamma", "Addison-Wesley");

        Course softwareEngineering = new Course("Software Engineering");
        softwareEngineering.addInstructor(professorNima);
        softwareEngineering.addInstructor(professorJohn);
        softwareEngineering.addTextbook(cleanCode);
        softwareEngineering.addTextbook(designPatterns);

        softwareEngineering.print();


    }
}