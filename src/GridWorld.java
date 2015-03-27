import java.util.ArrayList;
import java.util.List;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GRect;

public class GridWorld {
	protected int worldSize;
	protected List<LifeForm> myCreatures;
	private int cellSize;

	public GridWorld(int worldSize, int cellSize) {
		this.worldSize = worldSize;
		this.cellSize = cellSize;
		myCreatures = new ArrayList<LifeForm>();
	}

	public void drawBlank(GCanvas c) {
		c.removeAll();
		for (int i = 0; i <= worldSize; i++) {
			c.add(new GLine(i * cellSize, 0, i * cellSize, worldSize * cellSize));
			c.add(new GLine(0, i * cellSize, worldSize * cellSize, i * cellSize));
		}
	}
	private void cleanUp(){
		for(int i=0;i<myCreatures.size();i++){
			if(!myCreatures.get(i).isAlive()){
				myCreatures.remove(i);
				i--;
			}
		}
	}
	public void refreshCreatures(GCanvas c) {
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

	public LifeForm getCreatureAt(int x, int y) {
		for (LifeForm f : myCreatures) {
			if (f.getLocation().getX() == x && f.getLocation().getY() == y) {
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
