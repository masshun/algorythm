package com.example.demo.search.hash

class ExecuteHash {

    fun executeChainHash() {
        val hash = ChainHash<Int, String>(capacity = 13)
        executeHash(hash)
    }

    fun executeOpenHash() {
        val hash = OpenHash<Int, String>(size = 13)
        executeHash(hash)
    }

    private fun executeHash(hash: Hash<Int, String>) {
        println("追加")
        hash.add(1, "藤田")
        hash.add(2, "原")
        hash.add(3, "矢部")
        hash.add(4, "河村")
        hash.add(16, "ダミー")
        hash.add(42, "重複")

        println("一覧表示")
        hash.dump()

        println("3を検索")
        val result = hash.search(3)
        println("検索結果： $result")

        println("3を削除")
        hash.remove(3)

        println("一覧表示")
        hash.dump()
    }
}
