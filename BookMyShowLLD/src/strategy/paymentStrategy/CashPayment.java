package strategy.paymentStrategy;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Making Payment Done by Cash with amount " + amount);
        return true;
    }
}
