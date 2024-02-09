import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Textbook> textbooks;
    private ArrayList<Instructor> instructors;

    public Course(String name) {
        this.name = name;
        textbooks = new ArrayList<Textbook>();
        instructors = new ArrayList<Instructor>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Textbook> getTextbooks() {
        return textbooks;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTextbook(Textbook textbook) {
        textbooks.add(textbook);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Course: " + name + "\n");
        result.append("Textbooks:\n");
        for (Textbook textbook : textbooks) {
            result.append(textbook);
            if (textbooks.indexOf(textbook) != textbooks.size() - 1) {
                result.append(", ");
            }
        }
        result.append("Instructors:\n");
        for (Instructor instructor : instructors) {
            result.append(instructor);
            if (instructors.indexOf(instructor) != instructors.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
