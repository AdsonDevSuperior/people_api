package com.example.person.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Access;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
