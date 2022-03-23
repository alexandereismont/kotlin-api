package com.example.kotlinapi

import com.example.kotlinapi.db.SuperheroRepository
import com.example.kotlinapi.db.UserPreferenceRepository
import com.example.kotlinapi.dto.UserPreference
import com.example.kotlinapi.dto.UserPreferenceInput
import org.springframework.stereotype.Service

@Service
class UserPreferenceService(
	private val superheroRepository: SuperheroRepository,
	private val userPreferenceRepository: UserPreferenceRepository
) {

	fun saveUserPreference(userPreference: UserPreferenceInput, user: String) {
		val superhero = superheroRepository.findByName(userPreference.superheroName)

		if(superhero != null) {
			userPreferenceRepository.save(
				UserPreference(user = user, superhero = superhero)
			)
		}
	}
}
