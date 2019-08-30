package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.Rectangle;

public final class RectangleFactory extends ShapeFactory {

	private Rectangle currentRectangle;

	public RectangleFactory(Color color) {
		super(color);
	}

	@Override
	public Rectangle getShape() {
		return currentRectangle;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentRectangle = new Rectangle(getColor(), e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentRectangle.setEnd(e.getPoint());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentRectangle.setEnd(e.getPoint());
	}

	@Override
	public String getName() {
		return "Rectangle";
	}

}
