package com.cpro.accounts.mongo.application.usecase;


import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.out.AccountRepository;
import com.cpro.accounts.mongo.constants.TestConstants;
import com.cpro.accounts.mongo.domain.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class CreateAccountUseCaseTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreateAccountUseCaseImpl createAccountUseCase;

    @BeforeEach
    void init() {

    }


    @Test
    @DisplayName("Deberia crear una cuenta exitosamente")
    void shouldCreateAccountSuccessful() {

        Mockito.when(accountRepository.save(TestConstants.ACCOUNT_TEMPLATE))
                .thenReturn(TestConstants.ACCOUNT_TEMPLATE);
        Result result = createAccountUseCase.execute(TestConstants.ACCOUNT_TEMPLATE);
        Mockito.verify(accountRepository, Mockito.times(TestConstants.DEFAULT_INSTANTANTION)).save(any());
        assertInstanceOf(Result.Success.class, result);

    }

    @Test
    @DisplayName("Deberia generar error si el valor es mayor al limite")
    void shouldReturnFailure_ValueMajorToLimit() {
        Account errorAccount = Account.builder()
                .id(TestConstants.ID)
                .name(TestConstants.NAME)
                .value(BigDecimal.valueOf(15000.00))
                .ownerIdentification(TestConstants.IDENTIFICATION)
                .maxValueTransfer(TestConstants.MAX_VALUE_TRANSFER)
                .build();

        Result result = createAccountUseCase.execute(errorAccount);
        Mockito.verify(accountRepository, Mockito.times(0)).save(any());
        assertInstanceOf(Result.Failure.class, result);


    }

}
