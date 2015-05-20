package game.impl;

import static org.junit.Assert.*;
import game.Color;
import game.Rings;
import game.Rings.Direction;
import game.Rings.Ring;

import org.junit.Test;

public class RingsTest {

	@Test
	public void testInitialRings() {
		Rings rings = new Rings();

		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 0));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 1));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 2));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 3));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 4));
		assertEquals(Color.GREEN, rings.getColor(Ring.LEFT, 5));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 6));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 7));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 8));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 9));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 10));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 11));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 12));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 13));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 14));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 15));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 16));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 17));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 18));

		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 0));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 1));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 2));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 3));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 4));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 5));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 6));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 7));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 8));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 9));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 10));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 11));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 12));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 13));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 14));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 15));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 16));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 17));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 18));
	}

	@Test
	public void testTurningRings() {
		Rings rings = new Rings();

		rings.turn(Ring.LEFT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.CLOCK);
		rings.turn(Ring.LEFT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.CLOCK);
		rings.turn(Ring.LEFT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
		rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
		
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 0));
		assertEquals(Color.PURPLE, rings.getColor(Ring.LEFT, 1));
		assertEquals(Color.PURPLE, rings.getColor(Ring.LEFT, 2));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 3));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 4));
		assertEquals(Color.GREEN, rings.getColor(Ring.LEFT, 5));
		assertEquals(Color.GREEN, rings.getColor(Ring.LEFT, 6));
		assertEquals(Color.GREEN, rings.getColor(Ring.LEFT, 7));
		assertEquals(Color.GREEN, rings.getColor(Ring.LEFT, 8));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 9));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 10));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 11));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 12));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 13));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 14));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 15));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 16));
		assertEquals(Color.RED, rings.getColor(Ring.LEFT, 17));
		assertEquals(Color.BLUE, rings.getColor(Ring.LEFT, 18));
		
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 0));
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 1));
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 2));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 3));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 4));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 5));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 6));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 7));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 8));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 9));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 10));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 11));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 12));
		assertEquals(Color.PURPLE, rings.getColor(Ring.RIGHT, 13));
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 14));
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 15));
		assertEquals(Color.BLUE, rings.getColor(Ring.RIGHT, 16));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 17));
		assertEquals(Color.GREEN, rings.getColor(Ring.RIGHT, 18));
	}
}
