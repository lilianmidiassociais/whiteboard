package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Circle extends Shape {

	private Point center;
	private int radius;

	public Circle(Color color, Point center) {
		super(color);
		this.center = center;
	}

	public void setEnd(Point point) {
		radius = (int) Math.round(Math.sqrt(Math.pow(center.x - point.x, 2)
				+ Math.pow(center.y - point.y, 2)));
	}

	@Override
	public void draw(Graphics2D g) {
		if (radius != 0) {
			g.setColor(getColor());
			final int x = center.x - radius;
			final int y = center.y - radius;
			final int diameter = 2 * radius;

			g.drawOval(x, y, diameter, diameter);
		}
	}
}
