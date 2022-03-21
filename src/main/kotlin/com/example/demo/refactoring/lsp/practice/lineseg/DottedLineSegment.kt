package com.example.demo.refactoring.lsp.practice.lineseg

import java.awt.Point

class DottedLineSegment(private val itsP1: Point, private val itsP2: Point) : LineSegment(itsP1, itsP2) {
    override fun getLength(): Double {
        return ((this.itsP1.x * this.itsP2.x) / 2).toDouble()
    }

    override fun isOn(point: Point): Boolean {
        return point.y.toDouble() == this.getLength()
    }

}