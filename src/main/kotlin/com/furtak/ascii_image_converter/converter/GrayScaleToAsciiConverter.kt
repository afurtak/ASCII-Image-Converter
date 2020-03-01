package com.furtak.ascii_image_converter.converter

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ascii.ASCIIPixel
import com.furtak.ascii_image_converter.image.gray_scale.GrayScalePixel
import com.furtak.ascii_image_converter.image.times
import java.lang.Integer.min

class GrayScaleToAsciiConverter(private val greyScale: String) : Converter<GrayScalePixel, ASCIIPixel> {
    override fun convert(inputImage: Image<GrayScalePixel>, width: Int, height: Int): Image<ASCIIPixel> =
        with(inputImage.resize(width, height)) {
            val builder = com.furtak.ascii_image_converter.image.ascii.ASCIIImageBuilder(width, height)
            ((0 until width) times (0 until height)).forEach {(x, y) ->
                builder.setPixel(x, y, this[x, y].toASCIIPixel())
            }
            builder.build()
        }

    private fun GrayScalePixel.toASCIIPixel(): ASCIIPixel =
        ASCIIPixel(greyScale[min((greyScale.length * this.scale).toInt(), greyScale.length - 1)])
}