import java.awt.Color;

public interface Life {
	public void die();
	
	public Location getLocation();

	public void setLocation(Location location);

	public int getAge();

	public void setAge(int age);

	public void setColor(Color c);

	public Color getColor();

	public void goUp();

	public void goDown();

	public void goRight();

	public void goLeft();

	public boolean isAlive();

	public void reproduce(GridWorld myworld);
	
	public void excecuteRules(GridWorld myWorld);
}
