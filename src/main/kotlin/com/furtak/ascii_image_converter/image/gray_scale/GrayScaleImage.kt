package com.furtak.ascii_image_converter.image.gray_scale

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ImageBuilder

class GrayScaleImage internal constructor(
    width: Int,
    height: Int,
    pixels: Array<Array<GrayScalePixel>>
) : Image<GrayScalePixel>(width, height, pixels) {
    override fun getBuilder(width: Int, height: Int): ImageBuilder<GrayScalePixel> =
        GrayScaleImageBuilder(width, height)

    override fun toOnePixel(pixels: List<GrayScalePixel>): GrayScalePixel =
        GrayScalePixel(pixels
            .map { it.scale }
            .average()
            .toFloat()
        )
}