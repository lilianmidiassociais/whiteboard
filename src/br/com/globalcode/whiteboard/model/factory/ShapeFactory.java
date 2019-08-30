package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import br.com.globalcode.whiteboard.model.Shape;

public abstract class ShapeFactory extends MouseAdapter {

	private Color currentColor;

	ShapeFactory(Color color) {
		this.currentColor = color;
	}

	public final void setCurrentColor(Color color) {
		this.currentColor = color;
	}

	public final Color getColor() {
		return currentColor;
	}

	public abstract Shape getShape();

	public abstract String getName();

	public final String toString() {
		return getName();
	}
}
