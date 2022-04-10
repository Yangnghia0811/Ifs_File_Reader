package ifs;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The purpose of IfsCreator Class is to create an IFS image given an affine
 * transfo
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.8.0_211
 */
public class IfsCreator {
	int A = 0; // the constant value of the A column index (i.e. 0)
	int B = 1; // the constant value of the B column index (i.e. 1)
	int C = 2; // the constant value of the C column index (i.e. 2)
	int D = 3; // the constant value of the D column index (i.e. 3)
	int E = 4; // the constant value of the E column index (i.e. 4)
	int F = 5; // the constant value of the F column index (i.e. 5)
	int PROB = 6; // the constant value of the PROB column index (i.e. 6)
	double u = 0, v = 0, x = 0, y = 0;
	int xDisp, yDisp = 0;

	/**
	 * The purpose of getTransformList method is to store affine transform into an
	 * arraylist
	 * 
	 * @return the list of affine transform
	 * @throws FileNotFoundException if doesn't find any files
	 */
	public ArrayList<AffineTransform> getTransformList() throws FileNotFoundException {
		ArrayList<AffineTransform> AffineList = new ArrayList<AffineTransform>();
		AffineList.add(new BarnsleyFernIfs());
		AffineList.add(new SierpinskiIfs());
		AffineList.add(new MapleIfs());
		AffineList.add(new FileIfs("GoldenDragon.ifs")); //this can be changed to other ifs files
		return AffineList;
	}

	/**
	 * The purpose of generateIfs method is to generate an ifs image based on the
	 * given an AffineTransform
	 * 
	 * @param affineIfs get the AffineIfs to generate ifs image
	 * @return the 2D array generated from the affineIfs's values
	 */
	public int[][] generateIfs(AffineTransform affineIfs) {
		int looplength = affineIfs.getWidth() * affineIfs.getHeight();
		// original array matrix
		double[][] matrix = affineIfs.getAffine();
		// second array so we can plug the numbers in row in to keep track
		double[] matrix2 = new double[6];
		int[][] twoDA = new int[affineIfs.getWidth()][affineIfs.getHeight()];
		for (int i = 0; i < looplength; i++) {
			double a = Math.random();
			double min = 0, max = 0;
			for (int in = 0; in < matrix.length; in++) {
				min = max;
				max = min + matrix[in][PROB];
				if (a >= min && a < max) {
					matrix2 = matrix[in];
					break;
				}
			}
			u = matrix2[A] * x + matrix2[B] * y + matrix2[E];
			v = matrix2[C] * x + matrix2[D] * y + matrix2[F];
			x = u;
			y = v;
			xDisp = (int) (x * affineIfs.getScale() + affineIfs.getXOffset());
			yDisp = (int) (y * affineIfs.getScale() + affineIfs.getYOffset());
			twoDA[yDisp][xDisp]++;
		}
		return twoDA;
	}

}
