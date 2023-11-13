package org.senai.dih.unirestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PeopleDTO(String name, String height, String mass, @JsonProperty("hair_color") String hairColor) {
}
