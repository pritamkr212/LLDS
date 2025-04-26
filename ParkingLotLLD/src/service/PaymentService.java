package service;

/**
 * The interface Payment service.
 */
public interface PaymentService {
    /**
     * Accept cash.
     *
     * @param amount the amount
     */
    void acceptCash(int amount);

    /**
     * Accept credit card.
     *
     * @param cardNumber the card number
     * @param cvv        the cvv
     * @param amount     the amount
     */
    void acceptCard(String cardNumber, int cvv, int amount);
}
