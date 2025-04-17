package com.example.tmf629.model.partyref;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields
@Data
public class PartyRef {
    private String href;
    @NotBlank(message = "Field 'id' is required")
    private String id;
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    private PartyType referredType; // Individual or Organization

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    @NotBlank(message = "Field '@type' is required")
    private String type;
}

enum PartyType {
    Individual,
    Organization,
}
