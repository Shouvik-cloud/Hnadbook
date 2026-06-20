package FinancialForecasting;

public class Main {

    static double forecast(double currentValue,
                           double growthRate,
                           int years) {

        if (years == 0) {
            return currentValue;
        }

        return forecast(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }

    public static void main(String[] args) {

        double futureValue =
                forecast(10000, 0.10, 5);

        System.out.println(
                "Future Value after 5 years = "
                        + futureValue
        );
    }
}