package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class Stroke extends Shape {

	private List<Point> points = new ArrayList<Point>();

	public Stroke(Color color) {
		super(color);
	}

	public void addPoint(Point point) {
		points.add(point);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());

		Point previousPoint = null;
		for (Point currentPoint : points) {
			if (previousPoint != null) {
				g.drawLine(previousPoint.x, previousPoint.y, currentPoint.x,
						currentPoint.y);
			}
			previousPoint = currentPoint;
		}
	}

}
