package com.example.demo.search.hash

class OpenHash<K, V>(size: Int) : Hash<K, V> {

    enum class Status {
        OCCUPIED, EMPTY, DELETED
    }

    class Bucket<K, V> {
        var key: K? = null
        var value: V? = null
        var status: Status

        init {
            this.status = Status.EMPTY
        }

        fun set(key: K, value: V, status: Status) {
            this.key = key
            this.value = value
            this.status = status
        }

        override fun hashCode(): Int {
            return this.key.hashCode()
        }
    }

    var size: Int
    lateinit var table: Array<Bucket<K, V>?>

    init {
        try {
            this.table = arrayOfNulls(size)
            for (i in 0 until size) {
                this.table[i] = Bucket()
            }
            this.size = size
        } catch (e: OutOfMemoryError) {
            this.size = 0
        }
    }

    private fun hashValue(key: K): Int {
        return key.hashCode() % this.size
    }

    private fun rehashValue(hash: Int): Int {
        return (hash + 1) % this.size
    }

    private fun searchBucket(key: K): Bucket<K, V>? {
        var hash = hashValue(key)
        var p = this.table[hash]

        var i = 0
        while (p?.status != Status.EMPTY && i < size) {
            if (p?.status == Status.OCCUPIED && p.key == key) {
                return p
            }
            hash = rehashValue(hash)
            p = this.table[hash]
            i++
        }
        return null
    }

    /**
     * キー値を持つ要素の探索
     */
    override fun search(key: K): V? {
        return searchBucket(key)?.value
    }

    override fun add(key: K, value: V): Int {
        if (search(key) != null) return 1
        var hash = hashValue(key) // 追加するデータのハッシュ値
        var p = this.table[hash] // 着目するバケット

        for (i in 0 until this.size) {
            // DELETEDは上書きしても良い値
            if (p?.status == Status.EMPTY || p?.status == Status.DELETED) {
                p.set(key, value, Status.OCCUPIED)
                return 0
            }
            hash = rehashValue(hash)
            p = this.table[hash]
        }
        return 2 // ハッシュ表が満杯
    }

    override fun remove(key: K): Int {
        val p = searchBucket(key) ?: return 1
        p.status = Status.DELETED
        return 0
    }

    override fun dump() {
        for (i in 0 until this.size) {
            print(String.format("%02d ", i))
            when (this.table[i]?.status) {
                Status.OCCUPIED -> println(String.format("%s (%s)", table[i]?.key, table[i]?.value))
                Status.EMPTY -> println("---未登録---")
                Status.DELETED -> println("---削除ずみ---")
            }
        }
    }
}
