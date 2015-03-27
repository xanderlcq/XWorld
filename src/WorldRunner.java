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
		//myWorld.getCreatures().add(new Rock(new Location(15, 5)));
		myWorld.getCreatures().add(new SquareTurtle(new Location(3, 5),0));
		myWorld.getCreatures().add(new SquareTurtle(new Location(5 ,8),4));
		myWorld.getCreatures().add(new SquareTurtle(new Location(15, 3),3));
		myWorld.getCreatures().add(new SquareTurtle(new Location(8, 11),7));
		myWorld.refreshCreatures(myWorldCanvas);
		while (true) {
			for(LifeForm f:myWorld.getCreatures()){
				f.excecuteRules();
			}
			myWorld.refreshCreatures(myWorldCanvas);
			pause(100);
		}

	}

	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		myWorldCanvas = this.getGCanvas();
		myWorld = new GridWorld(worldSize, cellSize);
		myWorld.drawBlank(myWorldCanvas);

	}
}
