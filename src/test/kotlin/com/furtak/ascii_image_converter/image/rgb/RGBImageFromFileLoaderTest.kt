package com.furtak.ascii_image_converter.image.rgb

import org.junit.Test
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

internal class RGBImageFromFileLoaderTest {
    @Test
    fun testLoadImage() {
        val image: BufferedImage? = ImageIO.read(File("src/test/resources/obraz.png"))
        assert(image != null)
        RGBImageFromFileLoader().convertBufferedImage(image!!)
    }
}