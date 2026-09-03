package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testBasicPlanWithOverage() {
        App app = new App();
        // Basic plan cost $20 (50GB limit). 55GB used means 5GB overage * $10 = $50. Total = $70.
        assertEquals(70.0, app.calculateBill("basic", 55.0), 0.001);
    }

    @Test
    public void testPremiumPlanWithinLimit() {
        App app = new App();
        // Premium plan cost $50 (300GB limit). 250GB used is within limits. Total = $50.
        assertEquals(50.0, app.calculateBill("premium", 250.0), 0.001);
    }
}

