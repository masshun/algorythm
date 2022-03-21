package com.example.demo.refactoring.ocp.practice

class Square: Shape() {
    override fun draw() {
        println("draw square")
    }

    override fun getType(): String = "square"
}

class Triangle: Shape() {
    override fun draw() {
        println("draw triangle")
    }

    override fun getType(): String = "triangle"
}