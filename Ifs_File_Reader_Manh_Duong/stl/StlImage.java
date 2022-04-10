package stl;

import ifs.IfsCreator;

/**
 * The purpose of StlImage Class is to create a lithophane from a 2D array of
 * integers
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class StlImage {
	private double minThick; // the required minimum thickness of the lithophane
	private double thickScale; // the required difference between the thickest and thinnest part of the
								// lithophane
	private double scale = 0.1; // the required scale of the integer array length and width to lithophane length
								// and width (hardcoded to 0.1)
	private double maxValue; // the determined (in createSolid method) maximum value of the integer array
	private int num;

	/**
	 * initial constructor with the desired minimum and maximum thicknesses of the
	 * generated lithophane
	 * 
	 * @param min the minimum thickness of lithophane
	 * @param max the the maximum thickness of lithophane
	 */
	public StlImage(double min, double max) {
		this.minThick = min;
		this.thickScale = max - min;
	}

	/**
	 * create a Solid from a 2D array of integers
	 * 
	 * @param matrix takes the 2D matrix array from generated lithophane
	 * @return the solid
	 * @throws Exception if 'matrix' doesn't contain elements
	 */
	public Solid createSolid(int[][] matrix) throws Exception {
		/** instance affineName with purposes of calling method from IfsCreator */
		IfsCreator affineName = new IfsCreator();
		/** instance solid that helps to add facet */
		Solid solid = new Solid(affineName.getTransformList().get(num).getName());
		int length = matrix[0].length;
		int width = matrix.length;
		// Check and store maximum value
		for (int j = 0; j < matrix.length; j++) {
			for (int k = 0; k < matrix[j].length; k++) {
				int value = matrix[j][k];
				if (value > this.maxValue) {
					this.maxValue = value;
				}
			}
		}
		for (int x = 0; x < (matrix.length - 1); x++) {
			for (int y = 0; y < (matrix[x].length - 1); y++) {
				createIfsVertex(x, y, matrix[x][y]);
				createIfsVertex(x + 1, y, matrix[x + 1][y]);
				createIfsVertex(x + 1, y + 1, matrix[x + 1][y + 1]);
				createIfsVertex(x, y + 1, matrix[x][y + 1]);
				solid.addFacet(createIfsVertex(x, y, matrix[x][y]), createIfsVertex(x + 1, y, matrix[x + 1][y]),
						createIfsVertex(x + 1, y + 1, matrix[x + 1][y + 1]),
						createIfsVertex(x, y + 1, matrix[x][y + 1]));
			}
		}
		// side 1 creates 4 vertex
		Vertex vs1a = new Vertex(0, 0, 0);
		Vertex vs1b = new Vertex(width * scale, 0, 0);
		Vertex vs1c = new Vertex(width * scale, 0, minThick);
		Vertex vs1d = new Vertex(0, 0, minThick);
		solid.addFacet(vs1a, vs1b, vs1c, vs1d);
		// side 2 creates 4 vertex
		Vertex vs2a = new Vertex(0, length * scale, 0);
		Vertex vs2b = new Vertex(0, 0, 0);
		Vertex vs2c = new Vertex(0, 0, minThick);
		Vertex vs2d = new Vertex(0, length * scale, minThick);
		solid.addFacet(vs2a, vs2b, vs2c, vs2d);
		// side 3 creates 4 vertex
		Vertex vs3a = new Vertex(width * scale, 0, 0);
		Vertex vs3b = new Vertex(width * scale, length * scale, 0);
		Vertex vs3c = new Vertex(width * scale, length * scale, minThick);
		Vertex vs3d = new Vertex(width * scale, 0, minThick);
		solid.addFacet(vs3a, vs3b, vs3c, vs3d);
		// side 4 creates 4 vertex
		Vertex vs4a = new Vertex(width * scale, length * scale, 0);
		Vertex vs4b = new Vertex(0, length * scale, 0);
		Vertex vs4c = new Vertex(0, length * scale, minThick);
		Vertex vs4d = new Vertex(width * scale, length * scale, minThick);
		solid.addFacet(vs4a, vs4b, vs4c, vs4d);
		// bottom creates 4 vertex
		Vertex vs5a = new Vertex(0, 0, 0);
		Vertex vs5b = new Vertex(0, length * scale, 0);
		Vertex vs5c = new Vertex(width * scale, length * scale, 0);
		Vertex vs5d = new Vertex(width * scale, 0, 0);
		solid.addFacet(vs5a, vs5b, vs5c, vs5d);
		return solid;
	}

	private Vertex createIfsVertex(double x, double y, double z) {
		double thickness = 0;
		// calculate the thickness based on the following formula
		thickness = this.minThick + this.thickScale * Math.sqrt(z / maxValue);
		Vertex v21 = new Vertex(x * scale, y * scale, thickness);
		return v21;
	}

	/**
	 * setNumOfAffineChose method helps to get the number of the fractal image
	 * chosen
	 * 
	 * @param num gets the number of fractal image chosen
	 */
	public void setNumOfAffineChose(int num) {
		this.num = num;
	}
}