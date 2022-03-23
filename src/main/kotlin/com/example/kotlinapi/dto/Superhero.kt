package com.example.kotlinapi.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "superhero")
data class Superhero(
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long? = 0,
	val name: String,
	val company: String,
	@Size(min = 0, max = 10) val rating: Int)
{
	constructor(hero: Superhero, newRating: Int ) :
		this(id = hero.id, name = hero.name, company = hero.company, rating = newRating)
}
