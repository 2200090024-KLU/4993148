package Week1.AdapterPatternExample;

public class PayPalGateway {
    public void makePayPalPayment(double amount) {
        System.out.println("Paying ₹" + amount + " using PayPal.");
    }
}
