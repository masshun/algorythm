package com.example.demo.search

class BinarySearch {
    private fun binarySearch(a: IntArray, key: Int): Int {
        var pl = 0
        var pr = a.lastIndex

        while (pl <= pr) {
            val pc = (pl + pr) / 2

            if (a[pc] == key) {
                return pc
            } else if (a[pc] < key) {
                pl = pc + 1
            } else {
                pr = pc - 1
            }
        }

        return -1
    }
}
