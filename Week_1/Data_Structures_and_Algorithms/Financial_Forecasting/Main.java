public class Main {

    public static double calculateFutureValue(double currentValue, double annualGrowthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue,annualGrowthRate,years - 1)* (1 + annualGrowthRate);
    }

    public static void main(String[] args) {
        double currentValue = 100000.0;
        double annualGrowthRate = 0.08;
        int years = 5;

        double futureValue = calculateFutureValue(currentValue,annualGrowthRate,years);
        System.out.printf("Current Value: %.2f%n", currentValue);
        System.out.printf("Future Value after %d years: %.2f%n",years, futureValue);
    }
}
