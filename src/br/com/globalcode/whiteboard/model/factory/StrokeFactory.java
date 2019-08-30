package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.Stroke;

public final class StrokeFactory extends ShapeFactory {

	private Stroke currentStroke;

	public StrokeFactory(Color color) {
		super(color);
	}

	@Override
	public Stroke getShape() {
		return currentStroke;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentStroke = new Stroke(getColor());
		currentStroke.addPoint(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentStroke.addPoint(e.getPoint());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentStroke.addPoint(e.getPoint());
	}

	@Override
	public String getName() {
		return "Stroke";
	}

}
