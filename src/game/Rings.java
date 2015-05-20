package game;

import java.util.LinkedList;

public class Rings {

	public final LinkedList<Color> internLeft = new LinkedList<Color>();
	public final LinkedList<Color> internRight = new LinkedList<Color>();
	public final LinkedList<Color> externLeft = new LinkedList<Color>();
	public final LinkedList<Color> externRight = new LinkedList<Color>();
	public Color crossBottom;
	public Color crossTop;

	public Rings() {
		reset();
	}

	public Color getColor(Ring ring, int index) {
		if (ring == Ring.LEFT) {
			if (index == 0) {
				return crossBottom;
			} else if (index > 0 && index < 5) {
				return internRight.get(index - 1);
			} else if (index == 5) {
				return crossTop;
			} else if (index > 5 && index < 19) {
				return externLeft.get(index - 6);
			} else {
				throw new IllegalArgumentException("Invalid index: " + index);
			}
		} else if (ring == Ring.RIGHT) {
			if (index == 0) {
				return crossBottom;
			} else if (index > 0 && index < 5) {
				return internLeft.get(index - 1);
			} else if (index == 5) {
				return crossTop;
			} else if (index > 5 && index < 19) {
				return externRight.get(index - 6);
			} else {
				throw new IllegalArgumentException("Invalid index: " + index);
			}
		} else {
			throw new IllegalArgumentException("Invalid ring: " + ring);
		}
	}

	public void turn(Ring ring, Direction direction) {
		if (ring == Ring.LEFT) {
			if (direction == Direction.CLOCK) {
				externLeft.addLast(crossBottom);
				crossBottom = internRight.removeFirst();
				internRight.addLast(crossTop);
				crossTop = externLeft.removeFirst();
			} else if (direction == Direction.REVERSE_CLOCK) {
				externLeft.addFirst(crossTop);
				crossTop = internRight.removeLast();
				internRight.addFirst(crossBottom);
				crossBottom = externLeft.removeLast();
			} else {
				throw new IllegalArgumentException("Invalid direction: "
						+ direction);
			}
		} else if (ring == Ring.RIGHT) {
			if (direction == Direction.CLOCK) {
				externRight.addFirst(crossTop);
				crossTop = internLeft.removeLast();
				internLeft.addFirst(crossBottom);
				crossBottom = externRight.removeLast();
			} else if (direction == Direction.REVERSE_CLOCK) {
				externRight.addLast(crossBottom);
				crossBottom = internLeft.removeFirst();
				internLeft.addLast(crossTop);
				crossTop = externRight.removeFirst();
			} else {
				throw new IllegalArgumentException("Invalid direction: "
						+ direction);
			}
		} else {
			throw new IllegalArgumentException("Invalid ring: " + ring);
		}
	}

	public enum Ring {
		LEFT, RIGHT
	}

	public enum Direction {
		CLOCK, REVERSE_CLOCK
	}

	public void reset() {
		internLeft.clear();
		internRight.clear();
		externLeft.clear();
		externRight.clear();
		
		for (int i = 0; i < 4; i++) {
			internLeft.add(Color.GREEN);
			internRight.add(Color.BLUE);
		}
		crossBottom = Color.BLUE;
		crossTop = Color.GREEN;
		for (int i = 0; i < 9; i++) {
			externLeft.add(Color.RED);
		}
		for (int i = 0; i < 4; i++) {
			externLeft.add(Color.BLUE);
		}
		for (int i = 0; i < 4; i++) {
			externRight.add(Color.GREEN);
		}
		for (int i = 0; i < 9; i++) {
			externRight.add(Color.PURPLE);
		}
	}
}
