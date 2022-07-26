package com.example.kotlinapi.security

import org.keycloak.adapters.KeycloakConfigResolver
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
class SecurityWebConfig: KeycloakWebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		super.configure(http)

		http.cors()
			.configurationSource { CorsConfiguration().applyPermitDefaultValues() }

		http.authorizeRequests()
			.antMatchers("/admin/*").hasRole("super_user")
			.anyRequest().permitAll()

		http.csrf().disable()
	}

	@Autowired
	fun configureGlobal(auth: AuthenticationManagerBuilder) {
		val keycloakProvider = this.keycloakAuthenticationProvider()
		keycloakProvider.setGrantedAuthoritiesMapper(SimpleAuthorityMapper())
		auth.authenticationProvider(keycloakProvider)
	}

	@Bean
	override fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy {
		return RegisterSessionAuthenticationStrategy(SessionRegistryImpl())
	}

	@Bean
	fun KeycloakConfigResolver(): KeycloakConfigResolver {
		return KeycloakSpringBootConfigResolver()
	}

	@Bean
	fun corsConfigurationSource(): CorsConfigurationSource? {
		val configuration = CorsConfiguration()
		configuration.allowedOrigins = listOf("*")
		configuration.allowedMethods = listOf("*")
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/**", configuration)
		return source
	}

}
