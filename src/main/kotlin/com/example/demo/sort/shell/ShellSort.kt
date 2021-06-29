package com.example.demo.sort.shell

class ShellSort {
    /**
     * 配列で4 ,2 ,1の間隔で並んでいる要素同士をソートする
     * 最後の1の間隔でのは単純挿入ソート
     * 同じグループでソートするため非効率
     */
    private fun shellSort(a: IntArray) {
        var h = a.size.ushr(1) // hずつ離れた要素をソート
        while (0 < h) {
            for (i in h..a.lastIndex) {
                var j = i - h // 中央から左側のインデックス
                val tmp = a[i]
                println("j: $j, h: $h, i: $i, tmp: ${a[i]}, a[j]: ${a[j]}")
                println("0 <= j && tmp < a[j]: ${0 <= j && tmp < a[j]}")
                while (0 <= j && tmp < a[j]) {
                    println("a[j+h]: ${a[j + h]}")
                    a[j + h] = a[j]
                    j -= h
                }
                a[j + h] = tmp
            }
            h /= 2
        }
    }

    fun exec() {
        val a = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        shellSort(a)
        a.forEach { println(it) }
    }
}
