package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditPayment extends Payment implements CardPayment {

    @JsonProperty("Type")
    private String paymentType;
    @JsonProperty("Capture")
    private boolean isCaptureEnabled;
    @JsonProperty("CreditCard")
    private CreditCard creditCard;
    private PaymentStrategy paymentStrategy;

    public CreditPayment(int numberOfInstallments, int paymentAmount, PaymentStrategy paymentStrategy, boolean isCaptureEnabled) {
        super();
        super.setNumberOfInstallments(numberOfInstallments);
        super.setPaymentAmount(paymentAmount);
        this.paymentStrategy = paymentStrategy;
        this.isCaptureEnabled = isCaptureEnabled;
    }

    public CreditPayment(PaymentStrategy paymentStrategy) {
        super();
        this.paymentStrategy = paymentStrategy;
    }

    public String getPaymentStrategy() {
        return this.paymentType = paymentStrategy.getPaymentType();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setIsCaptureEnabled(boolean isCaptureEnabled) {
        this.isCaptureEnabled = isCaptureEnabled;
    }

    public void setCardDetails(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setPaymentAmount(int paymentAmount) {
        super.setPaymentAmount(paymentAmount + paymentStrategy.getAmountFee());
    }

}
