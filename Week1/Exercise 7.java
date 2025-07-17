import java.util.*;
import java.text.DecimalFormat;

class FinancialData
{
    private String date;
    private double value;
    
    public FinancialData(String d, double v)
    {
        this.date = d;
        this.value = v;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public double getValue()
    {
        return value;
    }
    
    public void display()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Date: " + date + ", Value: $" + df.format(value));
    }
}

class FinancialForecaster
{
    private ArrayList<FinancialData> historicalData;
    private String dataType;
    
    public FinancialForecaster(String type)
    {
        this.dataType = type;
        this.historicalData = new ArrayList<>();
    }
    
    public void addData(String date, double value)
    {
        historicalData.add(new FinancialData(date, value));
    }
    
    public void displayHistoricalData()
    {
        System.out.println("\n=== Historical " + dataType + " Data ===");
        for (FinancialData data : historicalData)
        {
            data.display();
        }
    }
    
    public double simpleMovingAverage(int periods)
    {
        if (historicalData.size() < periods)
        {
            System.out.println("Not enough data for " + periods + " period moving average");
            return 0;
        }
        
        double sum = 0;
        int startIndex = historicalData.size() - periods;
        
        for (int i = startIndex; i < historicalData.size(); i++)
        {
            sum += historicalData.get(i).getValue();
        }
        
        return sum / periods;
    }
    
    public double linearTrendForecast()
    {
        if (historicalData.size() < 2)
        {
            System.out.println("Need at least 2 data points for trend analysis");
            return 0;
        }
        
        double firstValue = historicalData.get(0).getValue();
        double lastValue = historicalData.get(historicalData.size() - 1).getValue();
        int periods = historicalData.size() - 1;
        
        double trend = (lastValue - firstValue) / periods;
        return lastValue + trend;
    }
    
    public double getAverage()
    {
        if (historicalData.isEmpty()) return 0;
        
        double sum = 0;
        for (FinancialData data : historicalData)
        {
            sum += data.getValue();
        }
        return sum / historicalData.size();
    }
    
    public void generateForecast()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("\n=== " + dataType + " Forecast Report ===");
        System.out.println("Data Points: " + historicalData.size());
        System.out.println("Historical Average: $" + df.format(getAverage()));
        
        if (historicalData.size() >= 3)
        {
            System.out.println("3-Period Moving Average: $" + df.format(simpleMovingAverage(3)));
        }
        
        if (historicalData.size() >= 5)
        {
            System.out.println("5-Period Moving Average: $" + df.format(simpleMovingAverage(5)));
        }
        
        System.out.println("Linear Trend Forecast: $" + df.format(linearTrendForecast()));
        
        double avg = getAverage();
        double trend = linearTrendForecast();
        
        System.out.println("\n=== Recommendation ===");
        if (trend > avg)
        {
            System.out.println("Trend is UPWARD - Consider buying/investing");
        }
        else if (trend < avg)
        {
            System.out.println("Trend is DOWNWARD - Consider selling/caution");
        }
        else
        {
            System.out.println("Trend is STABLE - Hold current position");
        }
    }
}

public class FinancialForecastingSystem
{
    public static void main(String[] args)
    {
        System.out.println("=== Simple Financial Forecasting System ===");
        
        FinancialForecaster stockForecaster = new FinancialForecaster("Stock Price");
        
        stockForecaster.addData("2024-01-01", 100.50);
        stockForecaster.addData("2024-01-02", 102.25);
        stockForecaster.addData("2024-01-03", 101.75);
        stockForecaster.addData("2024-01-04", 105.00);
        stockForecaster.addData("2024-01-05", 107.50);
        stockForecaster.addData("2024-01-06", 106.25);
        stockForecaster.addData("2024-01-07", 109.00);
        
        stockForecaster.displayHistoricalData();
        stockForecaster.generateForecast();
        
        System.out.println("\n" + "=".repeat(50));
        
        FinancialForecaster revenueForecaster = new FinancialForecaster("Monthly Revenue");
        
        revenueForecaster.addData("Jan-2024", 50000);
        revenueForecaster.addData("Feb-2024", 52000);
        revenueForecaster.addData("Mar-2024", 48000);
        revenueForecaster.addData("Apr-2024", 55000);
        revenueForecaster.addData("May-2024", 58000);
        
        revenueForecaster.displayHistoricalData();
        revenueForecaster.generateForecast();
    }
}