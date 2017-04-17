package com.challenge.imagesegmentation.core;

import javax.imageio.ImageIO;

import com.challenge.imagesegmentation.core.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ImageAnalyser {
    
    
    public BufferedImage ImageAnalyser(String resource) {
    	int width;
        int height;
        double dv = 0.5;
    	String website = resource;
        BufferedImage image = null;
        
        Utils utils = new Utils();
        
        try {
            URL url = new URL(website);
            image = ImageIO.read(url);
            width = image.getWidth();
            height = image.getHeight();
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    Color c = new Color(image.getRGB(j, i));
                    Color newColor;
                    if(c.getBlue() > c.getRed() && c.getBlue() > c.getGreen()) {
                        int greyPx = utils.darkenColor(dv, c.getBlue());
                        newColor = new Color(greyPx, greyPx, c.getBlue());
                    } else {
                        newColor = new Color(utils.darkenColor(dv, c.getRed()), utils.darkenColor(dv, c.getGreen()), utils.darkenColor(dv, c.getBlue()));
                    }
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return image;
    }
}