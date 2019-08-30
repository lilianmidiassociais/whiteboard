package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.Line;

public final class LineFactory extends ShapeFactory {

	private Line currentLine;

	public LineFactory(Color color) {
		super(color);
	}

	@Override
	public Line getShape() {
		return currentLine;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentLine = new Line(getColor(), e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentLine.setEnd(e.getPoint());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentLine.setEnd(e.getPoint());
	}

	@Override
	public String getName() {
		return "Line";
	}

}
