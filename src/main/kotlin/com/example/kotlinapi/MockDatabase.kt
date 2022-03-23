package com.example.kotlinapi

import com.example.kotlinapi.dto.Superhero
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
@Deprecated("Replaced by proper database")
class MockDatabase {
	private val inMemoryDatabase: HashMap<String, Superhero> = HashMap()

	init {
		inMemoryDatabase["Ironman"] = Superhero(name = "Ironman", company =  "MARVEL", rating =  0)
		inMemoryDatabase["Captain America"] = Superhero(name = "Captain America", company =  "MARVEL", rating = 0)
		inMemoryDatabase["Batman"] = Superhero(name = "Batman", company = "DC", rating = 0)
		inMemoryDatabase["Superman"] = Superhero(name = "Superman", company =  "DC", rating =  0)
	}

	fun getAllSuperheroes(namePattern: String?) : List<Superhero> {
		return if(namePattern != null) {
			inMemoryDatabase.values.filter { it.name.contains(namePattern) }.toList()
		} else {
			inMemoryDatabase.values.toList()
		}
	}

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
