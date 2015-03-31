import java.awt.Color;

public interface Life {
	/**
	 * Set the 'alive' to false.
	 */
	public void die();
	/**
	 * Get the location of the creature.
	 * @return Return the location of the creature.
	 */
	public Location getLocation();
	/**
	 * Set the location of the creature.
	 * @param location The new location of the creature.
	 */
	public void setLocation(Location location);
	/**
	 * Get the age of the creature
	 * @return Return the age of the creature.
	 */
	public int getAge();
	/**
	 * Set the age of the creature.
	 * @param age The new age of the creature.
	 */
	public void setAge(int age);
	/**
	 * Set the color of the creature.
	 * @param c The new color of the creature (Color.color).
	 */
	public void setColor(Color c);
	/**
	 * Get the color of the creature.
	 * @return Return the color of the creature.
	 */
	public Color getColor();
	/**
	 * Go up 1 cell.
	 */
	public void goUp();
	/**
	 * Go down 1 cell.
	 */
	public void goDown();
	/**
	 * Go right 1 cell.
	 */
	public void goRight();
	/**
	 * Go left 1 cell.
	 */
	public void goLeft();
	/**
	 * Check if the creature is alive or not.
	 * @return Return true if it's alive, false if it's not.
	 */
	public boolean isAlive();
	/**
	 * A method to reproduce.
	 * @param myworld The world the creature is in.
	 */
	public void reproduce(GridWorld myworld);
	/**
	 * A set of rules that creature execute each cycle.
	 * @param myWorld
	 */
	public void excecuteRules(GridWorld myWorld);
}
