package br.com.manypay.manypaycore.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseObject {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> String WriteJson (Object objectToWrite) throws JsonProcessingException {

        this.objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        this.objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
        this.objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY);

        try {
           return objectMapper.writeValueAsString(objectToWrite);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T ReadJson (String json, Class<T> classOfT) throws JsonProcessingException {
        return this.objectMapper.readValue(json, classOfT);
    }
}
