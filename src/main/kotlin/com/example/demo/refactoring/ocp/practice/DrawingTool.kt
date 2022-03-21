package com.example.demo.refactoring.ocp.practice

class DrawingTool {
    // 動作確認のためshapeListをメンバ変数から外す

    fun drawAllShapes(shapeList: List<Shape>) {
        val orderedList = drawingOrderSort(shapeList)
        orderedList.forEach { it.draw() }
    }

    fun drawingOrderSort(shapeList: List<Shape>): List<Shape> {
        return shapeList.sortedWith(ShapeComparator())
    }
}

