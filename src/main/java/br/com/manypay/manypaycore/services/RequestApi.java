package br.com.manypay.manypaycore.services;

import br.com.manypay.manypaycore.providers.PaymentProvider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestApi {

    private PaymentProvider paymentProvider;

    public RequestApi() {}

    public RequestApi(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    public String CreateRequestApi(String endpoint, String stringtransaction) {

        HttpResponse<String> apiResponse = null;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createRequest = HttpRequest.newBuilder().
                uri(URI.create(paymentProvider.transactionUri() + endpoint))
                .header("MerchantId", paymentProvider.getMerchantId())
                .header("MerchantKey", paymentProvider.getMerchantKey())
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(stringtransaction))
                .timeout(Duration.ofSeconds(30))
                .build();

        try {
            apiResponse = httpClient.send(createRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String requestResponse = apiResponse.body();

        return requestResponse;
    }

    public String QueryRequestApi(String endpoint, String transactionId) {

        HttpResponse<String> apiResponse = null;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createRequest = HttpRequest.newBuilder().
                uri(URI.create(paymentProvider.queryUri() + endpoint + transactionId))
                .header("MerchantId", paymentProvider.getMerchantId())
                .header("MerchantKey", paymentProvider.getMerchantKey())
                .header("Content-Type", "application/json")
                .GET()
                .timeout(Duration.ofSeconds(30))
                .build();

        try {
            apiResponse = httpClient.send(createRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String requestResponse = apiResponse.body();

        return requestResponse;
    }

    public String CancelRequestApi(String endpoint, String transactionId) {

        HttpResponse<String> apiResponse = null;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest createRequest = HttpRequest.newBuilder().
                uri(URI.create(paymentProvider.transactionUri() + endpoint + transactionId +"/void"))
                .header("MerchantId", paymentProvider.getMerchantId())
                .header("MerchantKey", paymentProvider.getMerchantKey())
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(30))
                .build();

        try {
            apiResponse = httpClient.send(createRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String requestResponse = apiResponse.body();

        return requestResponse;
    }
}
