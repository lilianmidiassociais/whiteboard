package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Triangle extends Shape {

	private final Point firstPoint;
	private Point secondPoint;
	private Point thirdPoint;

	public Triangle(Color color, Point firstPoint) {
		super(color);
		this.firstPoint = firstPoint;
	}

	public void addPoint(Point point) {
		if (secondPoint == null) {
			secondPoint = point;
		} else {
			thirdPoint = point;
		}
	}

	public boolean isComplete() {
		return thirdPoint != null;
	}

	@Override
	public void draw(Graphics2D g) {
		if (secondPoint != null && thirdPoint != null) {
			g.setColor(getColor());
			g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
			g.drawLine(secondPoint.x, secondPoint.y, thirdPoint.x, thirdPoint.y);
			g.drawLine(thirdPoint.x, thirdPoint.y, firstPoint.x, firstPoint.y);
		}

	}

}
