package org.senai.dih.feignapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PeopleDTO(String name, String height, String mass, @JsonProperty("hair_color") String hairColor) {
}
