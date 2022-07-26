package com.example.kotlinapi.logging

import org.slf4j.MDC
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Configuration
class MdcRequest : Filter {

	override fun doFilter(request: ServletRequest?, response: ServletResponse, chain: FilterChain) {
		val requestId = createRequestId()
		MDC.put("request_id", requestId)
		try {
			chain.doFilter(request, response)
		} finally {
			MDC.clear()
		}
	}

	fun createRequestId(): String? {
		val value = UUID.randomUUID().mostSignificantBits.toString()
		return if (value.startsWith("-")) value.substring(1) else value
	}
}
