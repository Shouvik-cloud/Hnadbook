package DecoratorPatternExample;

public class Main {

    public static void main(String[] args) {

        Notifier notifier = new SMSDecorator(new EmailNotifier());

        notifier.send("Hello User!");
    }
}