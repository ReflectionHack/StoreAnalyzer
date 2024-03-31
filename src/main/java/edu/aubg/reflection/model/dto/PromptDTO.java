package edu.aubg.reflection.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromptDTO {
    @JsonProperty(required = true)
    private String prompt;
}
