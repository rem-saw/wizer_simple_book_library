package com.wizer.wizer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author samuel.sawyerr
 */
@Data
public class ErrorValidationResponse {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Message")
    private List<String> messages;

    public ErrorValidationResponse(String Code, String messages) {
        this.code = Code;
        this.messages = new ArrayList<>();
        this.messages.add(messages);
    }

    public ErrorValidationResponse(String Code, List<String> messages) {
        this.code = Code;
        this.messages = messages;
    }
}
