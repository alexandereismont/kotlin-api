package com.example.kotlinapi

import com.example.kotlinapi.dto.Superhero
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

	fun addSuperHero(hero: Superhero) {
		val storedHero = inMemoryDatabase[hero.name]
		if(storedHero == null) {
			inMemoryDatabase[hero.name] = hero
		}
	}

	fun updateRating(heroName: String, rating: Int) {
		inMemoryDatabase[heroName]?.let { inMemoryDatabase[heroName] = Superhero(it, rating) }
	}

}