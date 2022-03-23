package com.example.kotlinapi.security

import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import org.springframework.security.core.session.SessionRegistryImpl

import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import java.lang.Exception
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver

import org.keycloak.adapters.KeycloakConfigResolver

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
class SecurityWebConfig: KeycloakWebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		super.configure(http)
		http.csrf().disable()

		http.authorizeRequests()
			.anyRequest().authenticated()
	}

	@Autowired
	@Throws(Exception::class)
	fun configureGlobal(auth: AuthenticationManagerBuilder) {
		auth.authenticationProvider(keycloakAuthenticationProvider())
	}

	@Bean
	override fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy {
		return RegisterSessionAuthenticationStrategy(SessionRegistryImpl())
	}

	@Bean
	fun KeycloakConfigResolver(): KeycloakConfigResolver {
		return KeycloakSpringBootConfigResolver()
	}

}
