package com.example.kotlinapi.features.superhero.db

import com.example.kotlinapi.features.superhero.dto.Superhero
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SuperheroRepository : CrudRepository<Superhero, Long> {
	fun findByName(name: String) : Superhero?
}
