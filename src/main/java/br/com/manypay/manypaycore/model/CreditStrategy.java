package br.com.manypay.manypaycore.model;

public class CreditStrategy implements PaymentStrategy {

    private int amountFee;
    @Override
    public void paymentType() {
            this.amountFee = 100;
    }

    @Override
    public String getPaymentType() {
        return "CreditCard" ;
    }

    @Override
    public int getAmountFee() {
        return this.amountFee;
    }
}
