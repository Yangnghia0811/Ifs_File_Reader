package ifs;

/**
 * The purpose of this class is taking all the MapleIfs information and output
 * by get method
 * 
 * @author Nghia Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class MapleIfs extends AffineTransform {
	double[][] affine = { { 0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10 }, { 0.50, -0.45, 0.52, 0.43, 0.75, -1.49, 0.35 },
			{ 0.47, 0.47, -0.49, 0.45, 0.74, 1.62, 0.35 }, { 0.51, 0.00, 0.00, 0.49, -1.62, -0.02, 0.20 } };
	double scale = 100;
	int height = 702;
	int width = 885;
	int xOffset = 340;
	int yOffset = 445;

	/**
	 * getName method that Overrides getName method in class ifs.AffineTransform
	 * 
	 * @return the name of the MapleIfs fractal
	 */
	public String getName() {
		return "MapleIfs";
	}

	/**
	 * getAffine method that Overrides getAffine method in class ifs.AffineTransform
	 * 
	 * @return 2D array of Affine Transform of the MapleIfs fractal
	 */
	public double[][] getAffine() {
		return affine;
	}

	/**
	 * getScale method that Overrides getScale method in class ifs.AffineTransform
	 * 
	 * @return the value scale of the MapleIfs fractal
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * getHeight method that Overrides getHeight method in class ifs.AffineTransform
	 * 
	 * @return the value height of the MapleIfs fractal
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * getWidth method that Overrides getWidth method in class ifs.AffineTransform
	 * 
	 * @return the width of the MapleIfs fractal
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getXOffset method that Overrides getXOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the xOffset of the MapleIfs fractal
	 */
	public int getXOffset() {
		return xOffset;
	}

	/**
	 * getYOffset method that overrides getYOffset method in MapleIfs class
	 * ifs.AffineTransform
	 * 
	 * @return the yOffset of the fractal
	 */
	public int getYOffset() {
		return yOffset;
	}
}
