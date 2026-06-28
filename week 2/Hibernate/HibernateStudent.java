public class HibernateStudent {

    private int id;
    private String name;

    public HibernateStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
    }
}