package com.furtak.ascii_image_converter.converter

import com.furtak.ascii_image_converter.image.rgb.RGBImageFromFileLoader
import org.junit.Test


internal class GrayScaleToAsciiConverterTest {
    @Test
    fun simpleTestConverter() {
        val converter =
            GrayScaleToAsciiConverter("\$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
        val image = RGBImageFromFileLoader().loadFromFile("src\\test\\resources\\obraz.png")

        println(
            converter.convert(
                RGBToGrayScaleConverter()
                    .convert(image!!, image.width, image.height),
                image.width, image.height
            )
        )
    }

    @Test
    fun lenaTestConverter() {
        val converter =
            GrayScaleToAsciiConverter("\$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
        val image = RGBImageFromFileLoader().loadFromFile("src\\test\\resources\\lena.jpg")

        println(
            converter.convert(
                RGBToGrayScaleConverter()
                    .convert(image!!, image.width, image.height), image.width / 10, image.height / 5
            )
        )
    }

    @Test
    fun blackWhiteTestConverter() {
        val converter =
            GrayScaleToAsciiConverter("\$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
        val image = RGBImageFromFileLoader().loadFromFile("src\\test\\resources\\blackWhite.jpeg")

        println(
            converter.convert(
                RGBToGrayScaleConverter()
                    .convert(image!!, image.width, image.height), image.width / 10, image.height / 5
            )
        )
    }

    @Test
    fun moniaTestConverter() {
        val converter =
            GrayScaleToAsciiConverter("\$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
        val image = RGBImageFromFileLoader().loadFromFile("src\\test\\resources\\monia.jpg")

        println(
            converter.convert(
                RGBToGrayScaleConverter()
                    .convert(image!!, image.width, image.height), image.width / 10, image.height / 5
            )
        )
    }
}