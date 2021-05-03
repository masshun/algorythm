package com.example.demo.sort.heap

class HeapSort {
    private fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    /**
     * a[left] ~ a[right]をヒープ化する
     */
    private fun downHeap(a: IntArray, left: Int, right: Int) {
        val temp = a[left]
        var biggerChild: Int
        var parent = left

        // (right + 1) / 2: ヒープ構造にしようとしている範囲、かつ子を持たない最初の要素のインデックス
        while (parent < (right + 1) / 2) {
            val leftChild = parent * 2 + 1
            val rightChild = leftChild + 1
            biggerChild = if (rightChild <= right && a[leftChild] < a[rightChild]) rightChild else leftChild
            if (a[biggerChild] <= temp) {
                break
            }
            a[parent] = a[biggerChild] // 親と子を入れ替える
            parent = biggerChild
        }
        a[parent] = temp
    }

    private fun heapSort(a: IntArray) {
        var i = a.lastIndex / 2
        while (i >= 0) { // a[i] ~ a[a.lastIndex]をヒープ化する
            downHeap(a, i, a.lastIndex) // i ~ a.lastIndexが最下層の要素のインデックス
            i--
        }

        // ヒープソート
        i = a.lastIndex
        while (0 < i) {
            swap(a, 0, i)
            downHeap(a, 0, i - 1)
            i--
        }
    }

    fun execute() {
        val a = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        heapSort(a)
        a.forEach { println(it) }
    }
}
