package br.com.manypay.manypaycore.model;

public interface ModelPayment {

    public void setPaymentStrategy(PaymentStrategy paymentStrategy);
    public String getPaymentStrategy();
}
