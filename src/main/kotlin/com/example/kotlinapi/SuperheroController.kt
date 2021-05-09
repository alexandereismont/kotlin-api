package com.example.kotlinapi

import com.example.kotlinapi.dto.RatingDto
import com.example.kotlinapi.dto.Superhero
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("superhero")
class SuperheroController(val service: MockDatabase) {

	@GetMapping("all")
	fun getAllSuperheroes() = service.getAllSuperheroes()

	@PostMapping("add")
	fun addSuperHero(@RequestBody hero: Superhero) = service.addSuperHero(hero)

	@PutMapping("update/{name}")
	fun updateHero(@PathVariable("name") name: String, @RequestBody rating: RatingDto) = service.updateRating(name, rating.rating)
}