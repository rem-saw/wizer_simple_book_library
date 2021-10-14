package com.wizer.wizer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author samuel.sawyerr
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenRes<T> {
    private String responseCode ;
    private String responseMesssage;
    private T data;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMesssage() {
        return responseMesssage;
    }

    public void setResponseMesssage(String responseMesssage) {
        this.responseMesssage = responseMesssage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
