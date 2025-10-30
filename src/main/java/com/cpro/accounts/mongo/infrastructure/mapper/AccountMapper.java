package com.cpro.accounts.mongo.infrastructure.mapper;

import com.cpro.accounts.mongo.domain.model.Account;
import com.cpro.accounts.mongo.infrastructure.persistence.document.AccountDocument;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDocument toDocument(Account domain);

    @InheritInverseConfiguration
    Account toDomain(AccountDocument document);
}
