package com.example.demo.recursive

/**
 * 再帰呼び出しとは、自分と同じメソッドを呼び出すこと ※自分を呼び出すのではない
 */
class Factorial {

    /**
     * 5が呼ばれる -> 4 -> 3 -> 2 -> 1 -> 0 -> || 1 * 1 -> 2 * 1 -> 3 * 2 -> 4 * 6 -> 5 * 24
     */
    private fun factorial(n: Int): Int {
        return if (0 < n) {
            n * factorial(n -1)
        } else {
            1
        }
    }

    fun execute() {
        val n = 5
        println("${n}の階乗は、${factorial(n)}です。")
    }
}
