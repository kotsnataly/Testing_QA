package ru.geekbrains.java4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ImgurPostErrorResponse extends CommonResponse<ImgurPostErrorResponse> {
    @JsonProperty("error")
    public ErrorDetails errorDetails;
    @JsonProperty("request")
    public String request;
    @JsonProperty("method")
    public String method;

    @Data
    public static class ErrorDetails {
        @JsonProperty("code")
        public Integer code;
        @JsonProperty("message")
        public String message;
        @JsonProperty("type")
        public String type;
        @JsonProperty("exception")
        public List<String> exception = new ArrayList<String>();


    }
}