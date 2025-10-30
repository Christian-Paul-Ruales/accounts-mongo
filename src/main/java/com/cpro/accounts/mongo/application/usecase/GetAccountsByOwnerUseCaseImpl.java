package com.cpro.accounts.mongo.application.usecase;

import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.in.GetAccountsByOwnerUseCase;
import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.domain.annotation.UseCase;
import com.cpro.accounts.mongo.domain.model.Account;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAccountsByOwnerUseCaseImpl implements GetAccountsByOwnerUseCase {

    private final AccountRepository accountRepository;

    @Override
    public Result<List<Account>> execute(String identification) {
        return new Result.Success<>(accountRepository.findByOwner(identification));
    }
}
