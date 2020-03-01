package com.furtak.ascii_image_converter.image.rgb

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ImageBuilder

class RGBImageBuilder(width: Int, height: Int) : ImageBuilder<RGBPixel>(width, height) {
    override fun getPixel(x: Int, y: Int): RGBPixel =
        RGBPixel()

    override fun buildFromPixelLists(pixels: List<List<RGBPixel>>): Image<RGBPixel> =
        RGBImage(width, height, pixels.map { it.toTypedArray() }.toTypedArray())
}