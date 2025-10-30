package com.cpro.accounts.mongo.domain.model;

import java.math.BigDecimal;

public record Account(
        String id,
        String name,
        String ownerIdentification,
        BigDecimal maxValueTransfer,
        BigDecimal value
) {
}
