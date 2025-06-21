package Week1.MVCPatternExample;

public class Main {
    public static void main(String[] args) {
        // Create model and view
        Student model = new Student("Aparna", "CSE001", "A");
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(model, view);

        // Initial display
        controller.updateView();

        // Update student details
        controller.setStudentName("Aparna Uppala");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
