package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    @JsonProperty("Tid")
    private String transactionId;
    @JsonProperty("PaymentId")
    private String paymentId;
    @JsonProperty("Status")
    private String paymentStatus;
    @JsonProperty("MerchantOrderId")
    private String manyPayTransactionId;
    @JsonProperty("ReturnCode")
    private String transactionReturnCode;
    @JsonProperty("ReturnMessage")
    private String transactionReturnMessage;
    @JsonProperty("Payment")
    private Payment payment;
    @JsonProperty("Links")
    private List<Link> links;

    public Transaction() {}

    public Transaction(String transactionId, String paymentId, String paymentStatus, String manyPayTransactionId, String transactionReturnCode,
                       String transactionReturnMessage,Payment payment) {
        this.transactionId = transactionId;
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
        this.manyPayTransactionId = manyPayTransactionId;
        this.transactionReturnCode = transactionReturnCode;
        this.transactionReturnMessage = transactionReturnMessage;
        this.payment = payment;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getManyPayTransactionId() {
        return this.manyPayTransactionId;
    }

    public void setManyPayTransactionId(String manyPayTransactionId) {
        this.manyPayTransactionId = manyPayTransactionId;
    }

    public String getTransactionReturnCode() {
        return this.transactionReturnCode;
    }

    public void setTransactionReturnCode(String transactionReturnCode) {
        this.transactionReturnCode = transactionReturnCode;
    }

    public String getTransactionReturnMessage() {
        return this.transactionReturnMessage;
    }

    public void setTransactionReturnMessage(String transactionReturnMessage) {
        this.transactionReturnMessage = transactionReturnMessage;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + this.transactionId + '\'' +
                ", paymentId='" + this.paymentId + '\'' +
                ", paymentStatus='" + this.paymentStatus + '\'' +
                ", manyPayTransactionId='" + this.manyPayTransactionId + '\'' +
                ", transactionReturnCode='" + this.transactionReturnCode + '\'' +
                ", transactionReturnMessage='" + this.transactionReturnMessage + '\'' +
                ", payment=" + this.payment +
                '}';
    }
}
