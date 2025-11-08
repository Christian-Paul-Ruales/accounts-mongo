package com.cpro.accounts.mongo.infrastructure.persistence.adapter.out;

import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.constants.TestConstants;
import com.cpro.accounts.mongo.domain.model.Account;
import com.cpro.accounts.mongo.infrastructure.adapter.out.AccountRepositoryImpl;
import com.cpro.accounts.mongo.infrastructure.mapper.AccountMapper;
import com.cpro.accounts.mongo.infrastructure.persistence.repository.SpringDataAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


import java.math.BigDecimal;
import java.util.Optional;

/**
 * Cargamos contexto completo, no recomendado, o hacerlo con las precauciones del caso
 * **/
@SpringBootTest
public class AccountRepositoryAdapterTestImpl {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("Deberia guardar")
    void shouldSaveAndReturnAccount() {
        Account domainAccount = TestConstants.buildAccount(null, "unicoTest1", BigDecimal.valueOf(100.12));
        Account accountsaved = accountRepository.save(domainAccount);
        Optional<Account> find = accountRepository.findById(accountsaved.id());

        Assertions.assertNotNull(accountsaved.id());
        Assertions.assertEquals(domainAccount.name(), accountsaved.name());
        Assertions.assertTrue(find.isPresent());

    }
}
