package com.example.kotlinapi.features.superhero.db

import com.example.kotlinapi.features.superhero.dto.UserPreference
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPreferenceRepository: CrudRepository<UserPreference, Long>
