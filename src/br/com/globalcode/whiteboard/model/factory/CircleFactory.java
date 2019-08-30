package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.Circle;

public final class CircleFactory extends ShapeFactory {

	public CircleFactory(Color color) {
		super(color);
	}

	private Circle currentCircle;

	@Override
	public Circle getShape() {
		return currentCircle;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentCircle = new Circle(getColor(), e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentCircle.setEnd(e.getPoint());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentCircle.setEnd(e.getPoint());
	}

	@Override
	public String getName() {
		return "Circle";
	}

}
