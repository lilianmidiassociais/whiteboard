package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Line extends Shape {

	private final Point start;
	private Point end;

	public Line(Color color, Point start) {
		super(color);
		this.start = start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
	public void draw(Graphics2D g) {
		if (end != null) {
			g.setColor(getColor());
			g.drawLine(start.x, start.y, end.x, end.y);
		}
	}
}
