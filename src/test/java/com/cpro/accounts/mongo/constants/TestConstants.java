package com.cpro.accounts.mongo.constants;

import com.cpro.accounts.mongo.domain.model.Account;

import java.math.BigDecimal;

public class TestConstants {
    public static final String ID = "testunitario1";
    public static final String NAME = "nameAccount";
    public static final BigDecimal VALUE = BigDecimal.valueOf(1000.00);
    public static final BigDecimal MAX_VALUE_TRANSFER = BigDecimal.valueOf(15000.00);
    public static final String IDENTIFICATION = "1700000000";
    public static final int DEFAULT_INSTANTANTION = 1;

    public static final Account ACCOUNT_TEMPLATE = Account.builder()
            .id(ID)
            .name(NAME)
            .value(VALUE)
            .ownerIdentification(IDENTIFICATION)
            .maxValueTransfer(MAX_VALUE_TRANSFER)
            .build();
}
