package com.example.demo

import com.example.demo.sort.shell.ShellSort2
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
    ShellSort2().exec()
}
