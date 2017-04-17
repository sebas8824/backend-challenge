package com.challenge.imagesegmentation.core.utils;

public class Utils {
    public int darkenColor(double darkenK, int color) {
        int kColor = 0;
        if( color + ((int)darkenK*color) < 256) {
            kColor = color + ((int)darkenK*color);
        } else {
            kColor = color + (color + ((int)darkenK*color) - color);
        }
        return kColor;
    }
}
