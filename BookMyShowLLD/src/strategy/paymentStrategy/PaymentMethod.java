package strategy.paymentStrategy;

/**
 * The interface Payment method.
 */
public interface PaymentMethod {
    /**
     * Initiate payment boolean.
     *
     * @param amount the amount
     * @return the boolean
     */
    boolean initiatePayment(int amount);
}
