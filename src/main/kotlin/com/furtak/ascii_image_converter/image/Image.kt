package com.furtak.ascii_image_converter.image

abstract class Image<T : Pixel>(
    val width: Int,
    val height: Int,
    val pixels: Array<Array<T>>
) {
    abstract fun getBuilder(width: Int, height: Int): ImageBuilder<T>

    abstract fun toOnePixel(pixels: List<T>): T

    operator fun get(x: Int, y: Int): T {
        return pixels[x][y]
    }

    fun resize(newWidth: Int, newHeight: Int): Image<T> {
        val tmpArray = Array(newWidth) {
            Array(newHeight) {
                mutableListOf<T>()
            }
        }

        for (x in 0 until width) {
            val newX = (newWidth * x) / width
            for (y in 0 until height) {
                val newY = (newHeight * y) / height
                tmpArray[newX][newY].add(this[x, y])
            }
        }

        return getBuilder(newWidth, newHeight).buildFromPixelLists(tmpArray.map { row ->
            row.map {
                toOnePixel(it)
            }
        })
    }
}