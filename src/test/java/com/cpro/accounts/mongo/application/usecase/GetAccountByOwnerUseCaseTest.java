package com.cpro.accounts.mongo.application.usecase;


import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.in.GetAccountsByOwnerUseCase;
import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.constants.TestConstants;
import com.cpro.accounts.mongo.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class GetAccountByOwnerUseCaseTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private GetAccountsByOwnerUseCaseImpl getAccountsByOwnerUseCase;

    @BeforeEach
    void init() {

    }


    @Test
    @DisplayName("Buscar una cuenta")
    void shouldCreateAccountSuccessful() {

        Mockito.when(accountRepository.findByOwner(TestConstants.IDENTIFICATION))
                .thenReturn(List.of(TestConstants.ACCOUNT_TEMPLATE));

        Result result = getAccountsByOwnerUseCase.execute(TestConstants.IDENTIFICATION);
        Mockito.verify(accountRepository, Mockito.times(TestConstants.DEFAULT_INSTANTANTION)).findByOwner(any());
        assertInstanceOf(Result.Success.class, result);
        assertInstanceOf(List.class, result.getOrElse(List.of()));

    }



}
