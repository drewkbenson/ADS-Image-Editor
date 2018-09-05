import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class imageBlurrer 
{
	
	private int width = 0;
	private int height = 0;
	private BufferedImage image = null;
	
	
	public imageBlurrer(String location)
	{
		imageReader r = new imageReader(location);
		image = imageReader.getImage();
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public void boxBlurShort(int num, short[][] reds, short[][] greens, short[][] blues)
	{
		num = num * 2;
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		short curReds = 0;
		short curBlues = 0;
		short curGreens = 0;
		short curPix = 0;
		long count = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				curPix = 0;
				curReds = 0;
				curBlues = 0;
				curGreens = 0;
				for(int k = i -num/2; k < i + num/2; k++)
				{
					for(int l =  j -num/2; l < j + num/2; l++)
					{
						if(k < 0)
						{
							k = 0;
						}
						
						if(l < 0)
						{
							l = 0;
						}
						
						if(k > width)
						{
							k = i + num/2;
						}
						
						if(l > height)
						{
							l = j + num/2;
						}
						
						count = count + 1;
						if(count % 1000000000 == 0)
						{
							System.out.println(count/1000000000 + "bn");
						}
						if(l < 0 || k < 0)//less than zero
						{
							
						}
						else
						{
							if((l < height && k < width))// ffr 		System.out.println(height + ":" + width);
							{
								curPix = (short) (curPix + 1);
								curReds = (short) (curReds + reds[k][l]);
								curBlues = (short) (curBlues + blues[k][l]);
								curGreens = (short) (curGreens + greens[k][l]);
							}
						}
					}
				}
				if(curPix != 0)
				{
				curReds = (short)(curReds /(curPix));
				curBlues = (short)(curBlues /(curPix));
				curGreens = (short)(curGreens /(curPix));
				newReds[i][j] = curReds;
				newBlues[i][j] = curBlues;
				newGreens[i][j] = curGreens;
				}
				else
				{
					newReds[i][j] = reds[i][j];
					newBlues[i][j] = blues[i][j];
					newGreens[i][j] = greens[i][j];
				}
			}
		}
		reds = newReds;
		blues = newBlues;
		greens = newGreens;
		
		System.out.println(count);
		
		buildPicture(reds, greens, blues);
	}
	
	public void boxBlur(int num, short[][] reds, short[][] greens, short[][] blues)
	{
		num = num * 2;
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		int curReds = 0;
		int curBlues = 0;
		int curGreens = 0;
		int curPix = 0;
		long count = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				curPix = 0;
				curReds = 0;
				curBlues = 0;
				curGreens = 0;
				for(int k = i -num/2; k < i + num/2; k++)
				{
					for(int l =  j -num/2; l < j + num/2; l++)
					{
						if(k < 0)
						{
							k = 0;
						}
						
						if(l < 0)
						{
							l = 0;
						}
						
						if(k > width)
						{
							k = i + num/2;
						}
						
						if(l > height)
						{
							l = j + num/2;
						}
						
						count = count + 1;
						if(count % 1000000000 == 0)
						{
							System.out.println(count/1000000000 + "bn");
						}
						if(l < 0 || k < 0)//less than zero
						{
							
						}
						else
						{
							if((l < height && k < width))// ffr 		System.out.println(height + ":" + width);
							{
								curPix = (curPix + 1);
								curReds = (curReds + reds[k][l]);
								curBlues = (curBlues + blues[k][l]);
								curGreens = (curGreens + greens[k][l]);
							}
						}
					}
				}
				if(curPix != 0)
				{
				curReds = (curReds /(curPix));
				curBlues = (curBlues /(curPix));
				curGreens = (curGreens /(curPix));
				newReds[i][j] = (short) curReds;
				newBlues[i][j] = (short) curBlues;
				newGreens[i][j] = (short) curGreens;
				}
				else
				{
					newReds[i][j] = reds[i][j];
					newBlues[i][j] = blues[i][j];
					newGreens[i][j] = greens[i][j];
				}
			}
		}
		reds = newReds;
		blues = newBlues;
		greens = newGreens;
		
		System.out.println(count);
		
		buildPicture(reds, greens, blues);
	}
	
	public void boxBlurWrong(int num, short[][] reds, short[][] greens, short[][] blues)
	{
		num = (short) (num * 2);
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		short curReds = 0;
		short curBlues = 0;
		short curGreens = 0;
		short curPix = 0;
		long count = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				curPix = 0;
				curReds = 0;
				curBlues = 0;
				curGreens = 0;
				for(int k = i -num/2; k < i + num/2; k++)
				{
					for(int l =  j -num/2; l < j + num/2; l++)
					{
						if(k < 0)
						{
							k = 0;
						}
						
						if(l < 0)
						{
							l = 0;
						}
						
						if(k > width)
						{
							k = i + num/2;
						}
						
						if(l > height)
						{
							l = j + num/2;
						}
						
						count = count + 1;
						if(count % 1000000000 == 0)
						{
							System.out.println(count/1000000000 + "bn");
						}
						if(l < 0 || k < 0)//less than zero
						{
							
						}
						else
						{
							if((l < height && k < width))// ffr 		System.out.println(height + ":" + width);
							{
								curPix = (short) (curPix + 1);
								curReds = (short) (curReds + reds[k][l]);
								curBlues = (short) (curBlues + blues[k][l]);
								curGreens = (short) (curGreens + greens[k][l]);
							}
						}
					}
				}
				if(curPix != 0)
				{
				curReds = (short)(curReds /(curPix));
				curBlues = (short)(curBlues /(curPix));
				curGreens = (short)(curGreens /(curPix));
				newReds[i][j] = curReds;
				newBlues[i][j] = curBlues;
				newGreens[i][j] = curGreens;
				}
				else
				{
					newReds[i][j] = reds[i][j];
					newBlues[i][j] = blues[i][j];
					newGreens[i][j] = greens[i][j];
				}
			}
		}
		reds = newReds;
		blues = newBlues;
		greens = newGreens;
		
		System.out.println(count);
		
		buildPicture(reds, blues, greens);
	}
	
	public void gausBlur(short[][] reds, short[][] greens, short[][] blues, double sigma, int w)
	{
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		double holdReds = 0;
		double holdBlues = 0;
		double holdGreens = 0;
		double curBlur = 0;
		double[][] kernel = new double[w][w];
		int count = 0;
		kernel = getKernel(sigma, w);
		System.out.println(kernel.length + " " + kernel.length);
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				holdReds = 0;
				holdBlues = 0;
				holdGreens = 0;
				curBlur = 0;
				for(int k = i -w/2; k < i + w/2; k++)
				{
					for(int l =  j -w/2; l < j + w/2; l++)
					{
						count = count + 1;
						if(k < 0)
						{
							k = 0;
						}
						
						if(l < 0)
						{
							l = 0;
						}
						
						if(k > width)
						{
							k = i + w/2;
						}
						
						if(l > height)
						{
							l = j + w/2;
						}
						
						if(l < 0 || k < 0)//less than zero
						{
							
						}
						else
						{
							if((l < height && k < width))// ffr 		System.out.println(height + ":" + width);
							{
								curBlur = curBlur + kernel[k - i + w/2][l - j + w/2];
								holdReds = holdReds + reds[k][l]*kernel[k - i + w/2][l - j + w/2];
								holdBlues = holdBlues + blues[k][l]*kernel[k - i + w/2][l - j + w/2];
								holdGreens = holdGreens + greens[k][l]*kernel[k - i + w/2][l - j + w/2];
							}
						}
					}
				}
				newReds[i][j] = (short) (holdReds/curBlur);
				newBlues[i][j] = (short) (holdBlues/curBlur);
				newGreens[i][j] = (short) (holdGreens/curBlur);
			}
		}
		System.out.println(count);
		buildPicture(reds, greens, blues);
	}
	
	public void gausBlurWrong(short[][] reds, short[][] blues, short[][] greens)
	{
		short W = 1;
		short sigma = 1;
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		double holdReds = 0;
		double holdBlues = 0;
		double holdGreens = 0;
		double curBlur = 0;
		double[][] kernel = new double[W][W];
		int count = 0;
		kernel = getKernel(sigma, W);
		System.out.println(kernel.length + " " + kernel.length);
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				holdReds = 0;
				holdBlues = 0;
				holdGreens = 0;
				curBlur = 0;
				for(int k = i -W/2; k < i + W/2; k++)
				{
					for(int l =  j -W/2; l < j + W/2; l++)
					{
						count = (short) (count + 1);
						if(k < 0)
						{
							k = 0;
						}
						
						if(l < 0)
						{
							l = 0;
						}
						
						if(k > width)
						{
							k = i + W/2;
						}
						
						if(l > height)
						{
							l = j + W/2;
						}
						
						if(l < 0 || k < 0)//less than zero
						{
							
						}
						else
						{
							if((l < height && k < width))// ffr 		System.out.println(height + ":" + width);
							{
								curBlur = curBlur + kernel[k - i + W/2][l - j + W/2];
								holdReds = holdReds + reds[k][l]*kernel[k - i + W/2][l - j + W/2];
								holdBlues = holdBlues + blues[k][l]*kernel[k - i + W/2][l - j + W/2];
								holdGreens = holdGreens + greens[k][l]*kernel[k - i + W/2][l - j + W/2];
							}
						}
					}
				}
				newReds[i][j] = (short) (holdReds/curBlur);
				newBlues[i][j] = (short) (holdBlues/curBlur);
				newGreens[i][j] = (short) (holdGreens/curBlur);
			}
		}
		System.out.println(count);
		buildPicture(reds, greens, blues);
	}
	
	public void gausBlur(short [][] reds, short [][] greens, short[][] blues)
	{
		short[][] newBlues = new short[width][height];
		short[][] newReds = new short[width][height];
		short[][] newGreens = new short[width][height];
		short x = 0;
		short y = 0;
		short holdReds = 0;
		short holdBlues = 0;
		short holdGreens = 0;
		short curBlur = 0;
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				x = (short)i;
				y = (short) (j - 3);
				holdReds = 0;
				holdBlues = 0;
				holdGreens = 0;
				curBlur = 0;
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = 5;
					holdReds = (short) (reds[x][y] * 5);
					holdBlues = (short) (blues[x][y] * 5);
					holdGreens = (short) (greens[x][y] * 5);
							
				}
				
				x = (short) (i - 2);
				y = (short) (j - 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
							
				}
				
				x = (short) (i - 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
							
				}
				
				x = (short) i;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 32);
					holdReds = (short) (holdReds + reds[x][y] * 32);
					holdBlues = (short) (holdBlues + blues[x][y] * 32);
					holdGreens = (short) (holdGreens + greens[x][y] * 32);
							
				}
				
				x = (short) (i + 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
					
				
				x = (short) (i + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
							
				}
				
				x = (short) (i - 2);
				y = (short) (j - 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) (i - 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 64);
					holdReds = (short) (holdReds + reds[x][y] * 64);
					holdBlues = (short) (holdBlues + blues[x][y] * 64);
					holdGreens = (short) (holdGreens + greens[x][y] * 64);
				}
				
				x = (short) i;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 100);
					holdReds = (short) (holdReds + reds[x][y] * 100);
					holdBlues = (short) (holdBlues + blues[x][y] * 100);
					holdGreens = (short) (holdGreens + greens[x][y] * 100);
				}
				
				x = (short) (i + 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 64);
					holdReds = (short) (holdReds + reds[x][y] * 64);
					holdBlues = (short) (holdBlues + blues[x][y] * 64);
					holdGreens = (short) (holdGreens + greens[x][y] * 64);
				}
				
				x = (short) (i + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) (i - 3);
				y = (short) j;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
				}
				
				x = (short) (i - 2);
				y = (short) j;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 32);
					holdReds = (short) (holdReds + reds[x][y] * 32);
					holdBlues = (short) (holdBlues + blues[x][y] * 32);
					holdGreens = (short) (holdGreens + greens[x][y] * 32);
				}
				
				for(int l = 0; l < 3; l++)
				{
					x = (short) (i - 1);
					if(!(x < 0 || y < 0) && (x < width && y < height))
					{
						curBlur = (short) (curBlur + 32);
						holdReds = (short) (holdReds + reds[x][y] * 32);
						holdBlues = (short) (holdBlues + blues[x][y] * 32);
						holdGreens = (short) (holdGreens + greens[x][y] * 32);
					}
				}
				
				x = (short) (i + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 32);
					holdReds = (short) (holdReds + reds[x][y] * 32);
					holdBlues = (short) (holdBlues + blues[x][y] * 32);
					holdGreens = (short) (holdGreens + greens[x][y] * 32);
				}
				
				x = (short) (i + 3);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
				}
				
				x = (short) (i - 2);
				y = (short) (j + 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) (i - 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 64);
					holdReds = (short) (holdReds + reds[x][y] * 64);
					holdBlues = (short) (holdBlues + blues[x][y] * 64);
					holdGreens = (short) (holdGreens + greens[x][y] * 64);
				}
				
				x = (short) i;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 100);
					holdReds = (short) (holdReds + reds[x][y] * 100);
					holdBlues = (short) (holdBlues + blues[x][y] * 100);
					holdGreens = (short) (holdGreens + greens[x][y] * 100);
				}
				
				x = (short) (i + 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 64);
					holdReds = (short) (holdReds + reds[x][y] * 64);
					holdBlues = (short) (holdBlues + blues[x][y] * 64);
					holdGreens = (short) (holdGreens + greens[x][y] * 64);
				}
				
				x = (short) (i + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) (i - 2);
				y = (short) (j + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
				}
				
				x = (short) (i - 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) i;
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 32);
					holdReds = (short) (holdReds + reds[x][y] * 32);
					holdBlues = (short) (holdBlues + blues[x][y] * 32);
					holdGreens = (short) (holdGreens + greens[x][y] * 32);
				}
				
				x = (short) (i + 1);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 18);
					holdReds = (short) (holdReds + reds[x][y] * 18);
					holdBlues = (short) (holdBlues + blues[x][y] * 18);
					holdGreens = (short) (holdGreens + greens[x][y] * 18);
				}
				
				x = (short) (i + 2);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
				}
				
				x = 0;
				y = (short) (j + 3);
				
				if(!(x < 0 || y < 0) && (x < width && y < height))
				{
					try
					{
					curBlur = (short) (curBlur + 5);
					holdReds = (short) (holdReds + reds[x][y] * 5);
					holdBlues = (short) (holdBlues + blues[x][y] * 5);
					holdGreens = (short) (holdGreens + greens[x][y] * 5);
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println(x + "  " + y);
					}
				}
				
				newReds[i][j] = (short) (holdReds/curBlur);
				newBlues[i][j] = (short) (holdBlues/curBlur);
				newGreens[i][j] = (short) (holdGreens/curBlur);
			}
		}
		reds = newReds;
		blues = newBlues;
		greens = newGreens;
		buildPicture(reds, greens, blues);
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	private double[][] getKernel(double sigma, int W)
	{
		//double sigma = 111111111;
		//int W = 10;
		double[][] kernel = new double[W][W];
		double mean = W/2;
		double sum = 0.0; // For accumulating the kernel values
		for (int x = 0; x < W; ++x) 
		{
		    for (int y = 0; y < W; ++y) 
		    {// exp = e^double
		        kernel[x][y] = Math.exp( -0.5 * (Math.pow((x-mean)/sigma, 2.0) + Math.pow((y-mean)/sigma,2.0)) )
		                         / (2 * Math.PI * sigma * sigma);

		        // Accumulate the kernel values
		        sum += kernel[x][y];
		    }
		}

		// Normalize the kernel
		for (int x = 0; x < W; ++x) 
		{
		    for (int y = 0; y < W; ++y)
		    {
		        kernel[x][y] /= sum;
		    }
		}
		return kernel;
	}
	
	private void buildPicture(short[][] reds, short[][] greens, short[][] blues)
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
}
