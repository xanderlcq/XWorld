import java.awt.Color;

public class SquareTurtle extends LifeForm {
	public int state;

	public SquareTurtle(Location location, int state) {
		super(location);
		color = Color.GREEN;
		this.state = state;
	}

	@Override
	public void excecuteRules(GridWorld myWorld) {
		if (state == 0) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() + 1)) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).die();
				reproduce(myWorld);
			}
			goDown();
			state++;

			return;
		}
		if (state == 1) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() + 1)) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).die();
				reproduce(myWorld);
			}
			goDown();
			state++;

			return;
		}
		if (state == 2) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX() + 1,
					getLocation().getY())) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).die();
				reproduce(myWorld);
			}
			goRight();
			state++;

			return;
		}
		if (state == 3) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX() + 1,
					getLocation().getY())) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).die();
				reproduce(myWorld);
			}
			goRight();
			state++;

			return;
		}
		if (state == 4) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() - 1)) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).die();
				reproduce(myWorld);
			}
			goUp();
			state++;

			return;
		}
		if (state == 5) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() - 1)) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).die();
				reproduce(myWorld);
			}
			goUp();
			state++;

			return;
		}
		if (state == 6) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX() - 1,
					getLocation().getY())) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).die();
				reproduce(myWorld);
			}
			goLeft();
			state++;

			return;
		}
		if (state == 7) {
			if (myWorld.getCreatureAt(new Location(getLocation().getX() - 1,
					getLocation().getY())) != null) {
				myWorld.getCreatureAt(
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).die();
				reproduce(myWorld);
			}
			goLeft();
			state = 0;
			return;
		}
		System.out.println(state);

	}

	public void reproduce(GridWorld myWorld) {
		int temp;
		if (Math.random() * 10 > 5) {
			temp = 1;
		} else {
			temp = -1;
		}
		Location newLocation = new Location(temp
				* (int) (location.getX() + Math.random() * 2), temp
				* (int) (location.getY() + Math.random() * 2));
		myWorld.getTempCreatures().add(
				new SquareTurtle(newLocation, (int) (Math.random() * 7)));
	}

}
