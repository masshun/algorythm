package com.example.demo.refactoring.lsp.practice.line

import java.awt.Point

class DottedLine(private val itsP1: Point, private val itsP2: Point) : Line(itsP1, itsP2) {
    override fun isOn(point: Point): Boolean {
        return this.getIntercept().toInt() == this.itsP1.y
    }
}