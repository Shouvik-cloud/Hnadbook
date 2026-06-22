package ObserverPatternExample;

public class Main {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        Observer mobile1 = new MobileClient("Mobile 1");
        Observer mobile2 = new MobileClient("Mobile 2");

        weatherStation.registerObserver(mobile1);
        weatherStation.registerObserver(mobile2);

        weatherStation.setTemperature(32.5f);
    }
}