package com.cpro.accounts.mongo.application.port.out;

import com.cpro.accounts.mongo.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(String id);
    List<Account> findByOwner(String identification);
    Account save(Account account);

}
