package day.pkg04;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Day04 {

    public static void main(String[] args) throws IOException {
        
        
        BufferedImage inputImage = ImageIO.read(new File("c:/users/unouser/desktop/photo.jpg"));
        
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth() * 10,  10*inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        for(int y = 0; y < outputImage.getHeight() - 10;  y++)
        {
            for(int x = 0; x < outputImage.getWidth() - 10 ; x++)
            {
                ///Where on the original photo I'm sampling
                float x_old = x/10.0f;
                float y_old = y/10.0f;
                
                int pixelFirst = inputImage.getRGB((int)x_old, (int)y_old );
                int pixelSecond =  inputImage.getRGB((int)x_old + 1, (int)y_old  );
                int pixelThird = inputImage.getRGB((int)x_old, (int)y_old + 1);
                int pixelFourth =  inputImage.getRGB((int)x_old + 1, (int)y_old  + 1);
                
                
                Color cFirst = new Color(pixelFirst);
                Color cSecond = new Color(pixelSecond);
                Color cThird = new Color(pixelThird);
                Color cFourth = new Color(pixelFourth);
                
                float iValueX = (float)x/10.0f -  (int)(x/10);
                float iValueY = (float)y/10.0f -  (int)(y/10);
                
                int iPixelOne = interpolate(iValueX, cFirst, cSecond);
                int iPixelTwo = interpolate(iValueX, cThird, cFourth);
                
                int iPixelFinal = interpolate(iValueY, new Color(iPixelOne), new Color(iPixelTwo));
                
                outputImage.setRGB(x, y, iPixelFinal);
            }
        }
        ImageIO.write(outputImage, "PNG", new File("c:/users/unouser/desktop/newPhoto.png") );
    }

    private static int interpolate(float iValue, Color cFirst, Color cSecond) {
        int iRed = (int) ((1 - iValue) * cFirst.getRed() + iValue * cSecond.getRed());
        int iGreen = (int) ((1 - iValue) * cFirst.getGreen() + iValue * cSecond.getGreen());
        int iBlue = (int) ((1 - iValue) * cFirst.getBlue() + iValue * cSecond.getBlue());
        Color iColor = new Color(iRed, iGreen, iBlue);
        int iPixel = iColor.getRGB();
        return iPixel;
    }
    
}
