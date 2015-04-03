import java.awt.Color;

public abstract class LifeForm implements Life {
	protected int age;
	protected int ID;
	protected boolean alive;
	protected Color color;
	protected Location location;
	public LifeForm(Location location) {
		this.location = location;
		this.age = 0;
		this.alive = true;
	}
	public int getID(){
		return ID;
	}
	@Override
	public void die() {
		alive = false;
	}

	@Override
	public void excecuteRules(GridWorld myWorld){}
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public Location getLocation(){
		return location;
	}
	@Override
	public void goDown() {
		location.setY(location.getY()+1);
	}
	@Override
	public void goLeft() {
		location.setX(location.getX()-1);
	}

	@Override
	public void goRight() {
		location.setX(location.getX()+1);
	}

	@Override
	public void goUp() {
		location.setY(location.getY()-1);
	}

	@Override
	public boolean isAlive(){
		return alive;
	}

	@Override
	public void reproduce(GridWorld myworld){}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
    public void setLocation(Location location){
    	this.location = location;
    }

	@Override
	public String toString() {
		return "LifeForm [age=" + age + ", color=" + color + ", alive=" + alive
				+ ", location=" + location + "]";
	}

}
