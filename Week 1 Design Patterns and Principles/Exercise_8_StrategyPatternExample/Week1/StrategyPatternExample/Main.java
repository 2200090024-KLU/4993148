package Week1.StrategyPatternExample;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
        context.setPaymentStrategy(creditCard);
        context.payAmount(1500.00);

        System.out.println("-----");

        // Using PayPal
        PaymentStrategy paypal = new PayPalPayment("user@example.com");
        context.setPaymentStrategy(paypal);
        context.payAmount(2000.00);
    }
}
