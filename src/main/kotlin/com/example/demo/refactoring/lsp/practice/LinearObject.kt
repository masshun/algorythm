package com.example.demo.refactoring.lsp.practice

import java.awt.Point

/**
 * LineとLineSegmentの共通した部分を抽出する方法
 */
abstract class LinearObject(private val itsP1: Point, private val itsP2: Point) {
    abstract fun isOn(point: Point): Boolean
    fun getIntercept(): Double {
        return getP1().y - getSlope() * getP1().x // y0
    }
    private fun getP1(): Point = this.itsP1
    private fun getP2(): Point = this.itsP2
    private fun getSlope(): Double {
        return (getP1().x - getP2().x).toDouble() / (getP1().y - getP2().y).toDouble()
    }
}