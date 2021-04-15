package com.example.demo.sort

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
            var pl  = lStack.pop()
            left = pl
            var pr = rStack.pop()
            right = pr
            val x = a[(left + right) / 2]

            while (pl <= pr) {
                while (a[pl] < x) pl++
                while (a[pr] > x) pr--
                if (pl <= pr) swap(a, pl++, pr--)
            }

            // 以降のif文内に渡らない限り各スタックは空のままになり、ループが終了する
            if (left < pr) {
                lStack.push(left) // pl
                rStack.push(pr) // pr
            }

            if (pl < right) {
                lStack.push(pl)
                rStack.push(right)
            }
        }
    }

}
