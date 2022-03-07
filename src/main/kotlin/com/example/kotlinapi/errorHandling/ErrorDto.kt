package com.example.kotlinapi.errorHandling

data class ErrorDto(
	var status: String? = null,
	var message: String? = null,
	var time: String? = null
)
