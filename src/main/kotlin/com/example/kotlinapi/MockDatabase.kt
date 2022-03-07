package com.example.kotlinapi

import com.example.kotlinapi.dto.Superhero
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class MockDatabase {
	private val inMemoryDatabase: HashMap<String, Superhero> = HashMap()

	init {
		inMemoryDatabase["Ironman"] = Superhero("Ironman", "MARVEL", 0)
		inMemoryDatabase["Captain America"] = Superhero("Captain America", "MARVEL", 0)
		inMemoryDatabase["Batman"] = Superhero("Batman", "DC", 0)
		inMemoryDatabase["Superman"] = Superhero("Superman", "DC", 0)
	}

	fun getAllSuperheroes() = inMemoryDatabase.values

	fun getSuperheroByName(name: String) = inMemoryDatabase[name]

	fun addSuperHero(hero: Superhero) {
		val storedHero = inMemoryDatabase[hero.name]
		if(storedHero == null) {
			inMemoryDatabase[hero.name] = hero
		}
	}

	fun updateRating(heroName: String, rating: Int): ResponseEntity<Any> {
		val superhero = inMemoryDatabase[heroName]
		return if(superhero != null) {
			inMemoryDatabase[heroName] = Superhero(superhero, rating)
			ResponseEntity.ok(inMemoryDatabase[heroName])
		} else {
			ResponseEntity.notFound().build()
		}
	}

}
