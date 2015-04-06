public class SharkBoat extends LifeForm {
	public int state;
	public SharkBoat(Location location, GridWorld myWorld) {
		super(location);
		color = color.BLUE;
		// this.state = state;
		// state = myWorld.getWorldSize() - location.getX();
		state = location.getX();
		ID = 3;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void excecuteRules(GridWorld myWorld) {
		int startingX = location.getX();
		if (state >= 0 && state < myWorld.getWorldSize() - 1) {
			if (myWorld.getCreatureAt(new Location(location.getX() + 1,
					location.getY())) != null) {
				if (myWorld.getCreatureAt(
						new Location(location.getX() + 1, location.getY()))
						.getID() == 2) {
					myWorld.getCreatureAt(
							new Location(location.getX() + 1, location.getY()))
							.die();
				} 
				if (myWorld.getCreatureAt(
						new Location(location.getX() + 1, location.getY()))
						.getID() == 4) {
				return;				}
				if (myWorld.getCreatureAt(
						new Location(location.getX() + 1, location.getY()))
						.getID() == 1) {
					return;
				}else {
					return;
				}
			}
			goRight();
			state++;
			return;
		} else if (state < (myWorld.getWorldSize() - 1) * 2) {
			if (myWorld.getCreatureAt(new Location(location.getX() - 1,
					location.getY())) != null) {
				if (myWorld.getCreatureAt(
						new Location(location.getX() - 1, location.getY()))
						.getID() == 2) {
					myWorld.getCreatureAt(
							new Location(location.getX() - 1, location.getY()))
							.die();
				}
				if (myWorld.getCreatureAt(
						new Location(location.getX() - 1, location.getY()))
						.getID() == 4) {
					return;
				}
				if (myWorld.getCreatureAt(
						new Location(location.getX() - 1, location.getY()))
						.getID() == 1) {
					return;
				}else {
					return;
				}
			}
			goLeft();
			state++;
			return;
		} else {
			state = 0;
		}
	}
	public void reproduce(GridWorld myWorld) {
	}
}