package com.furtak.ascii_image_converter.image.gray_scale

import com.furtak.ascii_image_converter.image.Pixel
import com.furtak.ascii_image_converter.image.rgb.RGBPixel

data class GrayScalePixel(
    val scale: Float = 0.0f
) : Pixel() {
    fun toRGBPixel(): RGBPixel {
        return RGBPixel(
            (scale * 255).toShort(),
            (scale * 255).toShort(),
            (scale * 255).toShort()
        )
    }
}