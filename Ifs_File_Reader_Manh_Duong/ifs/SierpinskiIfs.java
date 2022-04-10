package ifs;

/**
 * The purpose of this class is taking all the SierpinskiIfs information and
 * output by get method
 * 
 * @author Nghia Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class SierpinskiIfs extends AffineTransform {
	double[][] affine = { { 0.50, 0.00, 0.00, 0.50, 0.00, 0.00, 0.33 }, { 0.50, 0.00, 0.00, 0.50, 0.00, -0.50, 0.33 },
			{ 0.50, 0.00, 0.00, 0.50, -0.43, -0.25, 0.33 } };
	double scale = 500;
	int height = 449;
	int width = 519;
	int xOffset = 439;
	int yOffset = 509;

	/**
	 * getName method that Overrides getName method in class ifs.AffineTransform
	 * 
	 * @return the name of the SierpinskiIfs fractal
	 */
	public String getName() {
		return "SierpinskiIfs";
	}

	/**
	 * getAffine method that Overrides getAffine method in class ifs.AffineTransform
	 * 
	 * @return 2D array of Affine Transform of the SierpinskiIfs fractal
	 */
	public double[][] getAffine() {
		return affine;
	}

	/**
	 * getScale method that Overrides getScale method in class ifs.AffineTransform
	 * 
	 * @return the value scale of the SierpinskiIfs fractal
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * getHeight method that Overrides getHeight method in class ifs.AffineTransform
	 * 
	 * @return the value height of the SierpinskiIfs fractal
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * getWidth method that Overrides getWidth method in class ifs.AffineTransform
	 * 
	 * @return the width of the SierpinskiIfs fractal
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getXOffset method that Overrides getXOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the xOffset of the SierpinskiIfs fractal
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
