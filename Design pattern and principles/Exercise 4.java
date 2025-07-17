public class AdapterPatternExample {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    class PayPalGateway {
        void sendPayment(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal.");
        }
    }

    class StripeGateway {
        void makePayment(double amount) {
            System.out.println("Paid ₹" + amount + " using Stripe.");
        }
    }

    class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal = new PayPalGateway();

        public void processPayment(double amount) {
            paypal.sendPayment(amount);
        }
    }

    class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe = new StripeGateway();

        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    public static void main(String[] args) {
        AdapterPatternExample app = new AdapterPatternExample();

        PaymentProcessor paypal = app.new PayPalAdapter();
        paypal.processPayment(500.0);

        PaymentProcessor stripe = app.new StripeAdapter();
        stripe.processPayment(1200.0);
    }
}
