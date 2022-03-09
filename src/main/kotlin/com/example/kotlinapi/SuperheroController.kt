package com.example.kotlinapi

import com.example.kotlinapi.db.SuperheroRepository
import com.example.kotlinapi.dto.RatingDto
import com.example.kotlinapi.dto.Superhero
import com.example.kotlinapi.errorHandling.ResourceNotFoundException
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/superheroes")
class SuperheroController(
	val service: MockDatabase,
	val repository: SuperheroRepository
) {

	@GetMapping
	fun getSuperheroes(@RequestParam namePattern: String?): List<Superhero> {
		return service.getAllSuperheroes(namePattern)
	}

	@GetMapping("/{name}")
	fun getSuperheroByName(@PathVariable name: String): ResponseEntity<Any> {
		val hero = service.getSuperheroByName(name)
		return (hero?.let { ResponseEntity.ok().body(it) }
			?: throw(ResourceNotFoundException("Resource with name $name not found")))
	}

	@PostMapping
	fun addSuperHero(@RequestBody hero: Superhero) = repository.save(hero)//service.addSuperHero(hero)

	@Operation(description = "Update hero")
	@ApiResponses(
		ApiResponse(responseCode = "200", content = [Content(mediaType = "application/json", schema = Schema(type = "object", implementation = Superhero::class))]),
		ApiResponse(responseCode = "404", description = "Hero not found")
	)
	@PutMapping("/{name}")
	fun updateHero(@PathVariable("name") name: String, @RequestBody rating: RatingDto) = service.updateRating(name, rating.rating)

}
