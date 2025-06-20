package br.com.manypay.manypaycore.providers;

public abstract class PaymentProvider {

    private String uri;
    private String merchantId;
    private String merchantKey;

    public abstract String transactionUri();
    public abstract String queryUri();
    public abstract String getMerchantId();
    public abstract String getMerchantKey();
}
