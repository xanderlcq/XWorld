import acm.graphics.*;
import acm.program.*;

@SuppressWarnings("serial")
public class WorldRunner extends GraphicsProgram {
	static int worldSize = 20;
	static int cellSize = 30;
	public static final int APPLICATION_WIDTH = worldSize * cellSize;
	public static final int APPLICATION_HEIGHT = worldSize * cellSize;
	private GridWorld myWorld;
	GCanvas myWorldCanvas;

	public void run() {
		init();
		Turtle t = new Turtle(new Location(7, 5));
		myWorld.getCreatures().add(new Rock(new Location(5, 5)));
		myWorld.getCreatures().add(t);
		myWorld.refreshCreatures(myWorldCanvas);
		while (true) {
			while (t.getLocation().getX() > 0) {
				if(myWorld.getCreatureAt(t.getLocation().getX()-1,t.getLocation().getY()) != null){
					myWorld.getCreatureAt(t.getLocation().getX()-1,t.getLocation().getY()).die();
				}
				t.goLeft();
				myWorld.refreshCreatures(myWorldCanvas);
				pause(1000);

			}
			while (t.getLocation().getX() < worldSize - 1) {
				t.goRight();
				myWorld.refreshCreatures(myWorldCanvas);
				pause(100);
			}

		}

	}

	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		myWorldCanvas = this.getGCanvas();
		myWorld = new GridWorld(worldSize, cellSize);
		myWorld.drawBlank(myWorldCanvas);

	}
}
