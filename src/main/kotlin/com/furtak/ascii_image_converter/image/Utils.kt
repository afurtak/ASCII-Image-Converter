package com.furtak.ascii_image_converter.image

import com.furtak.ascii_image_converter.image.rgb.RGBPixel

fun List<RGBPixel>.mapRed(): List<Short> {
    return this.map { it.red }
}

fun List<RGBPixel>.mapGreen(): List<Short> {
    return this.map { it.green }
}

fun List<RGBPixel>.mapBlue(): List<Short> {
    return this.map { it.blue }
}

fun List<Short>.averageShort() = this.average().toShort()

fun List<RGBPixel>.toOnePixel(): RGBPixel {
    return RGBPixel(
        mapRed().averageShort(),
        mapGreen().averageShort(),
        mapBlue().averageShort()
    )
}

infix fun IntRange.times(other: IntRange): List<Pair<Int, Int>> {
    return flatMap { lhsElem -> other.map { rhsElem -> lhsElem to rhsElem } }
}

