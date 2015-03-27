import java.awt.Color;

public abstract class LifeForm implements Life {
	protected int age;
	protected Color color;
	protected boolean alive;
	protected Location location;
	public LifeForm(Location location) {
		this.location = location;
		this.age = 0;
		this.alive = true;
	}
	
	@Override
	public void reproduce(){}
	
	@Override
	public boolean isAlive(){
		return alive;
	}
	
	@Override
	public void die() {
		alive = false;
	}
	@Override
    public void setLocation(Location location){
    	this.location = location;
    }
	@Override
	public Location getLocation(){
		return location;
	}
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void goUp() {
		location.setY(location.getY()-1);
	}

	@Override
	public void goDown() {
		location.setY(location.getY()+1);
	}

	@Override
	public void goRight() {
		location.setX(location.getX()+1);
	}

	@Override
	public void goLeft() {
		location.setX(location.getX()-1);
	}

	@Override
	public String toString() {
		return "LifeForm [age=" + age + ", color=" + color + ", alive=" + alive
				+ ", location=" + location + "]";
	}

}
