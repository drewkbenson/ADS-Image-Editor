# ADS-Image-Editor
An Image Editor made during a computer science class in the senior year of high school and the summer after.  

For examples of what the output, refer to the link below:

https://imgur.com/a/WSUpTU2


Tester.java/Tester2.java/testImage1.java

Testing the program, you can change the image by calling methods on an imageEditor object.  You can see the current available changes by looking at the methods under imageEditor.java below


ImageReader.java


    Reads in the image, returns the image when called, can also return the width and height when prompted.


ImageCombiner.java

    Allows for two images to be read in and combined.


ImageBlurrer.java

    This class helps ImageEditor blur images.  Allows for two kinds of blurs to be applied to an image, a gaus blur or a box blur.


hueShifter.java

    I did not write this credit to abdulfatir.com for this code.  Shifts the hue of every pixel to a specified value.


ImageHueShifter.java

    I did not write this credit to abdulfatir.com for this code, I however did make it easier for my existing program to use.


warholSupport.java

    This class is meant to provide support to the warhol methods in the ImageEditor class.


ImageEditor.java

    This file is the one that will be doing all of the major editing of any image that is put in. Its functions are as follows

    -refresh
        refreshes the image to its original form.  All changes are discarded

    -randomImage
     randomizes the image by pulling multiple of the following commands and applying them to the image

    -heaMapRed/heatMapBlue/HeatMapGreen
        makes all of the RGB values of each pixel equal to the r/g/b value of said pixel, thus creating a black and white effect where black is coorelated with a higher concentration of the color

    -blackAndWhite
         makes the iamge black and white by taking the average of the rgb values and applying them to that pixel

    -boxBlur
        allows the user to input a number (or not) and applies a blur by averaging the value of each pixel and the ones within a box with side length 2*number+1

    -randomFill
        fills the image with random rgb values

    -jpegify
        reduces the number of colors that the image can be.  Inputing a higher number will allow fewer colors.

    -brighten
        brightens the image, such that all the values are closer to true white

    -brightenFactor
        brightens the image by a factor, making all the values closer to white.  The brighten factor is based on the percent passed in.

    -darken
        darkens the image, such that all values become closer to true black

    -darkenFactor
        darkens the image by a factor, bringing all of the values closer to black.  The factor is based on the percent passed in.

    -negative
        takes the opposite (abs(r/g/b value - 255)) of each pixel, thus creating the negative effect 

    -combineImages
        takes two images of equal dimentions and averages each rgb value of each pixel, thus making both visible

    -switchColors
        renderes the image, but switches the two colors that the user inputs

    -buildPicture
        changes each pixel in the original image to match what is in the arrays of colors

    -transHue
        rotates the hue around the color circle.  Rotates the hue of every pixel (or hue of each pixel between the two specified hues) the given value

    -shiftHue
        changes the hue of every pixel to the specified value

    -warholShift
        makes a new image, calls shiftHue on the current image n^2 number of times and places the edited image into the new one where n is the number of images on one side.  The hue chosen is incremented by 360/n^2 each time shiftHue is called

    -warholShiftRandom
        does the same thing as warholShift, however the hue is chosen randomly

    -warholTrans
     makes a new image, calls transHue on the current image n^2 number of times and places the edited iamge into the new one where n is the number of images on one side.  The trans is chosen by incremting the value by 360/n^2 each time transHue is called

    -buildPicture
        this buildPicture takes the rgb values and builds the image off of them instead of the global rgb values

    -drawSquare
        draws a square on the image with width w, length l, and at position (x,y)

    -getPixelColor
        returns the color of the pixel at position (x,y)

    -getExt
        each time a function is called a string is added to ext.  getExt returns the string, so you can determine which methods were called and in what order

    -write
        writes the file at the location on your computer.  Make sure your path is valid or else an error will be called

    -resize
        resizes the image to the passed in size
