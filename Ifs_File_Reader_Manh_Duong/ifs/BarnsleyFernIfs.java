package ifs;

/**
 * The purpose of this class is taking all the BarnsleyFernIfs information and
 * output by get method
 * 
 * @author Nghia Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class BarnsleyFernIfs extends AffineTransform {
	double[][] affine = { { 0.00, 0.00, 0.00, 0.16, 0.00, 0.00, 0.01 }, { 0.85, 0.04, -0.04, 0.85, 0.00, 1.60, 0.85 },
			{ 0.20, -0.26, 0.23, 0.22, 0.00, 1.60, 0.07 }, { -0.15, 0.28, 0.26, 0.24, 0.00, 0.44, 0.07 } };
	double scale = 100;
	int height = 503;
	int width = 1019;
	int xOffset = 228;
	int yOffset = 10;

	/**
	 * getName method that Overrides getName method in class ifs.AffineTransform
	 * 
	 * @return the name of the BarnsleyFernIfs fractal
	 */
	public String getName() {
		return "BarnsleyFernIfs";
	}

	/**
	 * getAffine method that Overrides getAffine method in class ifs.AffineTransform
	 * 
	 * @return 2D array of Affine Transform of the BarnsleyFernIfs
	 *         fractal
	 */
	public double[][] getAffine() {
		return affine;
	}

	/**
	 * getScale method that Overrides getScale method in class ifs.AffineTransform
	 * 
	 * @return the value scale of the BarnsleyFernIfs fractal
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * getHeight method that Overrides getHeight method in class ifs.AffineTransform
	 * 
	 * @return the value height of the BarnsleyFernIfs fractal
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * getWidth method that Overrides getWidth method in class ifs.AffineTransform
	 * 
	 * @return the width of the BarnsleyFernIfs fractal
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getXOffset method that Overrides getXOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the xOffset of the BarnsleyFernIfs fractal
	 */
	public int getXOffset() {
		return xOffset;
	}

	/**
	 * getYOffset method that overrides getYOffset method in class
	 * ifs.AffineTransform
	 * 
	 * @return the yOffset of the BarnsleyFernIfs fractal
	 */
	public int getYOffset() {
		return yOffset;
	}
}
