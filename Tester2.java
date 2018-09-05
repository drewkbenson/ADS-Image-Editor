import java.io.IOException;

//jpegify
//negative
//combineImages
//darken
//darkenFactor
//brighten
//randomFill

//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\walrus.jpg
//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Trump_compression_small.jpg
//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image8.jpg
//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\3840x2160_image3.jpg
//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\windows_xp_wallpaper.jpg
//F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\BW Lines.png
//F:\\Photoshop\\Init images\\Explosion'.jpg


public class Tester2 
{

	public static void main(String [] args)
	{
		String ext = new String();
		imageEditor r = new imageEditor("C:\\Java Images\\From F\\3840x2160_image3.jpg");
		
		 
		
			r.transHue(138);
		
		//catch (IOException e) 
		{
			
		}
		
		ext = r.getExt();
		r.write("C:\\Java Images\\From F\\3840x2160_image3" + ext + ".png");
	}
}
