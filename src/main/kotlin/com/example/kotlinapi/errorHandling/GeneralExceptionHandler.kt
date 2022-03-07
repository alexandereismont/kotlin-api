package com.example.kotlinapi.errorHandling

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class GeneralExceptionHandler : ResponseEntityExceptionHandler() {

	@ExceptionHandler(ResourceNotFoundException::class)
	fun generateNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ErrorDto> {
		val errorDTO = ErrorDto(ex.message, HttpStatus.NOT_FOUND.toString(), Date().toString())
		return ResponseEntity<ErrorDto>(errorDTO, HttpStatus.NOT_FOUND)
	}
}
