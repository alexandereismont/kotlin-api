package com.example.kotlinapi.features.superhero

import com.example.kotlinapi.features.superhero.db.SuperheroRepository
import com.example.kotlinapi.features.superhero.db.UserPreferenceRepository
import com.example.kotlinapi.features.superhero.dto.UserPreference
import com.example.kotlinapi.features.superhero.dto.UserPreferenceInput
import org.springframework.stereotype.Service

@Service
class UserPreferenceService(
    private val superheroRepository: SuperheroRepository,
    private val userPreferenceRepository: UserPreferenceRepository
) {

	fun saveUserPreference(userPreference: UserPreferenceInput, user: String) {
		val superhero = superheroRepository.findByName(userPreference.superheroName)

		if(superhero != null) {
			userPreferenceRepository.save(UserPreference(username = user, superhero = superhero))
		}
	}

}
