package com.example.kotlinapi.dto

data class Superhero(val name: String, val company: String, val rating: Int) {
	constructor(hero: Superhero, newRating: Int ) : this(hero.name, hero.company, newRating)
}