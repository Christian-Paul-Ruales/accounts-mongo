package com.cpro.accounts.mongo.infrastructure.dto;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
public record ResponseDTO(
        int status,
        LocalDateTime date,
        String ip,
        List<?> entities,
        String message

) {
    public static ResponseDTO onCreate(int status, List<?> entities, String message){
        return ResponseDTO.builder()
                .status(status)
                .date(LocalDateTime.now())
                .entities(entities)
                .message(message)
                .build();
    }

}
