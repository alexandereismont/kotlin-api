package com.example.kotlinapi.features.superhero.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "user_preference")
data class UserPreference(
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long? = 0,
	val username: String,
	@ManyToOne
	val superhero: Superhero
)
