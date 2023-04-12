package com.nimko.contactbook.controllers

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class AdviceController {

    @ExceptionHandler
    fun processValidationError(ex:MethodArgumentNotValidException) =  ResponseEntity
                .badRequest()
                .body(ex.bindingResult.allErrors.map { er -> er.defaultMessage }.toString())



    @ExceptionHandler
    fun  processValidationError(ex:NotFoundException):ResponseEntity<String?> = ResponseEntity
        .notFound().build()

}