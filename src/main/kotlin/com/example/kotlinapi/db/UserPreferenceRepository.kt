package com.example.kotlinapi.db

import com.example.kotlinapi.dto.UserPreference
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPreferenceRepository: CrudRepository<UserPreference, Long>
