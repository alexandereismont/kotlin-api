package com.example.kotlinapi.features.superhero

import com.example.kotlinapi.features.superhero.dto.UserPreferenceInput
import org.keycloak.KeycloakPrincipal
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.core.context.SecurityContextHolder

@RestController
@RequestMapping("/preference")
class UserPreferenceController(private val userPreferenceService: UserPreferenceService) {

	@PostMapping
	fun savePreference(@RequestBody userPreference: UserPreferenceInput) {
		val auth: Authentication = SecurityContextHolder.getContext().authentication
		println((auth.principal as KeycloakPrincipal<*>).keycloakSecurityContext.token.preferredUsername)
		userPreferenceService.saveUserPreference(userPreference, (auth.principal as KeycloakPrincipal<*>).keycloakSecurityContext.token.preferredUsername)
	}
}
