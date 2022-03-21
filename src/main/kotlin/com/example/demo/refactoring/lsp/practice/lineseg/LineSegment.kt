package com.example.demo.refactoring.lsp.practice.lineseg

import com.example.demo.refactoring.lsp.practice.LinearObject
import java.awt.Point

abstract class LineSegment(itsP1: Point, itsP2: Point) : LinearObject(itsP1, itsP2) {
    abstract fun getLength(): Double
}