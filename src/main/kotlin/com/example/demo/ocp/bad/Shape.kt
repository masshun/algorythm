package com.example.demo.ocp.bad

import java.awt.Point

enum class ShapeType {
    CIRCLE,
    SQUARE
}

/**
 * 新しい種類の図形が追加されるたびにコードが肥大化する⇒OCP原則の違反
 * 抽象化した図形インターフェースを実装すればよいわけでは必ずしもない（図形の描画順を意識した場合対応しづらい）。どのような変更が生じるかを予測した抽象化が必要
 */
class Shape(val shapeType: ShapeType) {
    fun drawAllShapes(list: List<ShapeType>) {
        list.forEach { shape ->
            when(shape) {
                ShapeType.CIRCLE -> {} // Do something
                ShapeType.SQUARE -> {} // Do something
            }
        }
    }
}

class Circle(shapeType: ShapeType, radius: Double, center: Point) {
    fun drawCircle(circle: Circle) {}
}

class Square(shapeType: ShapeType, radius: Double, center: Point) {
    fun drawCircle(circle: Circle) {}
}

