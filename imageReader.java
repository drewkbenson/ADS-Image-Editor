import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.net.*;

public class imageReader 
{
	private static BufferedImage image = null;
	private File f = null;
	private int width = 0;
	private int height = 0;
	private URL url = null;
	
	public imageReader(String location)
	{
		try
		{
			image = ImageIO.read(new File(location));
			width = image.getWidth();
			height = image.getHeight();
		}
		catch (Exception e)
		{
			System.out.println("It doesn't exist");
		}
	}
	
	public static BufferedImage getImage()
	{
		return image;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
