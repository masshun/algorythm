package com.example.demo.sort.merge

class CustomComparator {

    data class PhyscData(
        val name: String,
        val height: Int,
        val vision: Double
    ) {
        override fun toString(): String {
            return "$name $height $vision"
        }

        companion object {
            // オブジェクトのソートはマージソート。それ以外はクイックソート
            val comparator: Comparator<PhyscData> = compareBy<PhyscData> { it.height }
        }
    }

    fun execute() {
        listOf<PhyscData>(
            PhyscData("赤坂あきお", 162, 0.3),
            PhyscData("野毛祐介", 172, 0.6),
            PhyscData("Carl", 189, 2.0)
        ).shuffled().sortedWith(PhyscData.comparator).also { println(it) }
    }
}
