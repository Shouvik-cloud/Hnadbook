package StrategyPatternExample;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(5000);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(3000);
    }
}