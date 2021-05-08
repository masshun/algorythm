package com.example.demo.search.hash

data class Node<K, V>(
    val key: K, // キー値
    val value: V, // データ
    var next: Node<K, V>? = null // 後続ノードへの参照
) {
    override fun hashCode(): Int {
        return this.key.hashCode()
    }
}

interface Hash<K, V> {
    fun add(key: K, value: V): Int
    fun search(key: K): V?
    fun remove(key: K): Int
    fun dump()
}
