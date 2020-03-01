package com.furtak.ascii_image_converter.converter

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.gray_scale.GrayScaleImageBuilder
import com.furtak.ascii_image_converter.image.gray_scale.GrayScalePixel
import com.furtak.ascii_image_converter.image.rgb.RGBPixel

class RGBToGrayScaleConverter : Converter<RGBPixel, GrayScalePixel> {
    override fun convert(inputImage: Image<RGBPixel>, width: Int, height: Int): Image<GrayScalePixel> {
        return GrayScaleImageBuilder(width, height)
            .apply {
                for (x in 0 until width)
                    for (y in 0 until height)
                        setPixel(x, y, inputImage[x, y].toGrayScale())
            }.build()
    }
}