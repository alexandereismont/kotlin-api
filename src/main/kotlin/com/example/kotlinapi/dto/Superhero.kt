package com.example.kotlinapi.dto

import javax.validation.constraints.Size


data class Superhero(val name: String, val company: String,@Size(min = 0, max = 10) val rating: Int) {
	constructor(hero: Superhero, newRating: Int ) : this(hero.name, hero.company, newRating)
}