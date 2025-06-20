package br.com.manypay.manypaycore.model;

public class DebitStrategy implements PaymentStrategy {

    private int amountFee;

    @Override
    public void paymentType() {
            this.amountFee = 0;
    }

    @Override
    public String getPaymentType() {
        return "DebitCard" ;
    }

    public int getAmountFee() {
        return this.amountFee;
    }
}
