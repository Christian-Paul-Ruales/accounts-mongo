package com.cpro.accounts.mongo.domain.model;

import java.math.BigDecimal;

public record Movement (

        String id,
        String destinationAccount,
        String ownerAccount,
        String ownerIdentification,
        BigDecimal maxValueTransfer,
        BigDecimal value
) {
}
