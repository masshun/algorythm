package com.example.demo.sort.straightInsertion

class InsertionSort {
    private fun insertionSort(a: IntArray) {
        for (i in 1..a.lastIndex) {
            val tmp = a[i]
            var j = i
            println("i: $i")
            // a[i]より小さい要素に出会うまで一つ左側の要素を代入する操作を繰り返す(jをデクリメント)
            // ストップした位置にa[i]を代入
            while (0 < j && tmp < a[j - 1]) {
                println("j: $j, a[j]: ${a[j]}, a[j-1]: ${a[j - 1]}, i: $i")
                a.forEach { print("a: $it") }
                a[j] = a[j - 1]
                j--
            }
            a[j] = tmp
        }
    }

    fun exec() {
        val arr = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        insertionSort(arr)
        arr.forEach { println(it) }
        println("end")
    }
}
