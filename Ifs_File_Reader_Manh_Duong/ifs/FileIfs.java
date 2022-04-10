package ifs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The purpose of this class is taking all the Affine Transform information from
 * Ifs file and output by get method
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class FileIfs extends AffineTransform {
	double[][] affine;
	String name, str = "";
	int height, width, xOffset, yOffset, numRow;
	double scale;

	/**
	 * parameter constructor that takes the file link and read the file and retrieve
	 * information
	 * 
	 * @param fileName takes the direction to the Ifs file and uses scanner to read
	 *                 over the file
	 * @throws FileNotFoundException if 'fileName' doesn't find any files
	 */
	public FileIfs(String fileName) throws FileNotFoundException {
		//get path to goldendragon.ifs file
		String filePath = new File("").getAbsolutePath();
		// scanner
		try (Scanner reader = new Scanner(new FileReader(filePath + "\\Ifs_File_Reader_Manh_Duong\\ifs\\" + fileName))) {
			while (reader.hasNextLine()) {
				str += reader.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.print("No such file " + e.getMessage());
		}

		// this instance helps to split all the contents into tokens and store it in the
		// a 1D array of Strings
		String[] strSplit = str.split(" |\t|\n|\r|\f");

		for (int i = 0; i < strSplit.length; i++) {
			if (strSplit[i].contentEquals("name")) {
				name = strSplit[i + 1] + " " + strSplit[i + 2];
			} else if (strSplit[i].contentEquals("scale")) {
				scale = Double.parseDouble(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("height")) {
				height = Integer.parseInt(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("height")) {
				height = Integer.parseInt(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("width")) {
				width = Integer.parseInt(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("xOffset")) {
				xOffset = Integer.parseInt(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("yOffset")) {
				yOffset = Integer.parseInt(strSplit[i + 1]);
			} else if (strSplit[i].contentEquals("affine")) {
				numRow = Integer.parseInt(strSplit[i + 1]);
			}
		}

		ArrayList<String> affineList = new ArrayList<>();
		for (int i = 2; i < 22; i++) {
			if (!strSplit[i].isEmpty()) {
				affineList.add(strSplit[i]);
			}
		}

		affine = new double[numRow][7];
		for (int j = 1; j <= numRow; j++) {
			for (int k = 0; k < 7; k++) {
				affine[j - 1][k] = Double.parseDouble(affineList.remove(0));
			}
		}
	}

	/**
	 * getName method that Overrides getName method in class ifs.AffineTransform
	 * 
	 * @return the value name of the fractal
	 */
	public String getName() {
		return name;
	}

	/**
	 * getAffine method that Overrides getAffine method in class ifs.AffineTransform
	 * 
	 * @return 2D array of Affine Transform of the fractal
	 */
	public double[][] getAffine() {
		return affine;
	}

	/**
	 * getScale method that Overrides getScale method in class ifs.AffineTransform
	 * 
	 * @return the value scale of the fractal
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * getHeight method that Overrides getHeight method in class ifs.AffineTransform
	 * 
	 * @return the value height of the fractal
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * getWidth method that Overrides getWidth method in class ifs.AffineTransform
	 * 
	 * @return the width of the fractal
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getXOffset method that Overrides getXOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the xOffset of the fractal
	 */
	public int getXOffset() {
		return xOffset;
	}

	/**
	 * getYOffset method that overrides getYOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the yOffset of the fractal
	 */
	public int getYOffset() {
		return yOffset;
	}
}
