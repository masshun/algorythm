package com.example.demo.search.hash

/**
 * ハッシュ表を保持するクラス
 */
class ChainHash<K, V>(capacity: Int) : Hash<K, V> {

    var size: Int
    lateinit var table: Array<Node<K, V>?>

    init { // 空のハッシュ表を作成する
        try {
            this.table = arrayOfNulls(capacity)
            this.size = capacity
        } catch (e: OutOfMemoryError) { // 表の作成に失敗する
            this.size = 0
        }
    }

    fun hashValue(key: K): Int {
        return key.hashCode() % this.size
    }

    /**
     * キー値を持つ要素を探索して合致する値を返す
     */
    override fun search(key: K): V? {
        val hash = this.hashValue(key) // 探索するデータのハッシュ値(ハッシュテーブルのインデックス)
        var p = this.table[hash] // 着目するノード(バケット)

        while (p != null) { // 線形探索
            if (p.key!! == key) {
                return p.value
            }
            p = p.next
        }
        return null // 探索失敗
    }

    /**
     * ハッシュテーブルにNode<K, V>を挿入する
     */
    override fun add(key: K, value: V): Int {
        val hash = hashValue(key)
        var p = this.table[hash]

        while (p != null) { // すでに着目ノードにはNodeが1つ以上格納されている
            if (p.key!! == key) return 1
            p = p.next // 後続ノードに着目
        }
        val temp = Node(key, value, next = this.table[hash])
        this.table[hash] = temp // リストの先頭位置にノードを挿入　ハッシュテーブルには常にNullか1つのインスタンスかのいずれかが格納されている
        println("temp: ${this.table[hash]}")
        return 0
    }

    override fun remove(key: K): Int {
        val hash = hashValue(key) // 削除するデータのハッシュ値
        var current = this.table[hash] // 着目ノード
        var prev: Node<K, V>? = null // 前回の着目ノード

        while (current != null) {
            println("this.table[${hash}]: ${this.table[hash]}, current: $current")
            if (current.key!! == key) {
                if (prev == null) {
                    this.table[hash] = current.next
                } else {
                    prev.next = current.next // 後続ノードかNull(線形の最後尾)を挿入するだけ(this.table[hash]を更新しない)
                }
                return 0
            }
            prev = current
            current = current.next
        }
        return 1
    }

    override fun dump() {
        for (i in 0 until size) {
            var p = this.table[i]
            print(String.format("%02d ", i))
            while (p != null) {
                print(String.format("-> %s (%s) ", p.key, p.value))
                p = p.next
            }
            println()
        }
    }
}
