package com.example.demo.sort.shell

class ShellSort2 : AbstractShellSort() {

    override fun shellSort(array: IntArray) {
        var h = 1
        while (h < (array.size / 9)) {
            h = h * 3 + 1
        }

        while (0 < h) {
            for (i in h until array.size) {
                val tmp = array[i]
                var j = (i - h)
                while (0 <= j && tmp < array[j]) {
                    array[j + h] = array[j]
                    j -= h
                }
                array[j + h] = tmp
            }
            h /= 3
        }
    }
}
