package com.cpro.accounts.mongo.domain.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    GENERIC_ERROR("999"),
    NOT_FOUND("404"),
    CANNOT_GET("100"),
    CANNOT_CREATE("101"),

            ;

    private String code;

}
