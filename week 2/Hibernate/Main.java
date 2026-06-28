public class Main {

    public static void main(String[] args) {

        HibernateUtil.connect();

        HibernateStudent student =
                new HibernateStudent(101, "Shouvik Mondal");

        student.display();
    }
}