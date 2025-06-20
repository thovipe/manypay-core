package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    @JsonProperty("Installments")
    private int numberOfInstallments;
    @JsonProperty("Amount")
    private int paymentAmount;

    public Payment() {}

    public Payment(int numberOfInstallments,
                   int paymentAmount) {
        this.numberOfInstallments = numberOfInstallments;
        this.paymentAmount = paymentAmount;
    }

    public int getNumberOfInstallments() {
        return this.numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public int getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
       this.paymentAmount = paymentAmount;
    }

}
