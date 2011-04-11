public class Rectangle {
	private Point p1, p2;
	
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/*using points, I have calculated two sides of a rectangle separately
	 * Returning result is the multiplication of two sides
	 */
	public Double getArea() {
		Double width = Math.abs(p2.x - p1.x);
		Double height = Math.abs(p2.y - p1.y);
		return width * height;
	}
	
	/*The method returns the length of a diagonal in a rectangle 
	 * I have calculated the square of width and height separately
	 * the result will return the square-root of the summation of
	 *  width_square and height_square
	 */
	public Double getDiagonal() {
		Double width_square = Math.pow((p2.x - p1.x), 2);
		Double height_square = Math.pow((p2.y - p1.y), 2);
		return Math.sqrt(width_square + height_square);
	}
}
