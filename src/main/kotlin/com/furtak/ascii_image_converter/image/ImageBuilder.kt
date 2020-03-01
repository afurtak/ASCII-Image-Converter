package com.furtak.ascii_image_converter.image

abstract class ImageBuilder<T: Pixel>(
    protected val width: Int,
    protected val height: Int
) {
    private val pixels = List(width) { x ->
        MutableList(height) { y ->
            getPixel(x, y)
        }
    }

    fun setPixel(x: Int, y: Int, pixel: T) = apply {
        pixels[x][y] = pixel
    }

    protected abstract fun getPixel(x: Int, y: Int): T

    fun build(): Image<T> = buildFromPixelLists(pixels)

    abstract fun buildFromPixelLists(pixels: List<List<T>>): Image<T>
}