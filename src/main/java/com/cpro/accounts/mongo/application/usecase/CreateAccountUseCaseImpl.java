package com.cpro.accounts.mongo.application.usecase;

import com.cpro.accounts.mongo.application.dto.Error;
import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.in.CreateAccountUseCase;
import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.domain.annotation.UseCase;
import com.cpro.accounts.mongo.domain.constants.AccountConstants;
import com.cpro.accounts.mongo.domain.constants.ErrorEnum;
import com.cpro.accounts.mongo.domain.model.Account;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    private final AccountRepository accountRepository;

    @Override
    public Result<Account> execute(Account account) {
        if(account.value().compareTo(AccountConstants.limit) > 0) {
            return new Result.Failure<>(
                    Error.builder()
                            .errorEnum(ErrorEnum.CANNOT_CREATE)
                            .message("Initial value cannot be higher tan %f".formatted(AccountConstants.limit))
                            .build()
            );
        }

        return new Result.Success<>(accountRepository.save(account));
    }
}
