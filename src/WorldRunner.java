import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class WorldRunner extends GraphicsProgram {
	static int worldSize = 20;
	static int cellSize = 30;
	public static final int APPLICATION_WIDTH = worldSize * cellSize;
	public static final int APPLICATION_HEIGHT = worldSize * cellSize;

	public void run() {
		init();


	}

	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		GCanvas myWorldCanvas = this.getGCanvas();
		GridWorld myWorld = new GridWorld(worldSize,cellSize);
		myWorld.drawBlank(myWorldCanvas);
	}
}
