package com.example.demo

import io.micrometer.core.instrument.Metrics
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class MainController {

    @GetMapping("/")
    fun index(@RequestParam(required = false, defaultValue = "world") name: String): String {
        Metrics.counter("hello", "name", name).increment()
        return "Hello $name"
    }
}
