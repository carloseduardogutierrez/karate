package com.example.karate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KarateApplication

fun main(args: Array<String>) {
	runApplication<KarateApplication>(*args)
}
