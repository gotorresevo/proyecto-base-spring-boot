package com.evobank.architecture.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class IOError {
    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("userMessage")
    private String userMessage;
    @JsonProperty("technicalMessage")
    private String technicalMessage;
}

