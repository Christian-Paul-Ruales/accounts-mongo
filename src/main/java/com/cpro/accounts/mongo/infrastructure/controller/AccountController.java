package com.cpro.accounts.mongo.infrastructure.controller;

import com.cpro.accounts.mongo.application.pattern.Result;
import com.cpro.accounts.mongo.application.port.in.CreateAccountUseCase;
import com.cpro.accounts.mongo.application.port.in.GetAccountsByOwnerUseCase;
import com.cpro.accounts.mongo.domain.model.Account;
import com.cpro.accounts.mongo.infrastructure.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Controlador de cuentas", description = "CONTROLADOR PARA EL MANEJO DE CUENTAS")
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountsByOwnerUseCase getAccountsByOwnerUseCase;

    @Operation(
            summary = "Obtener cuentas por usuario",
            description = "Retorna todas las cuentas de un usuario, por su cedula, no utiliza paginacion"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de cuentas de el usuario obtenidas con exito"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se obtiene respuesta, leer la excepcion"
            )
    })
    @GetMapping("/{identification}")
    public ResponseEntity<ResponseDTO> getAllByIdentification(
            @Parameter(description = "Identificacion, cedula de identidad o ruc", example = "1725552166")
            @PathVariable("identification") String identification
    ) {
        return handleResponse(getAccountsByOwnerUseCase.execute(identification), HttpStatus.OK);
    }


    @Operation(
            summary = "Crear cuenta por usuario",
            description = "Crear una cuenta por usuario, nombre debe unico"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cuenta creada con exito"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se obtiene respuesta, lo mas probable es que exista un name repetido, revise el dato enviado"
            )
    })
    @PostMapping()
    public ResponseEntity<ResponseDTO> create(
            @Parameter(description = "Cuenta a crear, el name debe ser unico", example = """
                    {
                        "name": "unico1",
                        "ownerIdentification": "1725552166",
                        "maxValueTransfer": 100000.22,
                        "value": 12.09
                    }
                    """)
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
