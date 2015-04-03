import java.awt.Color;

public class JellyFish extends LifeForm {
	private int state;
	private int Hstate;

	public JellyFish(Location location) {
		super(location);
		ID = 3;
		color = Color.RED;
		state = 0;
		Hstate = 0;
	}
	@Override
	public void excecuteRules(GridWorld myWorld){
	
		if (state == 0) {
			if (myWorld.isInside(new Location(location.getX(),
					location.getY() - 1))) {
				goUp();
				return;
			} else {
				goDown();
				state = 1;
				return;
			}
		}
		if (state == 1) {//going down
			if (myWorld.isInside(new Location(location.getX(),
					location.getY()+1))) {//check bottom
				goDown();
				return;
			} else {//if reach bot
				
				if (Hstate == 0) {
					if (myWorld.isInside(new Location(location.getX() + 1,
							location.getY()))) {//check right
						goRight();
						state = 0;
						return;
					}else{
						Hstate = 1;
						state = 0;
						goLeft();
					
					}
				}
				if(Hstate == 1){
					if (myWorld.isInside(new Location(location.getX() - 1,
							location.getY()))) {//check right
						goLeft();
						state = 0;
						return;
					}else{
						Hstate = 0;
						state = 0;
						goRight();
						return;
					}
				}
			}
		}
	}
}
