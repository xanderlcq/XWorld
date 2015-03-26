import java.util.List;
import acm.graphics.GCanvas;
import acm.graphics.GLine;


public class GridWorld {
	protected int worldSize;
	protected List<LifeForm> myCreatures;
	private int cellSize;

	public GridWorld(int worldSize,int cellSize) {
		this.worldSize = worldSize;
		this.cellSize = cellSize;
	}

	public void drawBlank(GCanvas c) {
		for(int i = 0;i <= worldSize;i++){
			c.add(new GLine(i*cellSize,0,i*cellSize,worldSize*cellSize));
			c.add(new GLine(0,i*cellSize,worldSize*cellSize,i*cellSize));
		}
	}

	public void refreshCreatures() {
	}

	public int getWorldSize() {
		return worldSize;
	}

	public void setWorldSize(int worldSize) {
		this.worldSize = worldSize;
	}

	public List<LifeForm> getMyCreatures() {
		return myCreatures;
	}

	public void setMyCreatures(List<LifeForm> myCreatures) {
		this.myCreatures = myCreatures;
	}
}
