package com.example;

public class App {
    public double calculateBill(String planType, double dataUsedGB) {
        double baseCost = 0.0;
        double dataLimit = 0.0;
        double overageRatePerGB = 10.0; // Extra charge rate

        switch (planType.toLowerCase()) {
            case "basic":
                baseCost = 20.0;
                dataLimit = 50.0;
                break;
            case "standard":
                baseCost = 35.0;
                dataLimit = 150.0;
                break;
            case "premium":
                baseCost = 50.0;
                dataLimit = 300.0;
                break;
            default:
                throw new IllegalArgumentException("Unknown Plan Type");
        }

        double totalBill = baseCost;
        if (dataUsedGB > dataLimit) {
            double extraUsage = dataUsedGB - dataLimit;
            totalBill += extraUsage * overageRatePerGB;
        }
        return totalBill;
    }

    public static void main(String[] args) {
        App app = new App();
        
        // Mock arrays mimicking customer processing loops
        String[] names = {"Alice", "Bob", "Charlie"};
        String[] plans = {"basic", "standard", "premium"};
        double[] usage = {55.0, 120.0, 350.0}; 

        System.out.println("=== Internet Data Usage Billing Details ===");
        for (int i = 0; i < names.length; i++) {
            double bill = app.calculateBill(plans[i], usage[i]);
            System.out.println("Customer: " + names[i] + " | Plan: " + plans[i] + " | Usage: " + usage[i] + "GB | Total Bill: $" + bill);
        }
    }
}
