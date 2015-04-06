import java.awt.Color;
import acm.util.RandomGenerator;
public class Shark extends LifeForm {
	boolean forward;
	public int state;
	public boolean direction;
	public boolean Hstate; 
	public Shark(Location location, int state, boolean forward,
			boolean direction, boolean Hstate) {
		super(location);
		color = Color.CYAN;
		this.direction = direction;
		this.forward = forward;
		this.state = state;
		this.Hstate = Hstate;
		ID = 2;
	}
	public void excecuteRules(GridWorld myWorld) {
		if (direction)
			horizontal(myWorld);
		else
			vertical(myWorld);
	}
	public void horizontal(GridWorld myWorld) {
		if (state == 0) {
			if (Hstate) {
				if (myWorld.isInside(new Location(location.getX() + 1, location
						.getY()))) {
					if (myWorld.getCreatureAt(new Location(
							getLocation().getX() + 1, getLocation().getY())) != null) {
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() + 1,
										getLocation().getY())).getID() == 4)
							myWorld.getCreatureAt(
									new Location(getLocation().getX() + 1,
											getLocation().getY())).die();
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() + 1,
										getLocation().getY())).getID() == 1){
							myWorld.getCreatureAt(
									new Location(getLocation().getX() + 1,
											getLocation().getY())).die();
							reproduceJelly(myWorld);
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() + 1,
										getLocation().getY())).getID() == 3) {
							die();
							return;
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() + 1,
										getLocation().getY())).getID()==2)
							reproduce(myWorld);
					}
					goRight();
					return;
				} else {
					Hstate = !Hstate;
					state = 1;
					return;
				}
			} else {
				if (myWorld.isInside(new Location(location.getX() - 1, location
						.getY()))) {
					if (myWorld.getCreatureAt(new Location(
							getLocation().getX() - 1, getLocation().getY())) != null) {
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() - 1,
										getLocation().getY())).getID() == 4)
							myWorld.getCreatureAt(
									new Location(getLocation().getX() - 1,
											getLocation().getY())).die();
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() - 1,
										getLocation().getY())).getID() == 1){
							myWorld.getCreatureAt(
									new Location(getLocation().getX() - 1,
											getLocation().getY())).die();
									reproduceJelly(myWorld);
					}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() - 1,
										getLocation().getY())).getID() == 3){
							die();
							return;
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX() - 1,
										getLocation().getY())).getID() == 2)
							reproduce(myWorld);
					}
					goLeft();
					return;
				} else if ((getLocation().getX() == 0 && getLocation().getY() + 1 == myWorld
						.getWorldSize())
						|| (getLocation().getX() == 0 && getLocation().getY() == 0)) {
					forward = !forward;
					Hstate = !Hstate;
					return;
				} else {
					state = 1;
					Hstate = !Hstate;
					return;
				}
			}
		}
		if (state == 1) {
			if (forward) {
				if (myWorld.isInside(new Location(location.getX(), location
						.getY()+1))) {
				if (myWorld.getCreatureAt(new Location(getLocation().getX(),
						getLocation().getY() + 1)) != null) {
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() + 1)).getID() == 4)
						myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY() + 1)).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(),
									getLocation().getY()+1)).getID() == 1){
						myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()+1)).die();
							reproduceJelly(myWorld);
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() + 1)).getID() == 3){
						die();
						return;
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(),
									getLocation().getY()+1)).getID()==2)
						reproduce(myWorld);
				}
				goDown();
				state = 0;
				}else{
					forward=!forward;
					return;
				}
			} else {
				if (myWorld.isInside(new Location(location.getX(), location
						.getY()-1))) {
				if (myWorld.getCreatureAt(new Location(getLocation().getX(),
						getLocation().getY() - 1)) != null) {
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() - 1)).getID() == 4)
						myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY() - 1)).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(),
									getLocation().getY()-1)).getID() == 1){
						myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()-1)).die();
						reproduceJelly(myWorld);
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(), getLocation()
									.getY() - 1)).getID()==3) {
						die();
						return;
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX(),
									getLocation().getY()-1)).getID() == 2)
						reproduce(myWorld);
				}
				goUp();
				state = 0;
				}else{
					forward=!forward;
					return;
				}
			}
		}
	}
	public void vertical(GridWorld myWorld) {
		if (state == 0) {
			if (Hstate) {
				if (myWorld.isInside(new Location(location.getX(), location
						.getY()+1))) {
					if (myWorld.getCreatureAt(new Location(
							getLocation().getX(), getLocation().getY()+1)) != null) {
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()+1)).getID() == 4)
							myWorld.getCreatureAt(
									new Location(getLocation().getX(),
											getLocation().getY()+1)).die();
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()+1)).getID() == 1){
							myWorld.getCreatureAt(
									new Location(getLocation().getX(),
											getLocation().getY()+1)).die();
							reproduceJelly(myWorld);
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()+1)).getID() == 3) {
							die();
							return;
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()+1)).getID() == 2)
							reproduce(myWorld);
					}
					goDown();
					return;
				} else {
					Hstate = !Hstate;
					state = 1;
					return;
				}
			} else {
				if (myWorld.isInside(new Location(location.getX(), location
						.getY()-1))) {
					if (myWorld.getCreatureAt(new Location(
							getLocation().getX(), getLocation().getY()-1)) != null) {
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()-1)).getID() == 4)
							myWorld.getCreatureAt(
									new Location(getLocation().getX(),
											getLocation().getY()-1)).die();
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()-1)).getID() == 1){
							myWorld.getCreatureAt(
									new Location(getLocation().getX(),
											getLocation().getY()-1)).die();
							reproduceJelly(myWorld);
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()-1)).getID() == 3){
							die();
							return;
						}
						if (myWorld.getCreatureAt(
								new Location(getLocation().getX(),
										getLocation().getY()-1)).getID() == 2)
							reproduce(myWorld);
					}
					goUp();
					return;
				} else if ((getLocation().getX() == myWorld.getWorldSize()-1 && getLocation().getY() == 0)
						|| (getLocation().getX() == 0 && getLocation().getY() == 0)) {
					forward = !forward;
					Hstate = !Hstate;
					return;
				} else {
					state = 1;
					Hstate = !Hstate;
					return;
				}
			}
		}
		if (state == 1) {
			if (forward) {
				if (myWorld.isInside(new Location(location.getX()+1, location
						.getY()))) {
				if (myWorld.getCreatureAt(new Location(getLocation().getX()+1,
						getLocation().getY())) != null) {
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()+1, getLocation()
									.getY())).getID() == 4)
						myWorld.getCreatureAt(
								new Location(getLocation().getX()+1,
										getLocation().getY())).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX() + 1,
									getLocation().getY())).getID() == 1)
						myWorld.getCreatureAt(
								new Location(getLocation().getX() + 1,
										getLocation().getY())).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()+1, getLocation()
									.getY())).getID() == 3){
						die();
						return;
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX() + 1,
									getLocation().getY())).getID() == 2)
						reproduce(myWorld);
				}
				goRight();
				state = 0;
				}else{
					forward=!forward;
					return;
				}
			} else {
				if (myWorld.isInside(new Location(location.getX()-1, location
						.getY()))) {
				if (myWorld.getCreatureAt(new Location(getLocation().getX()-1,
						getLocation().getY())) != null) {
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()-1, getLocation()
									.getY())).getID() == 2)
						myWorld.getCreatureAt(
								new Location(getLocation().getX()-1,
										getLocation().getY())).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()-1,
									getLocation().getY())).getID() == 1)
						myWorld.getCreatureAt(
								new Location(getLocation().getX()-1,
										getLocation().getY())).die();
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()-1, getLocation()
									.getY())).getID() == 3) {
						die();
						return;
					}
					if (myWorld.getCreatureAt(
							new Location(getLocation().getX()-1,
									getLocation().getY())).getID()==2)
						reproduce(myWorld);
				}
				goLeft();
				state = 0;
				}else{
					forward=!forward;
					return;
				}
			}
		}
		}
	
	public void reproduce(GridWorld myWorld) {
		boolean way = rgen.nextBoolean();
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
					new Shark(newLocation,0, true, way, true));
		}
	}
	
	public void reproduceJelly(GridWorld myWorld){
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
					new JellyFish(newLocation));
		}
	}
	
	
	
	/* private instance variable -- Random Generator */
		
	private RandomGenerator rgen = RandomGenerator.getInstance();
}