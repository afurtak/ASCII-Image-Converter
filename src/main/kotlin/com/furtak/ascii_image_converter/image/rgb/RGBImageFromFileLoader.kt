package com.furtak.ascii_image_converter.image.rgb

import com.furtak.ascii_image_converter.image.times
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class RGBImageFromFileLoader {
    fun loadFromFile(path: String): RGBImage? {
        val img: BufferedImage = ImageIO.read(File(path)) ?: return null
        return convertBufferedImage(img)
    }

    fun convertBufferedImage(img: BufferedImage): RGBImage =
        RGBImageBuilder(img.width, img.height).apply {
            ((0 until img.width) times (0 until img.height)).forEach { (x, y) ->
                val pixel = Color(img.getRGB(x, y))
                setPixel(x, y, RGBPixel(pixel.red.toShort(), pixel.green.toShort(), pixel.blue.toShort()))
            }
        }.build() as RGBImage
}