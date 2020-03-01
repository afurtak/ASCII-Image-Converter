package com.furtak.ascii_image_converter.image.gray_scale

import com.furtak.ascii_image_converter.image.ImageBuilder

class GrayScaleImageBuilder(
    width: Int,
    height: Int
) : ImageBuilder<GrayScalePixel>(
    width,
    height
) {
    override fun getPixel(x: Int, y: Int): GrayScalePixel {
        return GrayScalePixel(0f)
    }

    override fun buildFromPixelLists(pixels: List<List<GrayScalePixel>>): GrayScaleImage {
        return GrayScaleImage(
            width,
            height,
            pixels.map { it.toTypedArray() }.toTypedArray()
        )
    }
}