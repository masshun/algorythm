package com.example.demo.sort.quick

import java.util.*

class QuickSortWithoutRecur {

    private fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    fun quickSort(a: IntArray, lt: Int, rt: Int) {
        var left = lt
        var right = rt
        val lStack = Stack<Int>() // aのインデックス範囲（中央から左端）を決める
        val rStack = Stack<Int>() // aのインデックス範囲（中央から右端）を決める

        lStack.push(left)
        rStack.push(right)

        while (lStack.isNotEmpty()) {
            var pl = lStack.pop()
            left = pl
            var pr = rStack.pop()
            right = pr
            val x = a[(left + right).ushr(2)]

            while (pl <= pr) {
                while (a[pl] < x) pl++
                while (a[pr] > x) pr--
                if (pl <= pr) swap(a, pl++, pr--)
            }

            // 以降のif文内に渡らない限り各スタックは空のままになり、ループが終了する
            println("left: $left, pr: $pr, pl: $pl, right: $right")
            // 要素数が小さい方を後にpushしたい
            if ((pr - left) < (right - pl)) {
                var i = left
                left = pl
                pl = i

                i = pr
                pr = right
                right = i
            }

            if (left < pr) {
                lStack.push(left)
                rStack.push(pr)
            }

            if (pl < right) {
                lStack.push(pl)
                rStack.push(right)
            }
        }
    }

    private fun pushLRStack() {

    }

    fun exec() {
        val arr = intArrayOf(5, 8, 4, 2, 6, 1, 3, 9, 7)
        quickSort(arr, 0, arr.lastIndex)
        arr.forEachIndexed { idx, el ->
            println("インデックス： $idx 要素： $el")
        }
    }

}
