package ifs;

/**
 * The parent of all the affine transforms. It defines what all transforms must contain
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class AffineTransform {
	/**
	 * The name of the resulting ifs image
	 * 
	 * @return the subclass's getName method will override the value null
	 */
	public String getName() {
		return "";
	}

	/**
	 * The resulting ifs image
	 * 
	 * @return the subclass's getAffine method will override the value [0][0]
	 */
	public double[][] getAffine() {
		return new double[0][0];
	}

	/**
	 * The scale of the resulting image
	 * 
	 * @return the subclass's getScale method will override the value 0
	 */
	public double getScale() {
		return 0;
	}

	/**
	 * The height of the resulting image
	 * 
	 * @return the subclass's getHeight method will override the value 0
	 */
	public int getHeight() {
		return 0;
	}

	/**
	 * The width of the resulting imag
	 * 
	 * @return the subclass's getWidth method will override the value 0
	 */
	public int getWidth() {
		return 0;
	}

	/**
	 * The x offset of the resulting imag
	 * 
	 * @return the subclass's getXOffset method will override the value 0
	 */
	public int getXOffset() {
		return 0;
	}

	/**
	 * The y offset of the resulting imag
	 * 
	 * @return the subclass's getYOffset method will override the value 0
	 */
	public int getYOffset() {
		return 0;
	}
}
