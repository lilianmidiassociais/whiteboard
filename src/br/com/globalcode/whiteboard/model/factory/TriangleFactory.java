package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.Triangle;

public final class TriangleFactory extends ShapeFactory {

	private Triangle currentTriangle;

	public TriangleFactory(Color color) {
		super(color);
	}

	@Override
	public Triangle getShape() {
		return currentTriangle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (currentTriangle == null || currentTriangle.isComplete()) {
			currentTriangle = new Triangle(getColor(), e.getPoint());
		} else {
			currentTriangle.addPoint(e.getPoint());
		}

	}

	@Override
	public String getName() {
		return "Triangle";
	}

}
