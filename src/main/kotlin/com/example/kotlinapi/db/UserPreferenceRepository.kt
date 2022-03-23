package com.example.kotlinapi.db

import com.example.kotlinapi.dto.UserPreference
import org.springframework.data.repository.CrudRepository

interface UserPreferenceRepository: CrudRepository<UserPreference, Long>
