package com.example.kotlinapi

import com.example.kotlinapi.db.SuperheroRepository
import com.example.kotlinapi.dto.Superhero
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class SuperheroService(val repository: SuperheroRepository) {

	val logger: Logger = LoggerFactory.getLogger(SuperheroService::class.java)

	fun getAllSuperheroes(namePattern: String?): List<Superhero> {
		val superheroes = repository.findAll()
		logger.info("Number of superheroes found ${superheroes.count()}")
		return if (namePattern != null) {
			val filtered = superheroes.filter { it.name.contains(namePattern) }.toList()
			logger.info("Used namePattern. Found superheroes ${filtered.count()}")
			filtered
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
