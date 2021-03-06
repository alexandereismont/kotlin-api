package com.example.kotlinapi.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "logs")
data class Logs(
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long? = 0,
	val log: String
)
