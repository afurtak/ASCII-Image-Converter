package com.furtak.ascii_image_converter.image.rgb

import com.furtak.ascii_image_converter.image.*

class RGBImage internal constructor(
    width: Int,
    height: Int,
    pixels: Array<Array<RGBPixel>>
) : Image<RGBPixel>(
    width,
    height,
    pixels
) {
    override fun getBuilder(width: Int, height: Int): ImageBuilder<RGBPixel> =
        RGBImageBuilder(width, height)

    override fun toOnePixel(pixels: List<RGBPixel>): RGBPixel =
        pixels.toOnePixel()

    override fun toString(): String {
        return pixels.joinToString("\n") { it.joinToString(", ") { pixel -> pixel.toString() }}
    }
}