package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class LilianShape extends Shape {

	private final Point firstPoint;
	private Point secondPoint;
	private Point thirdPoint;
	private Point fourthPoint;
	private Point fifthPoint;

	public LilianShape(Color color, Point firstPoint) {
		super(color);
		this.firstPoint = firstPoint;
	}

	public void addPoint(Point point) {
		if (secondPoint == null) {
			this.secondPoint = point;
		} else if(thirdPoint == null) {
			this.thirdPoint = point;
		} else if(fourthPoint == null) {
			this.fourthPoint = point;
		} else if(fifthPoint == null) {
			this.fifthPoint = point;
		}
	}

	public boolean isComplete() {
		return fifthPoint != null;
	}

	@Override
	public void draw(Graphics2D g) {
		if (secondPoint != null && thirdPoint != null && fourthPoint != null && fifthPoint != null) {
			g.setColor(getColor());
			g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
			g.drawLine(secondPoint.x, secondPoint.y, thirdPoint.x, thirdPoint.y);
			g.drawLine(thirdPoint.x, thirdPoint.y, fourthPoint.x, fourthPoint.y);
			g.drawLine(fourthPoint.x, fourthPoint.y, fifthPoint.x, fifthPoint.y);
			g.drawLine(fifthPoint.x, fifthPoint.y, firstPoint.x, firstPoint.y);
		}

	}

}
