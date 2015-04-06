import java.util.ArrayList;
import java.util.List;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GRect;

/**
 * GridWorld is a class for world of creatures.
 * 
 * @author Xander Li
 * 
 */
public class GridWorld {
	private int cellSize;
	protected List<LifeForm> myCreatures;
	protected List<LifeForm> tempCreatures;
	protected int worldSize;

	/**
	 * Create a new grid world with specific world size and cell size
	 * 
	 * @param worldSize
	 *            The size of the world.
	 * @param cellSize
	 *            The size (in pixel of each cell in the world.
	 */
	public GridWorld(int worldSize, int cellSize) {
		this.worldSize = worldSize;
		this.cellSize = cellSize;
		myCreatures = new ArrayList<LifeForm>();
		tempCreatures = new ArrayList<LifeForm>();

	}

	public String getStatus() {
		String str;
		int squareTurtle = 0;
		int shark = 0;
		int sharkBoat = 0;
		int jellyFish = 0;
		for (LifeForm x : myCreatures) {
			if (x.getID() == 1)
				squareTurtle++;
			if (x.getID() == 2)
				shark++;
			if (x.getID() == 3)
				sharkBoat++;
			if (x.getID() == 4)
				jellyFish++;
		}
		str = "There are " + squareTurtle + " Turtle, " + shark + " sharks, "
				+ jellyFish + " jelly fish, " + sharkBoat + " shark boats.";
		return str;
	}

	private void cleanUp() {
		for (int i = 0; i < myCreatures.size(); i++) {
			if (!myCreatures.get(i).isAlive()) {
				myCreatures.remove(i);
				i--;
			}
		}
	}

	/**
	 * Draw blank world
	 * 
	 * @param GCanvas
	 *            the canvas that you want to draw the world on.
	 */
	public void drawBlank(GCanvas c) {
		c.removeAll();
		for (int i = 0; i <= worldSize; i++) {
			c.add(new GLine(i * cellSize, 0, i * cellSize, worldSize * cellSize));
			c.add(new GLine(0, i * cellSize, worldSize * cellSize, i * cellSize));
		}
	}

	/**
	 * Return a creature at specific location
	 * 
	 * @param location
	 *            The location of cell you want to get creature at.
	 * @return Return the creature at that location, return null is no creature
	 *         exist there.
	 */
	public LifeForm getCreatureAt(Location location) {
		for (LifeForm f : myCreatures) {
			if (f.getLocation().getX() == location.getX()
					&& f.getLocation().getY() == location.getY()) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Get the list of creatures
	 * 
	 * @return Return the ArrayList of Creatures.
	 */
	public List<LifeForm> getCreatures() {
		return myCreatures;
	}

	/**
	 * Get the temporary List of creatures in order to add new creatures
	 * 
	 * @return Return the temporary ArrayList of new born creatures
	 */
	public List<LifeForm> getTempCreatures() {
		return tempCreatures;
	}

	/**
	 * Get the size of the world.
	 * 
	 * @return Return the size of world.
	 */
	public int getWorldSize() {
		return worldSize;
	}

	/**
	 * Check if a location is inside or not.
	 * 
	 * @param location
	 *            The location you want to check
	 * @return Return true if the location is inside of the World, false if it's
	 *         not
	 */
	public boolean isInside(Location location) {
		if (location.getX() >= worldSize || location.getX() < 0
				|| location.getY() >= worldSize || location.getY() < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Get the number of neighbors around this location.
	 * 
	 * @param location
	 *            The location you want to check
	 * @return Return the number of creatures around this location.
	 */
	public int getNeighbors(Location location) {
		int count = 0;
		if (getCreatureAt(new Location(location.getX() - 1, location.getY() - 1)) != null)
			count++;
		if (getCreatureAt(new Location(location.getX(), location.getY() - 1)) != null)
			count++;
		if (getCreatureAt(new Location(location.getX() + 1, location.getY() - 1)) != null)
			count++;
		if (getCreatureAt(new Location(location.getX() - 1, location.getY())) != null)
			count++;
		if (getCreatureAt(new Location(location.getX() + 1, location.getY())) != null)
			count++;
		if (getCreatureAt(new Location(location.getX() - 1, location.getY() + 1)) != null)
			count++;
		if (getCreatureAt(new Location(location.getX(), location.getY() + 1)) != null)
			count++;
		if (getCreatureAt(new Location(location.getX() + 1, location.getY() + 1)) != null)
			count++;
		return count;
	}

	/**
	 * Check if a location is occupied or not.
	 * 
	 * @param location
	 *            The location you want to check.
	 * @return True if the location is occupied, false if it's not.
	 */
	public boolean isOccupied(Location location) {
		if (getCreatureAt(location) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Refresh all creatures' graphic
	 * 
	 * @param c
	 *            The canvas where the world exist
	 */
	public void refreshCreatures(GCanvas c) {
		int length = tempCreatures.size();
		for (int i = 0; i < length; i++) {
			myCreatures.add(tempCreatures.get(0));
			tempCreatures.remove(0);

		}
		for (LifeForm x : myCreatures) {
			if (!isInside(x.getLocation())) {
				x.die();
			}
		}
		drawBlank(c);
		cleanUp();

		for (LifeForm x : myCreatures) {
			if (x.isAlive()) {
				GRect r = new GRect(x.getLocation().getX() * cellSize, x
						.getLocation().getY() * cellSize, cellSize, cellSize);
				r.setFillColor(x.getColor());
				r.setFilled(true);
				c.add(r);
			}
		}
	}

	/**
	 * Reset the size of the world
	 * 
	 * @param worldSize
	 *            The new size of the world.
	 */
	public void setWorldSize(int worldSize) {
		this.worldSize = worldSize;
	}
}
