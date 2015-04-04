import java.awt.Color;

public class SquareTurtle extends LifeForm {
	private int state;

	public SquareTurtle(Location location, int state) {
		super(location);
		color = Color.GREEN;
		this.state = state;
		ID = 1;
	}

	@Override
	public void excecuteRules(GridWorld myWorld) {
		if (state == 0) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() + 1)) != null) {
				if (myWorld.getCreatureAt(// wait for shark to pass
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(// eat the jelly fish
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).getID() == 4) {
					myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() + 1)).die();
				}
				reproduce(myWorld);
			}
			goDown();
			state++;

			return;
		}
		if (state == 1) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() + 1)) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() + 1)).getID() == 4) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() + 1)).die();

				}

				reproduce(myWorld);
			}
			goDown();
			state++;

			return;
		}
		if (state == 2) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX() + 1,
					getLocation().getY())) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).getID() == 4) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX() + 1,
									getLocation().getY())).die();

				}

				reproduce(myWorld);
			}
			goRight();
			state++;

			return;
		}
		if (state == 3) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX() + 1,
					getLocation().getY())) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() + 1, getLocation()
								.getY())).getID() == 4) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX() + 1,
									getLocation().getY())).die();

				}

				reproduce(myWorld);
			}
			goRight();
			state++;

			return;
		}
		if (state == 4) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() - 1)) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).getID() == 2) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() - 1)).die();

				}

				reproduce(myWorld);
			}
			goUp();
			state++;

			return;
		}
		if (state == 5) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX(),
					getLocation().getY() - 1)) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX(),
								getLocation().getY() - 1)).getID() == 4) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() - 1)).die();

				}

				reproduce(myWorld);
			}
			goUp();
			state++;

			return;
		}
		if (state == 6) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX() - 1,
					getLocation().getY())) != null) {
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).getID() == 4) {

					myWorld.getCreatureAt(
							new Location(getLocation().getX() - 1,
									getLocation().getY())).die();

				}

				reproduce(myWorld);
			}
			goLeft();
			state++;

			return;
		}
		if (state == 7) {
			if (myWorld.getNeighbors(location) > 2) {
				die();
				return;
			}
			if (myWorld.getCreatureAt(new Location(getLocation().getX() - 1,
					getLocation().getY())) != null) {
				if (myWorld.getCreatureAt(// wait for shark to pass
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).getID() == 2) {
					return;
				}
				if (myWorld.getCreatureAt(// eat the jelly fish
						new Location(getLocation().getX() - 1, getLocation()
								.getY())).getID() == 4) {
					myWorld.getCreatureAt(
							new Location(getLocation().getX() - 1,
									getLocation().getY())).die();
				}

				reproduce(myWorld);
			}
			goLeft();
			state = 0;
			return;
		}
		System.out.println(state);

	}

	@Override
	public void reproduce(GridWorld myWorld) {
		int temp;
		if (Math.random() > 0.5) {
			temp = 1;
		} else {
			temp = -1;
		}
		Location newLocation = new Location((int) (location.getX() + temp
				* Math.random() * 5), (int) (location.getY() + temp
				* Math.random() * 5));
		int count = 0;
		while (myWorld.isOccupied(newLocation)
				|| !myWorld.isInside(newLocation)) {
			if (count == 5)
				break;
			count++;

			newLocation = new Location(temp
					* (int) (location.getX() + Math.random() * 10), temp
					* (int) (location.getY() + Math.random() * 10));

		}
		if (count < 5) {
			myWorld.getTempCreatures().add(
					new SquareTurtle(newLocation, (int) (Math.random() * 7)));
		}
	}

}
