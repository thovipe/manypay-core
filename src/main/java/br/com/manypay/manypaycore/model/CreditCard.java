package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {

    @JsonProperty("CardNumber")
    private String creditCardNumber;
    @JsonProperty("Holder")
    private String creditCardHolderName;
    @JsonProperty("ExpirationDate")
    private String creditCardExpirationDate;
    @JsonProperty("SecurityCode")
    private String creditCardSecurityCode;
    @JsonProperty("Brand")
    private String creditCardBrand;

    public CreditCard() {}

    public CreditCard(String creditCardNumber, String creditCardHolderName, String creditCardExpirationDate,
                      String creditCardSecurityCode, String creditCardBrand) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardHolderName = creditCardHolderName;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
        this.creditCardBrand = creditCardBrand;
    }

    public String getcreditCardNumber() {
        return creditCardNumber;
    }

    @JsonSetter(("CardNumber"))
    public void setcreditCardNumber(String creditCardNumber) {
        creditCardNumber = creditCardNumber;
    }

    public String getcreditCardHolderName() {
        return creditCardHolderName;
    }

    @JsonSetter("Holder")
    public void setcreditCardHolderName(String creditCardHolderName) {
        creditCardHolderName = creditCardHolderName;
    }

    public String getcreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    @JsonSetter("ExpirationDate")
    public void setcreditCardExpirationDate(String creditCardExpirationDate) {
        creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getcreditCardSecurityCode() {
        return this.creditCardSecurityCode;
    }

    @JsonSetter("SecurityCode")
    public void setcreditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
    }

    public String getcreditCardBrand() {
        return this.creditCardBrand;
    }

    @JsonSetter("Brand")
    public void setcreditCardBrand(String creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNumber='" + this.creditCardNumber + '\'' +
                ", creditCardHolderName='" + this.creditCardHolderName + '\'' +
                ", creditCardExpirationDate='" + this.creditCardExpirationDate + '\'' +
                ", creditCardSecurityCode='" + this.creditCardSecurityCode + '\'' +
                ", creditCardBrand='" + this.creditCardBrand + '\'' +
                '}';
    }
}
