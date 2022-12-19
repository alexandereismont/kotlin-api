package com.example.kotlinapi.features.superhero.dto

import com.example.kotlinapi.features.superhero.dto.Superhero
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
	val user: String,
	@ManyToOne
	val superhero: Superhero
)
