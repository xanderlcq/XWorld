import java.util.ArrayList;
import java.util.List;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GRect;

public class GridWorld {
	protected int worldSize;
	protected List<LifeForm> myCreatures;
	private int cellSize;
	protected List<LifeForm> tempCreatures;

	public GridWorld(int worldSize, int cellSize) {
		this.worldSize = worldSize;
		this.cellSize = cellSize;
		myCreatures = new ArrayList<LifeForm>();
		tempCreatures = new ArrayList<LifeForm>();

	}

	public List<LifeForm> getTempCreatures() {
		return tempCreatures;
	}

	public void drawBlank(GCanvas c) {
		c.removeAll();
		for (int i = 0; i <= worldSize; i++) {
			c.add(new GLine(i * cellSize, 0, i * cellSize, worldSize * cellSize));
			c.add(new GLine(0, i * cellSize, worldSize * cellSize, i * cellSize));
		}
	}

	private void cleanUp() {
		for (int i = 0; i < myCreatures.size(); i++) {
			if (!myCreatures.get(i).isAlive()) {
				myCreatures.remove(i);
				i--;
			}
		}
	}

	public boolean isOccupied(Location location) {
		if (getCreatureAt(location) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void refreshCreatures(GCanvas c) {
		drawBlank(c);
		cleanUp();
		int length = tempCreatures.size();
		for (int i = 0; i < length; i++) {
			myCreatures.add(tempCreatures.get(0));
			tempCreatures.remove(0);

		}
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

	public LifeForm getCreatureAt(Location location) {
		for (LifeForm f : myCreatures) {
			if (f.getLocation().getX() == location.getX()
					&& f.getLocation().getY() == location.getY()) {
				return f;
			}
		}
		return null;
	}

	public int getWorldSize() {
		return worldSize;
	}

	public void setWorldSize(int worldSize) {
		this.worldSize = worldSize;
	}

	public List<LifeForm> getCreatures() {
		return myCreatures;
	}
}
