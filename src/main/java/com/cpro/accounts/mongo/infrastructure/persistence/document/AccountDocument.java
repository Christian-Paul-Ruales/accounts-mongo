package com.cpro.accounts.mongo.infrastructure.persistence.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "account")
public class AccountDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field("name")
    private String name;

    @Field("owner_identification")
    private String ownerIdentification;

    @Field("max_value_transfer")
    private BigDecimal maxValueTransfer;

    @Field("value")
    private BigDecimal value;
}
