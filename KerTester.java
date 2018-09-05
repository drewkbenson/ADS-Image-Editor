import java.util.*;

public class KerTester 
{
	public static void main(String [] args)
	{
		double sigma = 111111111;
		int W = 10;
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
		double total = 0;
	
		for(int i = 0; i < W ; i++)
		{
			for(int j = 0; j < W; j++)
			{
				System.out.print(kernel[i][j] + "\t\t");
				total = total + kernel[i][j];
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(total);
	}
}
