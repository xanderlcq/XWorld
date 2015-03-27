import java.awt.Color;

public class SquareTurtle extends LifeForm {
	public int state;

	public SquareTurtle(Location location,int state) {
		super(location);
		color = Color.GREEN;
		this.state = state;
	}

	@Override
	public void excecuteRules() {
		if (state == 0) {
			goDown();
			state++;
			return;
		}
		if (state == 1) {
			goDown();
			state++;
			return;
		}
		if (state == 2) {
			goRight();
			state++;
			return;
		}
		if (state == 3) {
			goRight();
			state++;
			return;
		}
		if (state == 4) {
			goUp();
			state++;
			return;
		}
		if (state == 5) {
			goUp();
			state++;
			return;
		}
		if (state == 6) {
			goLeft();
			state++;
			return;
		}
		if (state == 7) {
			goLeft();
			state = 0;
			return;
		}
		System.out.println(state);

	}

}
