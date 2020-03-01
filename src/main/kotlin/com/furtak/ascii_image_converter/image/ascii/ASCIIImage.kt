package com.furtak.ascii_image_converter.image.ascii

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ImageBuilder

class ASCIIImage internal constructor(
    width: Int,
    height: Int,
    pixels: Array<Array<ASCIIPixel>>
) : Image<ASCIIPixel>(width, height, pixels) {
    override fun getBuilder(width: Int, height: Int): ImageBuilder<ASCIIPixel> {
        return ASCIIImageBuilder(width, height)
    }

    override fun toOnePixel(pixels: List<ASCIIPixel>): ASCIIPixel {
        return ASCIIPixel(' ')
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (y in 0 until height) {
            for (x in 0 until width) {
                builder.append(this[x, y])
            }
            builder.append("\n")
        }
        return builder.toString()
    }
}