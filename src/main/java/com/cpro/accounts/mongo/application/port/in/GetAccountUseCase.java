package com.cpro.accounts.mongo.application.port.in;

import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.domain.model.Account;

public interface GetAccountUseCase {
    Result<Account> execute(String id);
}
