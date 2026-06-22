package MVCPatternExample;

public class Main {

    public static void main(String[] args) {

        Student model = new Student();
        model.setName("Shouvik Mondal");
        model.setRollNo("RA2311047010213");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(model, view);

        controller.updateView();
    }
}