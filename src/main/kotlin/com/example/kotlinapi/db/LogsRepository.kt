package com.example.kotlinapi.db

import com.example.kotlinapi.dto.Logs
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LogsRepository: CrudRepository<Logs, Long> {
}
