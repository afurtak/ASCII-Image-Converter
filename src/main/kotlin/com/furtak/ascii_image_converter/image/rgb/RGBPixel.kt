package com.furtak.ascii_image_converter.image.rgb

import com.furtak.ascii_image_converter.image.gray_scale.GrayScalePixel
import com.furtak.ascii_image_converter.image.Pixel

data class RGBPixel(
    val red: Short = 0,
    val green: Short = 0,
    val blue: Short = 0
) : Pixel() {
    fun toGrayScale(): GrayScalePixel {
        val value = arrayOf(red, green, blue).average().toShort()
        return GrayScalePixel(value.toFloat() / 255)
    }
}