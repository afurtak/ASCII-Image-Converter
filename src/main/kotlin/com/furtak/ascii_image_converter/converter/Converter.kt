package com.furtak.ascii_image_converter.converter

import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.Pixel

interface Converter<T1: Pixel, T2: Pixel> {
    fun convert(inputImage: Image<T1>, width: Int = inputImage.width, height: Int = inputImage.height): Image<T2>
}