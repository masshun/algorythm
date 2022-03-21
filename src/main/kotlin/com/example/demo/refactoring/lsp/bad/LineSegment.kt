package com.example.demo.refactoring.lsp.bad

import java.awt.Point

/**
 * 線分
 * 基本のLineクラスのisOnメソッドが、このクラスだとたいていfalseになることが想定される⇒不完全な継承
 */
abstract class LineSegment(itsP1: Point, itsP2: Point) : Line(itsP1, itsP2) {
    abstract fun getLength(): Double
}