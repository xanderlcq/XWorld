/**
 * This class is for the location object for the world.
 * @author Xander Li
 *
 */
public class Location {
	
	protected int x;
	protected int y;
	/**
	 * Create a location object.
	 * @param x X coordinate of the location.
	 * @param y	Y coordinate of the location.
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Get the X coordinate of the location.
	 * @return Return the X coordinate of the location.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Set the X coordinate of the location.
	 * @param x The new X coordinate of the location.
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Get the Y coordinate of the location.
	 * @return Return the Y coordinate.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Set the Y coordinate of the location.
	 * @param y The new Y coordinate of the location.
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

}