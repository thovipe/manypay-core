package br.com.manypay.manypaycore.services;

import br.com.manypay.manypaycore.model.*;
import br.com.manypay.manypaycore.providers.PaymentProvider;
import br.com.manypay.manypaycore.repository.SingletonFileHandler;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacadeTransaction {

    private PaymentProvider paymentProvider;
    private RequestApi api;
    private PaymentStrategy strategy;
    private CreditCard creditCard;
    private CreditPayment payment;
    private Transaction transaction = new Transaction();
    private SingletonFileHandler singletonFileHandler;
    private ParseObject objectToParse = new ParseObject();
    private String transactionString;
    private List<String> transactions = new ArrayList<>();
    private  String transactionsFileName;

    public FacadeTransaction(PaymentProvider paymentProvider, RequestApi api, PaymentStrategy strategy, CreditCard creditCard, CreditPayment payment) {
        this.paymentProvider = paymentProvider;
        this.api = api;
        this.strategy = strategy;
        this.creditCard = creditCard;
        this.payment = payment;
    }

    public void sendTransactionToAcquirer() throws IOException {
        this.strategy.paymentType();
        this.payment.setPaymentAmount(this.payment.getPaymentAmount());
        this.payment.setNumberOfInstallments(this.payment.getNumberOfInstallments());
        this.payment.setIsCaptureEnabled(true);
        this.payment.setCardDetails(creditCard);
        this.transaction.setManyPayTransactionId(UUID.randomUUID().toString());
        this.transaction.setPayment(this.payment);
        this.transactionString = objectToParse.WriteJson(transaction);
        System.out.println("Sent transaction to acquirer: " + transactionString);
        String transactionResponse = this.api.CreateRequestApi("/1/sales", this.transactionString);
        transactions.add(transactionResponse);
        System.out.println("Response from acquirer: " + transactionResponse);
        this.transactionsFileName = "transactions_" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now()) + ".json";
        if(!transactionResponse.isEmpty()){
            SingletonFileHandler.getInstance().createFile(this.transactionsFileName);
            SingletonFileHandler.getInstance().writeToFile(this.transactions, this.transactionsFileName);
        }
    }

    public void queryTransactionDataOnAcquirer() throws IOException {
        transactions.stream().forEach(transaction -> {
            try {
                var transationToQuery = objectToParse.ReadJson(transaction.toString(), PaymentResponse.class);
                System.out.println("Query transaction: " + transationToQuery.getTransaction().getPaymentId());
                String transactionResponse1 = this.api.QueryRequestApi("/1/sales/", transationToQuery.getTransaction().getPaymentId());
                System.out.println("Response from query: " + transactionResponse1);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void readTransactionLog() throws IOException {
        try {
            SingletonFileHandler.getInstance().readFromFile(this.transactionsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

