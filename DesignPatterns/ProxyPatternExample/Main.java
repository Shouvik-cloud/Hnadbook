package ProxyPatternExample;

public class Main {

    public static void main(String[] args) {

        Image image = new ProxyImage("sample.jpg");

        // Image will be loaded from disk only once
        image.display();

        System.out.println();

        // Image will not be loaded again
        image.display();
    }
}