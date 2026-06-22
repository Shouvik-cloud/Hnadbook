package ObserverPatternExample;

public class MobileClient implements Observer {

    private String name;

    public MobileClient(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + " received temperature update: " + temperature + "°C");
    }
}