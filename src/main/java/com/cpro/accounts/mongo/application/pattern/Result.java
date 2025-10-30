package com.cpro.accounts.mongo.application.pattern;

import com.cpro.accounts.mongo.application.dto.Error;
import com.cpro.accounts.mongo.domain.constants.ErrorEnum;

import java.util.function.Function;

public sealed interface Result<T> permits Result.Success, Result.Failure {
    record Success<T>(T value) implements Result<T>{}
    record Failure<T>(Error error) implements Result<T>{
        public Error getError() {
            return error();
        }
    }

    default boolean isSuccess() {
        return this instanceof Result.Success<T>;
    }

    default boolean isFailure() {
        return this instanceof Result.Failure<T>;
    }

    default T getOrElse(T defaultValue) {
        return this instanceof Result.Success<T> success
                ? success.value()
                : defaultValue;
    }



    default <R> R fold(Function<T, R> onSuccess, Function<Error, R> onFailure) {
        return switch (this) {
            case Success<T> success -> onSuccess.apply(success.value());
            case Failure<T> failure -> onFailure.apply(failure.error());
        };
    }

}
