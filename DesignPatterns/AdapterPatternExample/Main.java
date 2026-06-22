package AdapterPatternExample;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PayPalAdapter();

        paymentProcessor.processPayment(5000);
    }
}