import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.*;

/* What did this project become
 * 
 */

public class imageEditor 
{
	private BufferedImage image = null;
	private String f = null;
	private int width = 0;
	private int height = 0;
	//private int[][] colors = null;
	private short[][] blues = null;
	private short[][] reds = null;
	private short[][] greens = null;
	private String ext = null;
	
	public imageEditor(String location) 
	{
		ext = "";
		f = location;
		imageReader r = new imageReader(location);
		image = imageReader.getImage();
		width = image.getWidth();
		height = image.getHeight();
		this.getColors();
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	public void refresh()
	{
		ext = "";
		imageReader r = new imageReader(f);
		image = imageReader.getImage();
		width = image.getWidth();
		height = image.getHeight();
		this.getColors();
	}
	
	public void randomImage(int num)
	{
		ext = ext + "_RANDOM" + num;
		int[] template = new int[num];
		for(int i = 0; i < num; i++)
		{
			template[i] = (int)(Math.random()*9);
		}
		int chose = 0;
		
		for(int i = 0; i < num; i++)
		{
			if(template[i] == 0)
			{
				chose = (int)(Math.random()*3);
				if(chose == 0)
				{
					heatMapRed();
				}
				else if(chose == 1)
				{
					heatMapBlue();
				}
				else if(chose == 2)
				{
					heatMapGreen();
				}
			}
			else if(template[i] == 1)
			{
				chose = (int)(Math.random()*2);
				if(chose == 1)
				{
					chose = (int)(Math.random()*20);
					boxBlur(chose);
				}
				else
				{
					chose = (int)(Math.random()*20);
					boxBlurShort(chose);
				}
				chose = (int)(Math.random()*20);
				boxBlur(chose);
			}
			else if(template[i] == 2)
			{
				chose = (int)(Math.random()*3);
				
				if(chose == 0)
				{
					removeRed();
				}
				else if(chose == 1)
				{
					removeBlue();
				}
				else if(chose == 2)
				{
					removeGreen();
				}
			}
			else if(template[i] == 3)
			{
				chose = 3 + (int)(Math.random()*3);
			}
			else if(template[i] == 4)
			{
				negative();
			}
			else if(template[i] == 5)
			{
				chose = (int)(Math.random()*360);
				transHue(chose);
			}
			else if(template[i] == 6)
			{
				chose = (int)(Math.random()*360);
				transHueSection(chose, (int)(Math.random()*180), 180 + (int)(Math.random()*180));
			}
			else if(template[i] == 7)
			{
				chose = (int)(Math.random()*360);
				try 
				{
					shiftHue(chose);
				}
				catch (IOException e) 
				{
					
				}
			}
			else if(template[i] == 8)
			{
				chose = (int)(Math.random()*2);
				if(chose == 0)
				{
					warholShift(3);
				}
				else
				{
					warholShiftRandom(3);
				}
			}
		}
	}
	
	public void heatMapRed()
	{
		ext = ext + "_HeatMapRed";
		//int[][] newC = new int[height][width];
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				blues[i][j] = (short) (255-reds[i][j]);
				greens[i][j] = (short) (255-reds[i][j]);
				reds[i][j] = (short) (255-reds[i][j]);
			}
		}
		buildPicture();
	}
	
	public void heatMapGreen()
	{
		ext = ext + "_HeatMapGreen";
		//int[][] newC = new int[height][width];
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = (short) (255-greens[i][j]);
				blues[i][j] = (short) (255-greens[i][j]);
				greens[i][j] = (short) (255-greens[i][j]);
			}
		}
		buildPicture();
	}
	
	public void heatMapBlue()
	{
		ext = ext + "HeatMapBlue";
		//int[][] newC = new int[height][width];
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				greens[i][j] = (short) (255-blues[i][j]);
				reds[i][j] = (short) (255-blues[i][j]);
				blues[i][j] = (short) (255-blues[i][j]);
			}
		}
		buildPicture();
	}
	
	public void blackWhite()
	{
		ext = "_BlackWhite";
		short hold = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				hold = (short) (hold + reds[i][j]);
				hold = (short) (hold + greens[i][j]);
				hold = (short) (hold + blues[i][j]);
				hold = (short) (hold / 3);
				reds[i][j] = hold;
				greens[i][j] = hold;
				blues[i][j] = hold;
				hold = 0;
			}
			
		}
		buildPicture();
	}

	public void blackWhite(double str)
	{
		ext = "_BlackWhite";
		short hold = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				hold = (short) (hold + reds[i][j]);
				hold = (short) (hold + greens[i][j]);
				hold = (short) (hold + blues[i][j]);
				hold = (short) (hold / 3);
				reds[i][j] = (short) (hold * str + reds[i][j]*(1-str));
				greens[i][j] = (short) (hold * str + greens[i][j]*(1-str));
				blues[i][j] = (short) (hold * str + blues[i][j]*(1-str));
				hold = 0;
			}
			
		}
		buildPicture();
	}
	
	public void boxBlur(int num)
	{
		ext = ext + "_BoxBlur" + num;
		imageBlurrer b = new imageBlurrer(f);
		b.boxBlur(num,  reds, greens, blues);
		image = b.getImage();
		getColors();
	}
	
	public void boxBlurShort(int num)
	{
		ext = ext + "_BoxBlurShort" + num;
		imageBlurrer b = new imageBlurrer(f);
		b.boxBlur(num,  reds, greens, blues);
		image = b.getImage();
		getColors();
	}
	
	public void gausBlur()
	{
		ext = ext + "_GausBlurNorm";
		imageBlurrer b = new imageBlurrer(f);
		b.gausBlur(reds, greens, blues);
		image = b.getImage();
		getColors();
	}
	
	public void gausBlurWrong()
	{
		ext = ext + "_GausBlurWr";
		imageBlurrer b = new imageBlurrer(f);
		b.gausBlur(reds, greens, blues);
		image = b.getImage();
		getColors();
	}
	
	public void boxBlurWrong(int num)
	{
		ext = ext + "_BoxBlurWr" + num;
		imageBlurrer b = new imageBlurrer(f);
		b.boxBlurWrong(num, reds, greens, blues);
		image = b.getImage();
		getColors();
	}

	public void gausBlur(int W, double sigma)
	{
		ext = ext + "_GausBlur" + W + "_" + sigma;
		imageBlurrer b = new imageBlurrer(f);
		b.gausBlur(reds, greens, blues, sigma, W);
		image = b.getImage();
		getColors();
	}
	
	public void switchRedBlue()
	{
		ext = ext + "_SwitchRedBlue";
		short[][] l = new short[0][0];
		l = blues;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				l[i][j] = blues[i][j];
			}
		}
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				blues[i][j] = reds[i][j];
			}
		}
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = l[i][j];
			}
		}
		buildPicture();
	}
	
	public void switchGreenRed()
	{
		ext = ext + "_SwitchGreenRed";
		short [][] l = new short[0][0];
		l = blues;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				l[i][j] = reds[i][j];
			}
		}
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = greens[i][j];
			}
		}
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				greens[i][j] = l[i][j];
			}
		}
		buildPicture();
	}
	
	public void switchBlueGreen()
	{
		ext = ext + "_SwitchBlueGreen";
		short [][] l = new short[0][0];
		l = blues;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				l[i][j] = blues[i][j];
			}
		}
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				blues[i][j] = greens[i][j];
			}
		}
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				greens[i][j] = (short) l[i][j];
			}
		}
		buildPicture();
	}
	
	public void removeRed()
	{
		ext = ext + "_NoRed";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = 0;
			}
		}
		buildPicture();
	}
	
	public void removeBlue()
	{
		ext = ext + "_NoBlue";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				blues[i][j] = 0;
			}
		}
		buildPicture();
	}
	
	public void removeGreen()
	{
		ext = ext + "_NoGreen";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				greens[i][j] = 0;
			}
		}
		buildPicture();
	}
	
	public void randomFill()
	{
		ext = "_Randomized";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = (short)(Math.random()*255);
				greens[i][j] = (short)(Math.random()*255);
				blues[i][j] = (short)(Math.random()*255);
			}
		}
		buildPicture();
	}
	
	public void jpegify()
	{
		ext = ext + "_Jpeged";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j]=(short) (reds[i][j]-reds[i][j]%32);
				greens[i][j]=(short) (greens[i][j]-greens[i][j]%32);
				blues[i][j]=(short) (blues[i][j]-blues[i][j]%32);
			}
		}
		buildPicture();
	}
	
	public void jpegify(int factor)
	{
		
		int mod = 1;
		for(int i = 0; i < factor; i++)
		{
			mod = mod * 2;
		}
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j]=(short) (reds[i][j]-reds[i][j]%mod);
				greens[i][j]=(short) (greens[i][j]-greens[i][j]%mod);
				blues[i][j]=(short) (blues[i][j]-blues[i][j]%mod);
			}
		}
		ext = ext + "_JpegedTo" + mod;
		buildPicture();
	}
	
	public void brighten(int d)
	{
		ext = ext + "_Bright" + d;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = (short) (reds[i][j] + d);
				if(reds[i][j] > 255)
				{
					reds[i][j] = 255;
				}
				
				greens[i][j] = (short) (greens[i][j] + d);
				if(greens[i][j] > 255)
				{
					greens[i][j] = 255;
				}
				
				blues[i][j] = (short) (blues[i][j] + d);
				if(blues[i][j] > 255)
				{
					blues[i][j] = 255;
				}
			}
		}
		buildPicture();
	}
	
	public void darken(int d)
	{
		ext = ext + "_Dark" + d;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				if(reds[i][j] >= d)
				{
					reds[i][j] = (short) (reds[i][j] - d);
				}
				else
				{
					reds[i][j] = 0;
				}
				
				if(greens[i][j] >= d)
				{
					greens[i][j] = (short) (greens[i][j] - d);
				}
				else
				{
					greens[i][j] = 0;
				}
				
				if(blues[i][j] >= d)
				{
					blues[i][j] = (short) (blues[i][j] - d);
				}
				else
				{
					blues[i][j] = 0;
				}
			}
		}
		buildPicture();
	}
	
	public void brightenFactor(int d)
	{
		ext = ext + "_BrightFac" + d;
		int cur = 0;
		double f = 0;
		f = 100-d;
		f = f/100;
		f = 1 - f;
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				cur = reds[i][j];
				cur = 255 - cur;
				cur = (int) (cur * f);
				reds[i][j] = (short) (reds[i][j] + cur);
				
				cur = greens[i][j];
				cur = 255 - cur;
				cur = (int) (cur * f);
				greens[i][j] = (short) (greens[i][j] + cur);
				
				cur = blues[i][j];
				cur = 255 - cur;
				cur = (int) (cur * f);
				blues[i][j] = (short) (blues[i][j] + cur);
			}
		}
		buildPicture();
	}
	
	public void darkenFactor(int d)
	{
		ext = ext + "_DarkFactor" + d;
		double f = 0;
		f = 100-d;
		f = f/100;
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = (short) (reds[i][j] * f);
				greens[i][j] = (short) (greens[i][j] * f);
				blues[i][j] = (short) (blues[i][j] * f);
			}
		}
		buildPicture();
	}
	
	public void negative()
	{
		ext = ext + "_Negative";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j] = (short) (255 - reds[i][j]);
				greens[i][j] = (short) (255 - greens[i][j]);
				blues[i][j] = (short) (255 - blues[i][j]);
			}
		}
		buildPicture();
	}
	
	public void combineImages(String location1, String location2)
	{
		ext = ext + "_Combined";
		imageCombiner c = new imageCombiner(location1, location2);
		c.combine();
		reds = (short[][]) c.getReds();
		blues = (short[][])c.getBlues();
		greens =(short[][]) c.getGreens();
		image = c.getAfter();
		buildPicture();
	}
	
	public void combineImages(String location1, String location2, double factor)
	{
		ext = ext + "_Combined_Image1=" + factor;
		imageCombiner c = new imageCombiner(location1, location2);
		c.combine(factor);
		reds = c.getReds();
		blues = c.getBlues();
		greens = c.getGreens();
		image = c.getAfter();
		buildPicture();
	}
	
	public void switchColors(int s1, int s2)
	{
		ext = ext + "_Switched" + s1 + "_" + s2;
	if(s1 == 0)
	{
		if(s2 == 0)
		{
			buildPicture(reds, greens, blues);
		}
		if(s2 == 1)
		{
			buildPicture(greens, reds, blues);
		}
		if(s2 == 2)
		{
			buildPicture(blues, greens, reds);
		}
	}
	
	if(s1 == 1)
	{
		if(s2 == 0)
		{
			buildPicture(greens, reds, blues);
		}
		if(s2 == 1)
		{
			buildPicture(reds, greens, blues);
		}
		if(s2 == 2)
		{
			System.out.println("working");
			buildPicture(reds, blues, greens);
		}
	}
	
	if(s1 == 2)
	{
		if(s2 == 0)
		{
			buildPicture(blues, greens, reds);
		}
		if(s2 == 1)
		{
			buildPicture(reds, blues, greens);
		}
		if(s2 == 2)
		{
			buildPicture(reds, greens, blues);
		}
	}
	
	if(s1 == 3)
	{
		if(s2 == 0)
		{
			buildPicture(blues, reds, greens);
		}
		if(s2 == 1)
		{
			buildPicture(greens, blues, reds);
		}
	}
	
	if(s1 == 4)
	{
		if(s2 == 0)
		{
			buildPicture(greens, blues, reds);
		}
		if(s2 == 1)
		{
			buildPicture(blues, reds, greens);
		}
	}
	
	}
	
	private void buildPicture()
	{
		Graphics2D painter = image.createGraphics();
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				try
				{
				painter.setColor(new Color(reds[i][j], greens[i][j], blues[i][j]));
				painter.fill(new Rectangle(i, j, 1, 1));
				}
				catch (IllegalArgumentException e)
				{
					System.out.println(reds[i][j] + " " + greens[i][j] + " " + blues[i][j]);
				}
			}
		}
		painter.dispose();
	}
	
	public void transHue(int iHUE)
	{
		ext = ext + "_TransHue" + iHUE;
		while(iHUE > 360)
		{
			iHUE = iHUE - 360;
		}
		while(iHUE <= 0)
		{
			iHUE = iHUE + 360;
		}
		
		float hue =iHUE/360.00f;
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				float HSV[]=new float[3];
				Color.RGBtoHSB(reds[i][j],greens[i][j],blues[i][j],HSV);
				float nHue = hue + HSV[0];
				if(nHue > 1)
				{
					nHue = nHue - 1;
				}
				image.setRGB(i,j,Color.getHSBColor(nHue,HSV[1],HSV[2]).getRGB());
			}
		}
	}
	
	public void transHueSection(int iHUE, int start, int stop)
	{
		ext = ext + "_TransHue" + iHUE + "_Start" + start + "_Stop" + stop;
		while(iHUE > 360)
		{
			iHUE = iHUE - 360;
		}
		while(iHUE <= 0)
		{
			iHUE = iHUE + 360;
		}
		
		float startHue = start/360.00f;
		float stopHue = stop/360.00f;
		float hue =iHUE/360.00f;
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				float HSV[]=new float[3];
				Color.RGBtoHSB(reds[i][j],greens[i][j],blues[i][j],HSV);
				float nHue = hue + HSV[0];
				
				if(nHue > 1)
				{
					nHue = nHue - 1;
				}
				if(HSV[0] > startHue && HSV[0] < stopHue)
				{
					image.setRGB(i,j,Color.getHSBColor(nHue,HSV[1],HSV[2]).getRGB());
				}
			}
		}
		write("C:\\Java Images\\temp\\temp.jpg");
		transHueCleanup();
	}
	
	private void transHueCleanup()
	{
		imageReader r = new imageReader("C:\\Java Images\\temp\\temp.jpg");
		image = imageReader.getImage();
		this.getColors();
		
	}
	
	public void shiftHue(int iHUE) throws IOException
	{
		ext = ext + "_ShiftHueTo" + iHUE;
		while(iHUE > 360)
		{
			iHUE = iHUE - 360;
		}
		while(iHUE <= 0)
		{
			iHUE = iHUE + 360;
		}
		buildPicture();
		write("C:\\Java Images\\temp\\temp.jpg");
		imageHueShifter h = new imageHueShifter();
		System.out.println(iHUE);
		h.shiftHue(iHUE);
		imageReader r = new imageReader("C:\\Java Images\\temp\\tempC.jpg");
		image = imageReader.getImage();
		width = image.getWidth();
		height = image.getHeight();
		this.getColors();
		buildPicture();
	}
	
	public void warholShift()
	{
		ext = ext + "_Warhol";
		BufferedImage processed = new BufferedImage(width*2,height*2,image.getType());
		BufferedImage temp = null;
		warholSupport l = new warholSupport(f);
		temp = l.get1();
		
		System.out.println(width*2);
		short [][] red = new short[width*2][height*2];
		short [][] green = new short[width*2][height*2];
		short [][] blue = new short[width*2][height*2];
		System.out.println(red.length);
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i,j) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i,j) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i,j) & 0x000000ff);
			}
		}
		
		temp = l.get2();
		
		for(int i = width; i < 2*width; i++)
		{
			
			for(int j = 0; j < height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i - width,j) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i - width,j) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i - width,j) & 0x000000ff);
			}

		}
		
		temp = l.get4();
		
		for(int i = 0; i < width; i++)
		{
			for(int j = height; j < 2*height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i,j - height) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i,j - height) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i,j - height) & 0x000000ff);
			}
		}
		
		temp = l.get3();
		
		for(int i = width; i < 2*width; i++)
		{
			for(int j = height; j < 2*height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i - width,j - height) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i - width,j - height) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i - width,j - height) & 0x000000ff);
			}
		}
		reds = red;
		blues = blue;
		greens = green;
		
		height = height * 2;
		width = width * 2;
		image = resize(image, width, height);
		buildPicture();
	}
	
	public void warholShiftRandom()
	{
		ext = ext + "_WarholRandom";
		BufferedImage processed = new BufferedImage(width*2,height*2,image.getType());
		BufferedImage temp = null;
		warholSupport l = new warholSupport(f);
		temp = l.get();
		
		System.out.println(width*2);
		short [][] red = new short[width*2][height*2];
		short [][] green = new short[width*2][height*2];
		short [][] blue = new short[width*2][height*2];
		System.out.println(red.length);
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i,j) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i,j) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i,j) & 0x000000ff);
			}
		}
		
		temp = l.get();
		
		for(int i = width; i < 2*width; i++)
		{
			
			for(int j = 0; j < height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i - width,j) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i - width,j) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i - width,j) & 0x000000ff);
			}

		}
		
		temp = l.get();
		
		for(int i = 0; i < width; i++)
		{
			for(int j = height; j < 2*height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i,j - height) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i,j - height) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i,j - height) & 0x000000ff);
			}
		}
		
		temp = l.get();
		
		for(int i = width; i < 2*width; i++)
		{
			for(int j = height; j < 2*height; j++)
			{
				red[i][j]   = (short) ((temp.getRGB(i - width,j - height) & 0x00ff0000) >> 16);
				green[i][j]  = (short) ((temp.getRGB(i - width,j - height) & 0x0000ff00) >> 8);
				blue[i][j]   = (short) (temp.getRGB(i - width,j - height) & 0x000000ff);
			}
		}
		reds = red;
		blues = blue;
		greens = green;
		
		height = height * 2;
		width = width * 2;
		image = resize(image, width, height);
		buildPicture();
	}
	
	public void warholShift(int num)
	{
		ext = ext + "_Warhol" + num;
		BufferedImage processed = new BufferedImage(width*2,height*2,image.getType());
		BufferedImage temp = null;
		warholSupport l = new warholSupport(f);
		temp = l.get1();
		
		System.out.println(width*num);
		short [][] red = new short[width*num][height*num];
		short [][] green = new short[width*num][height*num];
		short [][] blue = new short[width*num][height*num];
		System.out.println(red.length);
		
		int count = 0;
		
		
		for(int row = 0; row < num; row++)
		{
			for(int col = 0; col < num; col++)
			{
				temp = l.getTemp(count, num*num);
				for(int i = 0 + width*(count%num); i < width + width*(count%num); i++)
				{
					for(int j = 0 + height*(count/num); j < height + height*(count/num); j++)
					{
						//System.out.println(i + " " + j + " " + width*(count%num) + " " + height*(count/num));
						red[i][j]   = (short) ((temp.getRGB(i - width*(count%num),j - height*(count/num)) & 0x00ff0000) >> 16);
						green[i][j]  = (short) ((temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x0000ff00) >> 8);
						blue[i][j]   = (short) (temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x000000ff);
					}
				}
				count = count + 1;
			}
		}
		
		
		reds = red;
		blues = blue;
		greens = green;
		
		height = height * num;
		width = width * num;
		image = resize(image, width, height);
		buildPicture();
	}
	
	public void warholShiftRandom(int num)
	{
		ext = ext + "_WarholRandom" + num;
		BufferedImage processed = new BufferedImage(width*2,height*2,image.getType());
		BufferedImage temp = null;
		warholSupport l = new warholSupport(f);
		temp = l.get1();
		
		short [][] red = new short[width*num][height*num];
		short [][] green = new short[width*num][height*num];
		short [][] blue = new short[width*num][height*num];
		
		short count = 0;
		
		
		for(int row = 0; row < num; row++)
		{
			for(int col = 0; col < num; col++)
			{
				temp = l.get();
				for(int i = 0 + width*(count%num); i < width + width*(count%num); i++)
				{
					for(int j = 0 + height*(count/num); j < height + height*(count/num); j++)
					{
						red[i][j]   = (short) ((temp.getRGB(i - width*(count%num),j - height*(count/num)) & 0x00ff0000) >> 16);
						green[i][j]  = (short) ((temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x0000ff00) >> 8);
						blue[i][j]   = (short) (temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x000000ff);
					}
				}
				count = (short) (count + 1);
			}
		}
		
		
		reds = red;
		blues = blue;
		greens = green;
		
		height = height * num;
		width = width * num;
		image = resize(image, width, height);
		buildPicture();
	}
	
	public void warholTrans(int num)
	{
		ext = ext + "_WarholTrans" + num;
		
		BufferedImage processed = new BufferedImage(width*2,height*2,image.getType());
		BufferedImage temp = null;
		warholSupport l = new warholSupport(f);
		temp = l.get1();
		
		short [][] red = new short[width*num][height*num];
		short[][] green = new short[width*num][height*num];
		short [][] blue = new short[width*num][height*num];
		
		int count = 0;
		int in = 0;
		
		
		for(int row = 0; row < num; row++)
		{
			for(int col = 0; col < num; col++)
			{
				temp = l.get(in);
				for(int i = 0 + width*(count%num); i < width + width*(count%num); i++)
				{
					for(int j = 0 + height*(count/num); j < height + height*(count/num); j++)
					{
						//System.out.println(i + " " + j + " " + width*(count%num) + " " + height*(count/num));
						red[i][j]   = (short) ((temp.getRGB(i - width*(count%num),j - height*(count/num)) & 0x00ff0000) >> 16);
						green[i][j]  = (short) ((temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x0000ff00) >> 8);
						blue[i][j]   = (short) (temp.getRGB(i- width*(count%num),j - height*(count/num)) & 0x000000ff);
					}
				}
				count = count + 1;
				in = (int)((count * 360)/(num*num));
				System.out.println(in);
			}
		}
		
		
		reds = red;
		blues = blue;
		greens = green;
		
		height = height * num;
		width = width * num;
		image = resize(image, width, height);
		buildPicture();
	}
	
	private void buildPicture(short [][] red, short [][] green, short[][] blue)
	{		
		Graphics2D painter = image.createGraphics();
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				try
				{
				painter.setColor(new Color(red[i][j], green[i][j], blue[i][j]));
				painter.fill(new Rectangle(i, j, 1, 1));
				}
				catch (IllegalArgumentException e)
				{
					System.out.println(red[i][j] + " " + green[i][j] + " " + blue[i][j]);
				}
			}
		}
		painter.dispose();
	}
	
	public void setExt(String extN)
	{
		ext = extN;
	}
	
	public BufferedImage drawSquare(int l, int w, int x, int y, Color c, BufferedImage given)
	{
		Graphics2D painter = given.createGraphics();
		painter.setColor(c);
		painter.fill(new Rectangle(w, l, x, y));
	    painter.dispose();
	    return given;
	}
	
	public BufferedImage drawWarhol(int startW, int startH, Color[][] c, BufferedImage given)
	{
		Graphics2D toilet = given.createGraphics();
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				toilet.setColor(c[i - startW][j - startH]);
				toilet.fill(new Rectangle(1, 1, i + startW, j + startH));
			}
			System.out.println(i + " drawWarhol");
		}
	    toilet.dispose();
	    return given;
	}
	
	public String getPixelColor(int x, int y)
	{
		String ret = new String();
		ret =" R: " + reds[x][y] + " G: " + greens[x][y] + " B: " + blues[x][y];
		return ret;
	}
	
	public String getBounds()
	{
		return width + " " + height;
	}
	
	public String getExt()
	{
		return ext;
	}
	
	public void getColors()
	{
		reds = new short[width][height];
		blues = new short[width][height];
		greens = new short[width][height];
		System.out.println(height + ":" + width);
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				reds[i][j]   = (short) ((image.getRGB(i,j) & 0x00ff0000) >> 16);
				greens[i][j] = (short) ((image.getRGB(i,j) & 0x0000ff00) >> 8);
				blues[i][j]  = (short) (image.getRGB(i,j) & 0x000000ff);
			}
		}
	}
	
	public void write(String location)
	{
		File outputfile = new File(location);
	    try 
	    {
			ImageIO.write(image, "png", outputfile);
		} 
	    catch (IOException e) 
	    {
			System.out.println("what is wrong with this program");
			System.out.println("No clue");
		}
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH)
	{ 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
}