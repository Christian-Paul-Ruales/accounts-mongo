package com.cpro.accounts.mongo.application.dto;

import com.cpro.accounts.mongo.domain.constants.ErrorEnum;
import lombok.Builder;

@Builder(toBuilder = true)
public record Error(
        ErrorEnum errorEnum,
        String message
){}
