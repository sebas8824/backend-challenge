package com.challenge.imagesegmentation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.challenge.imagesegmentation.core.ImageAnalyser;

@WebServlet("/ImageSegmentationServlet")
public class ImageSegmentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageSegmentationServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");		
		String url = "http://24.media.tumblr.com/tumblr_lfp3qax6Lm1qfmtrbo1_1280.jpg";
		ImageAnalyser segmentedImage = new ImageAnalyser();
		
		BufferedImage image = segmentedImage.ImageAnalyser(url);
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		out.close();		
	}
}
