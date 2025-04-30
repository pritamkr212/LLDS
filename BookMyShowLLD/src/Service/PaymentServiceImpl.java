package Service;

import strategy.paymentStrategy.CashPayment;
import strategy.paymentStrategy.CreditCardPayment;
import strategy.paymentStrategy.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        PaymentMethod paymentMethod = new CashPayment();
        paymentMethod.initiatePayment(amount);
    }

    @Override
    public void acceptCard(String cardNumber, int cvv, int amount) {
        PaymentMethod paymentMethod = new CreditCardPayment(cardNumber, cvv);
        paymentMethod.initiatePayment(amount);
    }
}
