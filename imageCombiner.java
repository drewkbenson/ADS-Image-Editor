import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class imageCombiner 
{
	private BufferedImage image1 = null;
	private BufferedImage image2 = null;
	private BufferedImage after = null;
	private short width1 = 0;
	private short height1 = 0;
	private short width2 = 0;
	private short height2 = 0;
	private short[][] blues = null;
	private short[][] reds = null;
	private short[][] greens = null;
	
	public imageCombiner(String location1, String location2)
	{
		imageReader r1 = new imageReader(location1);
		image1 = imageReader.getImage();
		imageReader r2 = new imageReader(location2);
		image2 = imageReader.getImage();
		width1 = (short) image1.getWidth();
		height1 = (short) image1.getHeight();
		width2 = (short) image2.getWidth();
		height2 = (short) image2.getHeight();
	}
	
	public void combine()
	{
		if(width1 == width2 && height1 == height2)
		{
			reds = new short[width1][height1];
			blues = new short[width1][height1];
			greens = new short[width1][height1];
			System.out.println(height1 + ":" + width1);
			for(int i = 0; i < width1; i++)
			{
				for(int j = 0; j < height1; j++)
				{
					reds[i][j]   = (short) ((((image1.getRGB(i,j) & 0x00ff0000) >> 16)+((image2.getRGB(i,j) & 0x00ff0000) >> 16))/2);
					greens[i][j] = (short) ((((image1.getRGB(i,j) & 0x0000ff00) >> 8)+((image2.getRGB(i,j) & 0x0000ff00) >> 8))/2);
					blues[i][j]  = (short) ((((image1.getRGB(i,j) & 0x000000ff))+(image2.getRGB(i,j) & 0x000000ff))/2);
				}
			}
			buildPicture();
		}
		else
		{
			System.out.println("no");
		}
	}
	
	public void combine(double factor)
	{
		if(width1 == width2 && height1 == height2)
		{
			reds = new short[width1][height1];
			blues = new short[width1][height1];
			greens = new short[width1][height1];
			System.out.println(height1 + ":" + width1);
			for(int i = 0; i < width1; i++)
			{
				for(int j = 0; j < height1; j++)
				{
					reds[i][j]   = (short)(((image1.getRGB(i,j) & 0x00ff0000) >> 16) * factor + (1-factor)*((image2.getRGB(i,j) & 0x00ff0000) >> 16));
					greens[i][j] = (short)(((image1.getRGB(i,j) & 0x0000ff00) >> 8) * factor + (1-factor)*((image2.getRGB(i,j) & 0x0000ff00) >> 8));
					blues[i][j]  = (short)(((image1.getRGB(i,j) & 0x000000ff)) * factor + (1-factor)*(image2.getRGB(i,j) & 0x000000ff));
				}
			}
			buildPicture();
		}
		else
		{
			System.out.println("no");
		}
	}
	
	private void buildPicture()
	{		
		Graphics2D painter = image1.createGraphics();
		
		for(int i = 0; i < width1; i++)
		{
			for(int j = 0; j < height1; j++)
			{
				painter.setColor(new Color(reds[i][j], greens[i][j], blues[i][j]));
				painter.fill(new Rectangle(i, j, 1, 1));
			}
		}
		painter.dispose();
	}
	
	public short[][] getBlues()
	{
		return blues;
	}
	
	public short[][] getGreens()
	{
		return greens;
	}
	
	public short[][] getReds()
	{
		return reds;
	}
	
	public BufferedImage getAfter()
	{
		return image1;
	}
	
	public void setImage1(String location)
	{
		imageReader r1 = new imageReader(location);
		image1 = imageReader.getImage();
		height1 = (short) image1.getHeight();
		width1 = (short) image1.getWidth();
	}
	
	public void setImage2(String location)
	{
		imageReader r2 = new imageReader(location);
		image2 = imageReader.getImage();
		height2 = (short) image2.getHeight();
		width2 = (short) image2.getWidth();
	}
	
	public void write(String location)
	{
		File outputfile = new File(location);
	    try 
	    {
			ImageIO.write(image1, "jpg", outputfile);
		} 
	    catch (IOException e) 
	    {
			System.out.println("what is wrong with this program");
			System.out.println("No clue");
		}
	}
}



