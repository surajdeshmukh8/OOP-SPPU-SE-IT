public class StrategyPatternExample {

    // PaymentStrategy Interface
    public interface PaymentStrategy {
        void pay(double amount);
    }

    // Concrete Strategy: CreditCardPayment
    public static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;

        public CreditCardPayment(String cardNumber, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        }
    }

    // Concrete Strategy: PayPalPayment
    public static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal account: " + email);
        }
    }

    // Concrete Strategy: BitcoinPayment
    public static class BitcoinPayment implements PaymentStrategy {
        private String bitcoinAddress;

        public BitcoinPayment(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Bitcoin address: " + bitcoinAddress);
        }
    }

    // ShoppingCart Class that uses the PaymentStrategy
    public static class ShoppingCart {
        private PaymentStrategy paymentStrategy;
        private double totalAmount;

        public ShoppingCart(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout() {
            if (paymentStrategy == null) {
                System.out.println("Please choose a payment method.");
                return;
            }
            paymentStrategy.pay(totalAmount);
        }
    }

    // Main Method to test the Strategy Pattern
    public static void main(String[] args) {
        // Create a shopping cart with total amount 100.0
        ShoppingCart cart = new ShoppingCart(100.0);
        
        // Use Credit Card payment
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "Suraj Deshmukh");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(); 
        
        // Use PayPal payment
        PaymentStrategy paypal = new PayPalPayment("surajdeshmukh@temp.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout(); 
        
        // Use Bitcoin payment
        PaymentStrategy bitcoin = new BitcoinPayment("surr8_PS");
        cart.setPaymentStrategy(bitcoin);
        cart.checkout(); 
    }
}
