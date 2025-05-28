package com.doubleo.entranceservice.global.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EntranceErrorCode implements BaseErrorCode {
    ENTRANCE_SAMPLE_ERROR_CODE(HttpStatus.NOT_FOUND, "entrance sample error"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public String errorClassName() {
        return this.name();
    }
}
