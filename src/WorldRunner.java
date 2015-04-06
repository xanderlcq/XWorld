import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeListener;

import acm.graphics.*;
import acm.program.*;
import acmx.export.javax.swing.JButton;
import acmx.export.javax.swing.JLabel;
import acmx.export.javax.swing.*;
import acmx.export.javax.swing.event.ChangeEvent;
import acm.util.*;

@SuppressWarnings("serial")
public class WorldRunner extends GraphicsProgram {
	static int worldSize = 20;
	static int cellSize = 30;
	public static final int APPLICATION_WIDTH = worldSize * cellSize;
	public static final int APPLICATION_HEIGHT = worldSize * cellSize;
	private GridWorld myWorld;
	GCanvas myWorldCanvas;
	private boolean pause = false;
	private int pauseTime = 50;
	private int mouseState = 0;

	public void run() {
		init();

		//myWorld.getCreatures().add(new SharkBoat(new Location(18, 5), myWorld));
		// myWorld.getCreatures().add(new Rock(new Location(15, 5)));
		// myWorld.getCreatures().add(new Rock(new Location(4, 7)));
		/*
		 * myWorld.getCreatures().add(new Shark(new Location(0,
		 * 0),0,true,true,true)); myWorld.getCreatures().add(new
		 * SquareTurtle(new Location(5, 9), 4)); myWorld.getCreatures().add(new
		 * SquareTurtle(new Location(15, 13), 3));
		 * myWorld.getCreatures().add(new SquareTurtle(new Location(2, 6), 2));
		 * myWorld.getCreatures().add(new SquareTurtle(new Location(1, 17), 1));
		 * // myWorld.getCreatures().add(new SquareTurtle(new Location(14,
		 * 7),6)); // myWorld.getCreatures().add(new SquareTurtle(new
		 * Location(13, 3),7));
		 */
		myWorld.refreshCreatures(myWorldCanvas);
		pause(1000);
		// myWorld.getCreatures().get(1).reproduce(myWorld);
		// myWorld.refreshCreatures(myWorldCanvas);
		addMouseListeners();

		while (true) {

			for (int i = 0; i < myWorld.getCreatures().size(); i++) {
				myWorld.getCreatures().get(i).excecuteRules(myWorld);
			}

			myWorld.refreshCreatures(myWorldCanvas);
			System.out.println(myWorld.getStatus());
			pauseTime = slider.getValue();
			pause(pauseTime);
			while (pause) {
				pause(10);
				if (!pause)
					break;
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		// pause = !pause;
		int x = e.getX() / cellSize - 1;
		int y = e.getY() / cellSize;
		if (x < 20 && y < 20) {
			if (mouseState == 0)
				myWorld.getCreatures().add(
						new SquareTurtle(new Location(x, y), 3));
			if (mouseState == 1)
				myWorld.getCreatures().add(
						new Shark(new Location(x, y), 0,true,true,true));
			if (mouseState == 2)
				myWorld.getCreatures().add(
						new SharkBoat(new Location(x, y),myWorld));
			if (mouseState == 3)
				myWorld.getCreatures().add(
						new JellyFish(new Location(x, y)));
		}
	}

	public void init() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT + 80);
		myWorldCanvas = this.getGCanvas();
		myWorld = new GridWorld(worldSize, cellSize);
		myWorld.drawBlank(myWorldCanvas);
		add(new JLabel("Fast"), NORTH);
		add(slider, NORTH);
		add(new JLabel("Slow"), NORTH);
		JButton startButton = new JButton("Pause");
		startButton.addActionListener(this);
		add(startButton, SOUTH);
		JButton stopButton = new JButton("Resume");
		stopButton.addActionListener(this);
		add(stopButton, SOUTH);
		JButton addTurtle = new JButton("Add Turtle");
		addTurtle.addActionListener(this);
		add(addTurtle, SOUTH);
		JButton addShark = new JButton("Add Shark");
		addShark.addActionListener(this);
		add(addShark, SOUTH);
		JButton addBoat = new JButton("Add Boat");
		addBoat.addActionListener(this);
		add(addBoat, SOUTH);
		JButton addJellyFish = new JButton("Add Jellyfish");
		addJellyFish.addActionListener(this);
		add(addJellyFish, SOUTH);
	}

	private JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Pause")) {
			pause = true;
		} else if (e.getActionCommand().equals("Resume")) {
			pause = false;
		} else if (e.getActionCommand().equals("Add Turtle")) {
			mouseState = 0;
		} else if (e.getActionCommand().equals("Add Shark")) {
			mouseState = 1;
		} else if (e.getActionCommand().equals("Add Boat")) {
			mouseState = 2;
		} else if (e.getActionCommand().equals("Add Jellyfish")) {
			mouseState = 3;
		}
	}
}
