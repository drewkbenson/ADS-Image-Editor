import java.io.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import static java.lang.System.out;


public class imageHueShifter
{
	public static void main(String args[])throws IOException
	{	 
	}

	public void shiftHue(int iHUE) throws IOException
	{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	float hue =iHUE/360.00f;
	
	BufferedImage raw,processed;
	raw = ImageIO.read(new File("C:\\Users\\Drew\\eclipse-workspace\\ADS Image Editor\\src\\tempC.jpg"));//UPDATE PATH HERE
	
	int WIDTH = raw.getWidth();
	int HEIGHT = raw.getHeight();
	processed = new BufferedImage(WIDTH,HEIGHT,raw.getType());
	for(int Y=0; Y<HEIGHT;Y++)
	{
		for(int X=0;X<WIDTH;X++)
		{
			int RGB = raw.getRGB(X,Y);
			int R = (RGB >> 16) & 0xff;
			int G = (RGB >> 8) & 0xff;
			int B = (RGB) & 0xff;
 			float HSV[]=new float[3];
			Color.RGBtoHSB(R,G,B,HSV);
			processed.setRGB(X,Y,Color.getHSBColor(hue,HSV[1],HSV[2]).getRGB());
		}
	}
	
	ImageIO.write(processed,"PNG",new File("C:\\Users\\Drew\\eclipse-workspace\\ADS Image Editor\\src\\tempC.jpg"));//UPDATE PATH HERE
	
 	}
}
