package gui;

import java.awt.Color;
import java.awt.Graphics;

import game.Rings;
import game.Rings.Ring;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private final Rings rings;

	public Canvas(Rings rings) {
		this.rings = rings;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int canvasHeight = getSize().height;
		int canvasWidth = getSize().width;

		double paddingRatio = 0.1;
		int padding = (int) Math.min(canvasHeight * paddingRatio, canvasWidth
				* paddingRatio);
		int allowedHeight = canvasHeight - 2 * padding;
		int allowedWidth = canvasWidth - 2 * padding;

		double ringDotRatio = 1.0 / 20.0;
		double angleUnit = 2 * Math.PI / 19.0;
		double factorHeight = 2.0 * (1 + ringDotRatio);
		double factorWidth = 2.0 * (1 + ringDotRatio + Math
				.cos(2.5 * angleUnit));
		int revisedWidth = (int) (allowedHeight / factorHeight * factorWidth);
		int revisedHeight = (int) (allowedWidth / factorWidth * factorHeight);

		int ringRadius;
		int dotRadius;
		int xLeft;
		if (revisedHeight > allowedHeight) {
			ringRadius = (int) (allowedHeight / factorHeight);
			dotRadius = (int) (ringRadius * ringDotRatio);
			xLeft = padding + (allowedWidth - revisedWidth) / 2 + dotRadius
					+ ringRadius;
		} else {
			ringRadius = (int) (revisedHeight / factorHeight);
			dotRadius = (int) (ringRadius * ringDotRatio);
			xLeft = padding + dotRadius + ringRadius;
		}

		int xRight = (int) (xLeft + 2 * ringRadius * Math.cos(2.5 * angleUnit));
		int yMiddle = canvasHeight / 2;

		double angle = -2.5 * angleUnit;
		for (int index = 0; index < 19; index++) {
			int x = (int) (xLeft + ringRadius * Math.cos(angle));
			int y = (int) (yMiddle + ringRadius * Math.sin(angle));
			prepareColor(g, rings.getColor(Ring.LEFT, index));
			drawDot(g, x, y, dotRadius);
			angle += angleUnit;
		}

		angle = 12 * angleUnit;
		for (int index = 0; index < 19; index++) {
			int x = (int) (xRight + ringRadius * Math.cos(angle));
			int y = (int) (yMiddle + ringRadius * Math.sin(angle));
			prepareColor(g, rings.getColor(Ring.RIGHT, index));
			drawDot(g, x, y, dotRadius);
			angle -= angleUnit;
		}
	}

	private void prepareColor(Graphics g, game.Color color) {
		if (color == game.Color.BLUE) {
			g.setColor(Color.BLUE);
		} else if (color == game.Color.GREEN) {
			g.setColor(Color.GREEN);
		} else if (color == game.Color.PURPLE) {
			g.setColor(Color.PINK);
		} else if (color == game.Color.RED) {
			g.setColor(Color.RED);
		} else {
			throw new IllegalArgumentException("Unmanaged color: " + color);
		}
	}

	private void drawDot(Graphics g, int x, int y, int radius) {
		g.fillOval(x - radius, getSize().height - (y - radius), 2 * radius, 2 * radius);
	}
}
