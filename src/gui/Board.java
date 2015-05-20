package gui;

import game.Rings;
import game.Rings.Direction;
import game.Rings.Ring;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JFrame {

	private final Canvas canvas;

	public Board() {
		final Rings rings = new Rings();
		canvas = new Canvas(rings);

		setTitle("Hungarian Rings AI");
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0;
		constraints.weighty = 0.5;

		constraints.gridx = 0;
		constraints.gridy = 0;
		add(new JButton(new AbstractAction("^") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rings.turn(Ring.LEFT, Direction.CLOCK);
				updateCanvas();
			}
		}), constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(new JButton(new AbstractAction("v") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rings.turn(Ring.LEFT, Direction.REVERSE_CLOCK);
				updateCanvas();
			}
		}), constraints);
		constraints.gridx = 2;
		constraints.gridy = 0;
		add(new JButton(new AbstractAction("^") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rings.turn(Ring.RIGHT, Direction.REVERSE_CLOCK);
				updateCanvas();
			}
		}), constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		add(new JButton(new AbstractAction("v") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rings.turn(Ring.RIGHT, Direction.CLOCK);
				updateCanvas();
			}
		}), constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 0;
		constraints.gridheight = 2;
		add(canvas, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.weighty = 0;
		constraints.gridheight = 0;
		constraints.gridwidth = 3;
		add(createMenuPanel(rings), constraints);
		
		pack();
		updateCanvas();
	}

	private JPanel createMenuPanel(final Rings rings) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(new JButton(new AbstractAction("Shuffle") {

			private final Random rand = new Random();

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 1000; i++) {
					Ring ring = Ring.values()[rand.nextInt(Ring.values().length)];
					Direction direction = Direction.values()[rand
							.nextInt(Direction.values().length)];
					rings.turn(ring, direction);
				}
				updateCanvas();
			}
		}));
		panel.add(new JButton(new AbstractAction("Reset") {

			@Override
			public void actionPerformed(ActionEvent e) {
				rings.reset();
				updateCanvas();
			}
		}));
		return panel;
	}

	protected void updateCanvas() {
		canvas.repaint();
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				new Board().setVisible(true);
			}
		}).run();
	}
}
