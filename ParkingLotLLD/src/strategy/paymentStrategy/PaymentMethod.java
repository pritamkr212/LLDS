package strategy.paymentStrategy;

public interface PaymentMethod {
    boolean initiatePayment(int amount);
}
