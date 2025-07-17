public class FinancialForecasting {

    public static double forecastRecursive(double currentValue, double rate, int years) {
        if (years == 0) return currentValue;
        return forecastRecursive(currentValue, rate, years - 1) * (1 + rate);
    }

    public static double forecastMemo(double currentValue, double rate, int years, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(currentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double rate = 0.10; // 10% growth
        int years = 5;

        System.out.println("Forecast using simple recursion:");
        double result1 = forecastRecursive(currentValue, rate, years);
        System.out.println("Value after " + years + " years = $" + result1);

        System.out.println("\nForecast using memoized recursion:");
        double[] memo = new double[years + 1];
        double result2 = forecastMemo(currentValue, rate, years, memo);
        System.out.println("Value after " + years + " years = $" + result2);
    }
}

/*
Step 1: Recursion
- A function that calls itself to solve sub-problems.
- Good for problems like factorial, Fibonacci, and compound calculations.

Step 4: Time Complexity
- forecastRecursive: O(n) due to n recursive calls.
- forecastMemo:     O(n) with caching of sub-results, avoids redundant computation.

Optimization:
- Use memoization or convert to iteration for performance.
- Avoid deep recursion in large inputs to prevent stack overflow.

Conclusion:
Recursion makes financial forecasting logic simple and readable.
For better performance, prefer memoization or iterative approach in real systems.
*/
