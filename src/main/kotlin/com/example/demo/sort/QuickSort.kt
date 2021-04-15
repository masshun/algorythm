package com.example.demo.sort

class QuickSort {

    private fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    /**
     * 配列の分割を行いながらカーソルを枢軸に向かって移動させてソートを行う
     */
    private fun quickSort(a: IntArray, left: Int, right: Int) {
        var pl = left // 左カーソル
        var pr = right // 右カーソル
        val x = a[(left + right) / 2] // 枢軸（中央の要素）

        while (pl <= pr) {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr) swap(a, pl++, pr--)
        }

        if (left < pr) {
            a.forEach { print(it) }
            println("left: $left: , pr:$pr")
            quickSort(a, left, pr)
        }
        if (pl < right) {
            a.forEach { print(it) }
            println("right: $right: , pl:$pl")
            quickSort(a, pl, right)
        }
    }


    /**
     * @n 要素数
     */
    private fun quickSort(a: IntArray, n: Int) {
        quickSort(a, 0 , n - 1)
    }

    fun exec() {
        val arr = intArrayOf(5,8,4,2,6,1,3,9,7)
        println("要素数： ${arr.size}")
        arr.forEachIndexed { idx, el ->
            println("インデックス： $idx 要素： $el")
        }

        quickSort(arr, 0, arr.lastIndex)

        println("昇順にソートしました。")
        arr.forEachIndexed { idx, el ->
            println("インデックス： $idx 要素： $el")
        }

    }

}
