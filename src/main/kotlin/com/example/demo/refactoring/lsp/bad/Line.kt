package com.example.demo.refactoring.lsp.bad

import java.awt.Point

/**
 * 直線
 */
abstract class Line(private val itsP1: Point, private val itsP2: Point) {
    abstract fun getSlope(): Double
    abstract fun getIntercept(): Double
    abstract fun isOn(point: Point): Boolean
    fun getP1(): Point = this.itsP1
    fun getP2(): Point = this.itsP2
}