package br.com.manypay.manypaycore.model;

public interface PaymentStrategy {

    public void paymentType();
    public String getPaymentType();
    public int getAmountFee();

}
