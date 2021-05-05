package com.example.demo.sort.fSort

/**
 * 要素の大小判定を行わずに高速なソートを行う度数ソート
 * 要素の最小値と最大値があらかじめ判明している場合にのみ有効
 */
class FSort {
    private fun fSort(a: IntArray, max: Int, min: Int = 0) {
        val f = IntArray((max - min) + 2) // 累積度数
        val b = IntArray(a.size) // ソートした配列を一時的に格納するための配列

        // 各数字がいくつ存在するかを表す分布表を作成する
        // ex) a[0]が5であれば、f[5]をインクリメントして1とする
        // ex) a[7]も5であれば、f[5]をインクリメントして2とする
        for (i in 0..a.lastIndex) {
            f[a[i] - min]++
        }

        // 配列の各値以下の要素が全部でいくつ存在するかを表す、累積度数分布表を作成する
        // ex) f[4]が6の場合は、0から4までに累計6つ存在することを意味する
        for (i in 1..(max - min) + 1) {
            f[i] += f[i - 1]
        }

//        f.forEachIndexed { idx, id -> print("idx: $idx id: $id, ") }
        // ex) a[8]が3でf[3]は5（0から3までに5つの数字が存在する、つまりa[8]は5番目の値） => b[5-1]に3を格納する
        // 値が重複した際に格納先が重複しないよう、fの要素をデクリメントする
        // 同じfの値を参照された際に、fの要素をデクリメントを予め施すことで、bへの格納を1つずらせる
        for (i in a.lastIndex downTo 0) { // a配列の末尾要素から順に走査する
            b[--f[a[i] - min]] = a[i]
            println("-----")
            b.forEach { print("$it ") }
            println("-----\n")
        }

        // bをaにコピーする
        for (i in a.indices) {
            a[i] = b[i]
        }
    }

    fun executeFSort() {
        val a = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        var max = a[0]
        for (i in 1 until a.size) {
            if (max < a[i]) {
                max = a[i]
            }
        }

        fSort(a, max)
        a.forEach { println(it) }
    }

    fun executeRelaxedFSort() {
        val a = intArrayOf(22, 5, 11, 32, 120, 68, 70)
        var min = a[0]
        var max = a[0]
        for (i in 1 until a.size) {
            if (a[i] < min) {
                min = a[i]
            }
            if (max < a[i]) {
                max = a[i]
            }
        }
        fSort(a, max, min)
        a.forEach { println(it) }
    }

}
