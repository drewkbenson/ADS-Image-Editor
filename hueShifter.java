import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import static java.lang.System.out;

/**
*I did not write this code, credit to the authors at abdulfatir.com
*http://tech.abdulfatir.com/2014/05/changing-hue-of-image.html
*/


public class hueShifter
{
 public static void main(String args[])throws IOException
 {
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
 int iHUE=0;
 do
 {
  out.print("Hue (0-360):");
  iHUE = Integer.parseInt(reader.readLine());
  if(iHUE > 360 || iHUE < 0)
   {
   out.println("Please enter a hue value between 0-360.");
   }
 }
 while((iHUE > 360 || iHUE < 0));
 System.out.println(iHUE);
 float hue = iHUE/360f;
 System.out.println(hue);
 BufferedImage raw,processed;
 raw = ImageIO.read(new File("C:\\Users\\Drew\\eclipse-workspace\\ADS Image Editor\\src\\3840x2160_image3.jpg"));
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
 ImageIO.write(processed,"PNG",new File("C:\\Users\\Drew\\eclipse-workspace\\ADS Image Editor\\src\\3840x2160_image3_ShiftedTo" + iHUE + ".jpg"));
 }
}
