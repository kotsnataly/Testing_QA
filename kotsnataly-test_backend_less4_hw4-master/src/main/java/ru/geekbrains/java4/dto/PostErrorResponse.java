package ru.geekbrains.java4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostErrorResponse extends CommonResponse<PostErrorResponse.ErrorDetails> {

    @Data
    public static class ErrorDetails {

        @JsonProperty("error")
        public String error;
        @JsonProperty("request")
        public String request;
        @JsonProperty("method")
        public String method;
    }
}
