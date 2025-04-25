package strategy.paymentStrategy;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private int cvv;

    public CreditCardPayment(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        // Calling Third partyApi
        // phonePayService(amount, cardNumber, cvv);
        return true;
    }
}
