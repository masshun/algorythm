package com.example.demo.sort.merge

class MergeSort {

    /**
     * 2つのソートずみの配列を前半と後半とに分離して、
     * それぞれをソートしたものをマージする作業を繰り返す単純ソート(O(n))
     */
    private fun merge(a: IntArray, na: Int, b: IntArray, nb: Int, c: IntArray) {
        var pa = 0
        var pb = 0
        var pc = 0

        while (pa < na && pb < nb) { // 要素が小さい方をcの配列に格納する
            c[pc++] = if (a[pa] <= b[pb]) a[pa++] else b[pb++]
        }

        while (pa < na) { // 配列bの要素は全てcに格納しているが、配列aの要素が残っている（bよりaの方が要素数が多いため）
            c[pc++] = a[pa++]
        }
        while (pb < nb) {
            c[pc++] = b[pb++]
        }
    }

    private fun merge(a: IntArray, left: Int, center: Int, right: Int) {
        var i = left
        var p = 0
        var j = 0
        var k = left
        val buff = IntArray(a.size)

        while (i <= center) { // 配列aの中央位置までの要素を作業用の配列buffに格納する
            buff[p++] = a[i]
            i++
        }
        while (i <= right && j < p) {
            a[k++] = if (buff[j] <= a[i]) buff[j++] else a[i++] // 配列buffに格納したaの前半と、aの後半部とをマージする
        }
        while (j < p) {
            a[k++] = buff[j++]
        }
    }

    private fun mergeSort(a: IntArray, left: Int, right: Int) {
        if (left < right) {
            val center = (left + right) / 2

            mergeSort(a, left, center)
            mergeSort(a, center + 1, right)
            println("----merge実行前----")
            a.forEach { println("a: $it") }
            println("left: ${left}, center: ${center}, right: $right")
            println("----merge実行前----")
            merge(a, left, center, right)
        }
    }

    fun executeMergeSort() {
        val a = intArrayOf(22, 5, 11, 32, 120, 80)
        mergeSort(a, 0, a.lastIndex)
        println("最終結果")
        a.forEach { println(it) }
    }
}
