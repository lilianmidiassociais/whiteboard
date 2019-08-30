package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Rectangle extends Shape {

	private final Point firstPoint;
	private Point lastPoint;

	public Rectangle(Color color, Point firstPoint) {
		super(color);
		this.firstPoint = firstPoint;
	}

	public void setEnd(Point point) {
		lastPoint = point;
	}

	@Override
	public void draw(Graphics2D g) {
		if (lastPoint != null) {
			g.setColor(getColor());
			final Point leftCorner = new Point(Math.min(firstPoint.x,
					lastPoint.x), Math.min(firstPoint.y, lastPoint.y));

			g.drawRect(leftCorner.x, leftCorner.y,
					Math.abs(firstPoint.x - lastPoint.x),
					Math.abs(firstPoint.y - lastPoint.y));
		}

	}

}
