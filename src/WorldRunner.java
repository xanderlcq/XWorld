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
		myWorld.getCreatures().add(new Rock(new Location(15, 5)));
		myWorld.getCreatures().add(new Rock(new Location(4, 7)));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(3, 5),0));
		myWorld.getCreatures().add(new SquareTurtle(new Location(5 ,9),4));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(15, 13),3));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(2, 6),2));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(1, 17),1));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(14, 7),6));
		//myWorld.getCreatures().add(new SquareTurtle(new Location(13, 3),7));
		
		
		
		myWorld.refreshCreatures(myWorldCanvas);
		pause(1000);
		//myWorld.getCreatures().get(1).reproduce(myWorld);
		//myWorld.refreshCreatures(myWorldCanvas);
		while (true) {
			for(int i = 0; i < myWorld.getCreatures().size();i++){
				myWorld.getCreatures().get(i).excecuteRules(myWorld);
			}
			
			myWorld.refreshCreatures(myWorldCanvas);
			pause(1000);
		}

	}

	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		myWorldCanvas = this.getGCanvas();
		myWorld = new GridWorld(worldSize, cellSize);
		myWorld.drawBlank(myWorldCanvas);

	}
}
