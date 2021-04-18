package com.example.demo.sort.shell

abstract class AbstractShellSort {

    abstract fun shellSort(array: IntArray)

    fun exec() {
        val a = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        shellSort(a)
        a.forEach { println(it) }
    }
}
