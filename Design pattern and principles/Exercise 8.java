public class StrategyPatternExample {

    interface PaymentStrategy {
        void pay(double amount);
    }

    class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
        }
    }

    class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using PayPal account: " + email);
        }
    }

    class PaymentContext {
        private PaymentStrategy strategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void pay(double amount) {
            if (strategy != null) {
                strategy.pay(amount);
            } else {
                System.out.println("No payment strategy selected.");
            }
        }
    }

    public static void main(String[] args) {
        StrategyPatternExample app = new StrategyPatternExample();

        PaymentContext context = app.new PaymentContext();

        context.setPaymentStrategy(app.new CreditCardPayment("1234-5678-9012-3456"));
        context.pay(2500.0);

        context.setPaymentStrategy(app.new PayPalPayment("user@example.com"));
        context.pay(1800.0);
    }
}