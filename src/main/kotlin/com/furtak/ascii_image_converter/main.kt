package com.furtak.ascii_image_converter

import com.furtak.ascii_image_converter.converter.GrayScaleToAsciiConverter
import com.furtak.ascii_image_converter.converter.RGBToGrayScaleConverter
import com.furtak.ascii_image_converter.image.Image
import com.furtak.ascii_image_converter.image.ascii.ASCIIPixel
import com.furtak.ascii_image_converter.image.gray_scale.GrayScalePixel
import com.furtak.ascii_image_converter.image.rgb.RGBImage
import com.furtak.ascii_image_converter.image.rgb.RGBImageFromFileLoader
import org.apache.commons.cli.*
import java.io.PrintWriter
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val options = Options()

    val input = Option("i", "input", true, "input file path")
    input.isRequired = true
    options.addOption(input)

    val output = Option("o", "output", true, "output file")
    output.isRequired = false
    options.addOption(output)

    val scaleXOption = Option("x", "scalex", true, "scale x in percentage")
    scaleXOption.isRequired = false
    options.addOption(scaleXOption)

    val scaleYOption = Option("y", "scaley", true, "scale y in percentage")
    scaleYOption.isRequired = false
    options.addOption(scaleYOption)

    val parser: CommandLineParser = DefaultParser()
    val formatter = HelpFormatter()
    val cmd: CommandLine

    try {
        cmd = parser.parse(options, args)
    } catch (e: ParseException) {
        e.printStackTrace()
        formatter.printHelp("utility-name", options)
        exitProcess(1)
    }

    val inputFilePath: String = cmd.getOptionValue("input")
    val outputFilePath: String = cmd.getOptionValue("output") ?: "output.txt"

    val scaleX: Float = cmd.getOptionValue("scalex")?.toFloat()?.div(100) ?: 1f
    val scaleY: Float = cmd.getOptionValue("scaley")?.toFloat()?.div(100) ?: 1f

    println("$scaleX, $scaleY")

    val asciiImage = RGBImageFromFileLoader()
        .loadFromFile(inputFilePath)
        ?.toGrayScaleImage()
        ?.toASciiImage(scaleX, scaleY)
        ?.toString()

    PrintWriter(outputFilePath)
        .apply { println(asciiImage) }
        .close()
}

fun RGBImage.toGrayScaleImage(): Image<GrayScalePixel> {
    return RGBToGrayScaleConverter()
        .convert(this)
}

fun Image<GrayScalePixel>.toASciiImage(scaleX: Float = 1f, scaleY: Float = 1f): Image<ASCIIPixel> {
    return GrayScaleToAsciiConverter(" .:-=+*#%@".reversed())
        .convert(this, (width * scaleX).toInt(), (height * scaleY).toInt())
}