package br.com.manypay.manypaycore.providers;

public class CieloProvider extends PaymentProvider {

    private String transactionUri;
    private String queryUri;
    private String merchantId;
    private String merchantKey;

    public CieloProvider(String transactionUri, String queryUri, String merchantId, String merchantKey) {
        this.transactionUri = transactionUri;
        this.queryUri = queryUri;
        this.merchantId = merchantId;
        this.merchantKey = merchantKey;
    }

    @Override
    public String transactionUri() {
        return this.transactionUri;
    }

    public String queryUri() {
        return this.queryUri;
    }
    @Override
    public String getMerchantId() {
        return this.merchantId;
    }
    @Override
    public String getMerchantKey() {
        return this.merchantKey;
    }
}
