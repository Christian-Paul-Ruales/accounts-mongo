package com.cpro.accounts.mongo.application.port.in;

import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.domain.model.Account;

import java.util.List;

public interface GetAccountsByOwnerUseCase {
    Result<List<Account>> execute(String identification);
}
