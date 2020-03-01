package com.furtak.ascii_image_converter.image.ascii

import com.furtak.ascii_image_converter.image.Pixel

data class ASCIIPixel(
    val character: Char
) : Pixel() {
    override fun toString(): String {
        return character.toString()
    }
}