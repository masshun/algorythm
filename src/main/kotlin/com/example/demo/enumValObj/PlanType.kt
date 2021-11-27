package com.example.demo.enumValObj

/**
 * 区分オブジェクトを定義することで、区分ごとの振る舞いを一度にすべて確認することができる
 * ポリモーフィズムは各実装クラスを見に行く手間がかかる
 */
enum class PlanType : Plan {
    MEETING {
        override val capacity: Int
            get() = 5
        override val canReserveFromRemote: Boolean
            get() = true
    },

    SEAT {
        override val capacity: Int
            get() = 1
        override val canReserveFromRemote: Boolean
            get() = true
    },

    RELAX {
        override val capacity: Int
            get() = 20
        override val canReserveFromRemote: Boolean
            get() = false
    };

    fun calcReservedRate(count: Int) : Double {
        return count / this.capacity.toDouble()
    }
}

interface Plan {
    val capacity: Int
    val canReserveFromRemote: Boolean
}