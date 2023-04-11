package com.maxley.financial.utils.exceptionhandler

import com.maxley.financial.utils.exception.UnprocessableEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import com.maxley.financial.utils.exception.NotFoundException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [NotFoundException::class])
    fun handleNotFound(exception: NotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.message)
    }

    @ExceptionHandler(value = [UnprocessableEntity::class])
    fun handleUnprocessableEntity(exception: UnprocessableEntity): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(exception.message)
    }


}