import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.*;

public class warholSupport 
{
	
	private BufferedImage image = null;
	private String f = null;
	private int width = 0;
	private int height = 0;
	//private int[][] colors = null;
	private int[][] blues = null;
	private int[][] reds = null;
	private int[][] greens = null;
	private String ext = null;
	private imageEditor r =  null;

	public warholSupport(String location)
	{
		f = location;
		r = new imageEditor(location);
	}
	
	public BufferedImage getTemp(int cur, int total)
	{
		int curT = cur*360/total;
		
		r.refresh();
		try 
		{
			r.shiftHue(curT);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get1()
	{
		r.refresh();
		try 
		{
			r.shiftHue(0);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get2()
	{
		r.refresh();
		try 
		{
			r.shiftHue(90);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get3()
	{
		r.refresh();
		try 
		{
			r.shiftHue(180);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get4()
	{
		r.refresh();
		try 
		{
			r.shiftHue(270);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get()
	{
		int hue = (int)(Math.random()*360);
		r.refresh();
		try 
		{
			r.shiftHue(hue);
		} 
		catch (IOException e) 
		{
			
		}
		return r.getImage();
	}
	
	public BufferedImage get(int hue)
	{
		r.refresh();
		r.transHue(hue);
		return r.getImage();
	}
}
