package br.com.manypay.manypaycore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

        @JsonProperty("Method")
        private String method;

        @JsonProperty("Rel")
        private String rel;

        @JsonProperty("Href")
        private String href;

        public Link() {}

        public String getMethod() {
            return this.method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getRel() {
            return this.rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getHref() {
            return this.href;
        }

        public void setHref(String href) {
            this.href = href;
        }

    @Override
    public String toString() {
        return "Link{" +
                "method='" + this.method + '\'' +
                ", rel='" + this.rel + '\'' +
                ", href='" + this.href + '\'' +
                '}';
    }
}

