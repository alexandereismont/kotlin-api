package com.example.kotlinapi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coroutines")
class CoroutinesController {

	@GetMapping("/s")
	fun separateTask() : String {
		GlobalScope.launch {
			s()
		}
		return "test"
	}

	suspend fun s() {
		runBlocking {
			delay(10000)
			println("test")
		}
	}

	@PostMapping("")
	fun coroutines() {
		runBlocking {
			launch {
				delay(1000)
				println("First launch")
			}
			launch {
				println("Second launch")
			}
			println("End blocking")
			delay(4000)
		}
		println("Done saveUserPreference")
	}


	@PostMapping("/scope")
	fun coroutinesScope() {
		runBlocking {
			doWorld()
			println("done")
		}
		println("Done saveUserPreference")
	}

	suspend fun doWorld() = coroutineScope { // this: CoroutineScope
		launch {
			delay(2000L)
			println("World 2")
		}
		launch {
			delay(1000L)
			println("World 1")
		}
		println("Hello")
	}

	@PostMapping("/job")
	fun simpleJob() {
		runBlocking {
			val job = launch {
				delay(1000L)
				println("World!")
			}
			println("Hello")
			job.join() // wait until child coroutine completes
			println("Done")
		}
	}


	@PostMapping("/job/cancel")
	fun jobCancel() {
		runBlocking {
			val startTime = System.currentTimeMillis()
			val job = launch(Dispatchers.Default) {
				var nextPrintTime = startTime
				var i = 0
				while (isActive) { // computation loop, just wastes CPU
					// print a message twice a second
					if (System.currentTimeMillis() >= nextPrintTime) {
						println("job: I'm sleeping ${i++} ...")
						nextPrintTime += 500L
					}
				}
			}
			delay(1300L) // delay a bit
			println("main: I'm tired of waiting!")
			job.cancelAndJoin() // cancels the job and waits for its completion
			println("main: Now I can quit.")
		}
	}

}
