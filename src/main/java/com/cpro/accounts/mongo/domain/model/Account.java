package com.cpro.accounts.mongo.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public record Account(
        String id,
        String name,
        String ownerIdentification,
        BigDecimal maxValueTransfer,
        BigDecimal value
) {
}
