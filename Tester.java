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

public class Tester 
{
	
	public static void main(String [] args) throws IOException
	{
		System.out.println("Atleast 2500 lines of code as of 9/18/2017");
		//String isIt = new String("city");
		//int firstNum = 4;
		//int secondNum = 1;
		//for(int i = 10; i < 20; i++)
			
		String ext = new String();
		String base = new String();
		base = "HotlineMiamiRL";
		imageEditor r = new imageEditor("C:\\Java Images\\MTG\\treasure_cruise.jpg");
		//r.write("C:\\Java Images\\" + base + "\\" + base + ext + ".png");
		
		
		int iHUE = 100;
		int hueShift = 100;
		int hueShiftStart = 25;
		int hueShiftStop = 111;
		
		//for(int i = 0; i < 10; i++)
		{
			
			r.removeRed();
			r.removeGreen();
			r.heatMapBlue();
			
			
			//r.transHueSection(97, 262, 360);
			//r.transHueSection(97, 0, 23);
			//r.warholTrans(3);
			//r.transHue(300);
		}	
		
		//for(int i = 0; i < 10; i++)
		{
			//r.randomImage(3);
			
			ext = r.getExt();
			r.write("C:\\Java Images\\MTG\\treasure_cruise" + ext + ".png");
			r.refresh();
		}
		
		
		
		
		
			/*
		  	ext = r.getExt();
			r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\MrK Folder\\Dump\\MrK" + ext + ".png");
			r.refresh();
			System.out.println("bar");
		
			hueShift = hueShift + 1;
			
			
			
			r.warholShift(3);
			ext = r.getExt();
			r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\MrK Folder\\Dump\\MrK" + ext + ".png");
			r.refresh();
			
			r.warholTrans(2);
			ext = r.getExt();
			r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\MrK Folder\\Dump\\MrK" + ext + ".png");
			r.refresh();
			
			r.warholTrans(3);
			ext = r.getExt();
			r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\MrK Folder\\Dump\\MrK" + ext + ".png");
			r.refresh();
			*/
		
		//r.switchBlueGreen();
		//r.negative();
		//r.randomFill();
		//r.boxBlur(1);
		//r.switchColors(firstNum, secondNum);
		//r.switchColors(firstNum, secondNum);
		//r.switchGreenRed();
		//r.switchBlueGreen();
		//r.switchRedBlue();
		//r.boxBlur(40);
		//r.switchGreenRed();
		//r.switchGreenRed();
		//r.jpegify(4);
		//r.switchRedBlue();
		//r.removeRed();
		//r.removeGreen();
		//r.removeBlue();
		//r.gausBlur(30, 5);
		//r.heatMapRed();
		//r.heatMapGreen();
		//r.heatMapBlue();
		//r.transHue(hueShift);
		//r.transHueSection(hueShift, hueShiftStart, hueShiftStop);
		//r.negative();
		
		
		/*
		for(double i = .1; i < 1; i = i + .1)
		{
			r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_gausBlur.png", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\3840x2160_image3.jpg", i);
			r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\regToGaus\\3840x2160_image3_gausBlur" + i + ".png");
		}*/
			
		
		
		/*
		r.switchBlueGreen();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_SwitchBlueGreen.png");
		r.refresh();
		
		r.switchRedBlue();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_SwitchRedBlue.png");
		r.refresh();
		
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_SwitchBlueGreen.png", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_SwitchRedBlue.png");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_SwitchBGRBCombined.png");
		
		*/
		
		
		/*r.refresh();
		r.removeBlue();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_noBlue.png");
		
		r.refresh();
		r.removeRed();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_noRed.png");
		
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_noRed.png", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_noBlue.png");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\Dubai Pictures\\PNGS\\3840x2160_image3_noRedNoBlueCombined.png");*/
		
		
		
		
		
		
		/*r.setImage1("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\3840x2160_image3.jpg");
		r.setImage2("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\3840x2160_image4.jpg");
		r.combine();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4k_hold_2.jpg");
		r.setImage1("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4k_hold_1.jpg");
		r.setImage2("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4k_hold_2.jpg");
		r.combine();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4k_4_combined.jpg");
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*//r.jpegify(6);
		//r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\windows_xp_wallpaper_massive_jpegified1.jpg");
		String write1 = new String("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\windows_xp_wallpaper\\massive_jpegifieda");
		String write2 = new String(".jpg");
		for(int i = 0; i < 10; i++)
		{
			write1 = write1.substring(0,write1.length()-1);
			
			r.jpegify(i);
			write1 = write1 + i;
			r.write(write1 + write2);
			System.out.println(write1 + write2);
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image1.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image2.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold1.jpg");
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image3.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image4.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold2.jpg");
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold2.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold1.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4_combo_image1.jpg");
		
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image5.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image6.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold3.jpg");
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image7.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\1920x1080_image8.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold4.jpg");
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold3.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\hold4.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4_combo_image2.jpg");
		
		r.combineImages("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4_combo_image1.jpg", "F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\4_combo_image2.jpg");
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\8_combo_image1.jpg"); 
		r.negative();
		//r.jpegify();
		r.write("F:\\Eclipse Projects\\workspace\\ADS Image Editor\\src\\8_combo_image_negative.jpg");
		*/
	}
}



