package com.furtak.ascii_image_converter.image.ascii

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ImageBuilder

class ASCIIImageBuilder(
    width: Int,
    height: Int
) : ImageBuilder<ASCIIPixel>(width, height) {
    override fun getPixel(x: Int, y: Int): ASCIIPixel {
        return ASCIIPixel(' ')
    }

    override fun buildFromPixelLists(pixels: List<List<ASCIIPixel>>): Image<ASCIIPixel> {
        return ASCIIImage(
            width,
            height,
            pixels.map { it.toTypedArray() }.toTypedArray()
        )
    }
}