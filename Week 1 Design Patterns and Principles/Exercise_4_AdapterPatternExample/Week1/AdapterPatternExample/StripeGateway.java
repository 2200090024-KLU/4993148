package Week1.AdapterPatternExample;

public class StripeGateway {
    public void stripePay(double value) {
        System.out.println("Paying ₹" + value + " using Stripe.");
    }
}
