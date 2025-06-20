package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DebitPayment extends Payment implements CardPayment {

    @JsonProperty("Type")
    private String paymentType;
    @JsonProperty("DebitCard")
    private CreditCard debitCard;
    private PaymentStrategy paymentStrategy;

    public DebitPayment() {
        super();
    }
    public DebitPayment(int numberOfInstallments, int paymentAmount, PaymentStrategy paymentStrategy) {
        super();
        super.setNumberOfInstallments(numberOfInstallments);
        super.setPaymentAmount(paymentAmount);
        this.paymentStrategy = paymentStrategy;
    }

    public DebitPayment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setCardDetails(CreditCard debitCard){
        this.debitCard = debitCard;
    }

    public String getPaymentStrategy() {
        return this.paymentType = paymentStrategy.getPaymentType();
    }
}
