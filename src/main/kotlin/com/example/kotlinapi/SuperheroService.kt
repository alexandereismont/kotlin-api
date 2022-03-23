package com.example.kotlinapi

import com.example.kotlinapi.db.SuperheroRepository
import com.example.kotlinapi.dto.Superhero
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class SuperheroService(val repository: SuperheroRepository) {

	fun getAllSuperheroes(namePattern: String?): List<Superhero> {
		val superheroes = repository.findAll()
		return if (namePattern != null) {
			superheroes.filter { it.name.contains(namePattern) }.toList()
		} else {
			superheroes.toList()
		}
	}

	fun getSuperheroByName(name: String) = repository.findByName(name)

	fun saveSuperhero(hero: Superhero) = repository.save(hero)

	fun updateSuperhero(name: String, rating: Int) : ResponseEntity<Superhero> {
		val superhero = repository.findByName(name)

		return if(superhero != null) {
			val updatedHero = Superhero(superhero, rating)
			ResponseEntity.ok(repository.save(updatedHero))
		} else {
			ResponseEntity.notFound().build()
		}
	}

}
