import ifs.IfsCreator;
import ifs.AffineTransform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import stl.StlImage;
import stl.Solid;

/**
 * contains main method that helps to create a menu of available fractals
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class IfsStlFile {
	/**
	 * The main of the entire program
	 * @param args unused
	 * @throws Exception catch all type of errors
	 */
	public static void main(String[] args) throws Exception  {
		/** create a scanner called input*/
		Scanner input = new Scanner(System.in);
		// Get the array of affine transform objects from IfsCreator class
		ArrayList<AffineTransform> AffineArray = new ArrayList<AffineTransform>();
		IfsCreator getArray = new IfsCreator();
		AffineArray.addAll(getArray.getTransformList());
		// Create the menu
		System.out.print("Available fractal images are: \n");
		for (int i = 0; i < getArray.getTransformList().size(); i++) {
			System.out.print((i + 1) + "\t" + AffineArray.get(i).getName() + "\n");
		}
		System.out.print("What image number do you want? ");
		int i = input.nextInt();
		do {
			if (i < 0 || i > AffineArray.size()) {
				System.out.print("Please select value from " + 1 + " to" + AffineArray.size());
				i = input.nextInt();
			}
		} while (i < 0 || i > AffineArray.size());
		// a 2D array that stores all the values from generateIfs method 
		int[][] twoDArray = getArray.generateIfs(AffineArray.get(i-1));
		StlImage stlimage = new StlImage(0.8, 4);
		stlimage.setNumOfAffineChose(i-1);
		// Create an instance type Solid and passes the 2D array in to create solid.
		Solid solid = stlimage.createSolid(twoDArray);
		// Create PrintWriter for a file with the name of transform into the "results" folder
		// directory based on user's input
			String file = new File("").getAbsolutePath();
			PrintWriter printwriter = new PrintWriter(new FileWriter(file + "\\Ifs_File_Reader_Manh_Duong\\results\\" + AffineArray.get(i-1).getName() + ".stl"));
			solid.print(printwriter);
			System.out.print("Done, check results folder");	
		}
	}
