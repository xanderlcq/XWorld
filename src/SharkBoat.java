public class SharkBoat extends LifeForm{
	public int state;
	public SharkBoat(Location location, GridWorld myWorld, int i) {
		super(location);
		color = color.BLUE;
		//this.state = state;
	//	state = myWorld.getWorldSize() - location.getX();
		state = location.getX();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void excecuteRules(GridWorld myWorld) {
		int startingX = location.getX();
		
		if(state >=0 && state < myWorld.getWorldSize()-1){
			goRight();
			state ++;
			return;
		}else if(state < (myWorld.getWorldSize()-1)*2){
			goLeft();
			state++;
			return;
		}else{
			state = 0;
		}
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
				new SharkBoat(newLocation, myWorld, (int) (Math.random() * 7)));
	}		
}