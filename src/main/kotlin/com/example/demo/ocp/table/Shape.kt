package com.example.demo.ocp.table

abstract class Shape {

    private val typeOrderTable = listOf("square", "circle")

    abstract fun draw(): Unit

    abstract fun getType(): String

    fun preceeds(shape: Shape): Boolean {
        val thisType = this.getType()
        val argType = shape.getType()

        var thisOrd = -1
        var argOrd = -1
        var ord = 0

        typeOrderTable.forEach { tableEntry ->
            if (tableEntry == thisType) {
                thisOrd = ord
            }
            if (tableEntry == argType) {
                argOrd = ord
            }
            if ((0 <= argOrd) && (0 <= thisOrd)) {
                return@forEach
            }
            ord++
        }

        return thisOrd < argOrd
    }
}

class ShapeComparator: Comparator<Shape> {
    override fun compare(o1: Shape, o2: Shape): Int {
        return if (o1.preceeds(o2)) {
            -1
        } else {
            1
        }
    }
}

