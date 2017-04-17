# Image Segmentation

For this challenge the basic steps for the image segmentation were the following:

* Obtained the width and the height of the image in order to analyse each pixed of the image.
* For each pixel, obtained its RGB value and checked which pixels had the highest blue value.
* For each pixel with the highest blue value, assigned it's number to both red and green.
* Applied a "darken value" coeficient for each processed gray pixel, in this project is 0.5 (a given number for no apparent reason)
* Since every RGB value must not be superior of 255 (http://stackoverflow.com/questions/20486700/why-we-always-divide-rgb-values-by-255), there was a calculation that didn't make the color result being superior of that limit.
* Returned the pixel with the new color values in RGB scales
* Built and returned the buffered image.