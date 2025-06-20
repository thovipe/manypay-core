package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("Name")
    private String name;

    public Customer() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + this.name + '\'' +
                '}';
    }
}
