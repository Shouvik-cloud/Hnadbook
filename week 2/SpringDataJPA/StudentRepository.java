public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved successfully.");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
    }
}