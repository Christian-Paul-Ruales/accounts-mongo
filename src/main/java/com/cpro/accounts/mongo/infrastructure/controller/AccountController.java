package com.cpro.accounts.mongo.infrastructure.controller;

import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.in.CreateAccountUseCase;
import com.cpro.accounts.mongo.application.port.in.GetAccountsByOwnerUseCase;
import com.cpro.accounts.mongo.domain.model.Account;
import com.cpro.accounts.mongo.infrastructure.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountsByOwnerUseCase getAccountsByOwnerUseCase;

    @GetMapping("/{identification}")
    public ResponseEntity<ResponseDTO> getAllByIdentification(
            @PathVariable("identification") String identification
    ) {
        return handleResponse(getAccountsByOwnerUseCase.execute(identification), HttpStatus.OK);
    }



    @PostMapping()
    public ResponseEntity<ResponseDTO> create(
            @RequestBody Account account
    ) {
        return handleResponse(
                createAccountUseCase.execute(account),
                HttpStatus.CREATED
        );

    }


    private <T> ResponseEntity<ResponseDTO> handleResponse(
            Result<T> result,
            HttpStatus httpStatus
    ) {
        return result
                .fold(
                        saved -> ResponseEntity.ok(buildResponseDTOOk(saved, httpStatus)),
                        error -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(ResponseDTO.onCreate(HttpStatus.INTERNAL_SERVER_ERROR.value(), List.of(), error.message()))
                );

    }

    public <T> ResponseDTO buildResponseDTOOk(T value, HttpStatus httpStatus) {
        if(value instanceof List list) {
            return ResponseDTO.onCreate(httpStatus.value(), list, "OK");
        } else {
            return ResponseDTO.onCreate(httpStatus.value(), List.of(value), "OK");
        }
    }

}
