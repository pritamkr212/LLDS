package com.demo.paymentMethodsStrategy;

public class Cash implements PaymentMethod{
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by cash of Rs " + amount);
        return true;
    }
}
