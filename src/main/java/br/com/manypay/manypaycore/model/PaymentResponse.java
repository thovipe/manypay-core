package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse {
    @JsonProperty("MerchantOrderId")
    private String merchantOrderId;
    @JsonProperty("Customer")
    private Customer customer;
    @JsonProperty("Payment")
    private Transaction transaction;

    public PaymentResponse() {}

    public String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "merchantOrderId='" + this.merchantOrderId + '\'' +
                ", customer=" + this.customer +
                ", transaction=" + this.transaction +
                '}';
    }
}
