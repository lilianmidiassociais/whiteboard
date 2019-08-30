package br.com.globalcode.whiteboard.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Shape implements Serializable {

	private final Color color;

	Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public abstract void draw(Graphics2D g);

}
