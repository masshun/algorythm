package com.example.demo

import com.example.demo.search.hash.ExecuteHash
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
    ExecuteHash().executeOpenHash()
}
