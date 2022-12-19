package com.example.kotlinapi.features.superhero

import com.example.kotlinapi.features.superhero.dto.Superhero
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class AdminController(val service: SuperheroService) {

	@GetMapping("superheroes")
	fun allSuperheroes(): List<Superhero> {
		return service.getAllSuperheroes(namePattern = null)
	}
}
