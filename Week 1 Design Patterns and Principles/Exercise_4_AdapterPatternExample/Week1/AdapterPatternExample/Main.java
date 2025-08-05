package Week1.AdapterPatternExample;

public class Main {
    public static void main(String[] args) {
        // PayPal Adapter
        PayPalGateway paypalGateway = new PayPalGateway();
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypalGateway);
        paypalAdapter.processPayment(500.0);

        // Stripe Adapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        stripeAdapter.processPayment(999.0);
    }
}
