public class Main {

    public static void main(String[] args) {

        Student student =
                new Student(101, "Shouvik Mondal");

        StudentRepository repository =
                new StudentRepository();

        repository.save(student);
    }
}