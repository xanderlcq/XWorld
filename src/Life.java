import java.awt.Color;

public interface Life {
	public void die();
public Location getLocation();
public void setLocation(Location location);
	public int getAge();
	public void setAge(int age);
	public void setColor(Color c);
	public Color getColor(Color c);
	public void goUp();
	public void goDown();
	public void goRight();
	public void goLeft();
}
