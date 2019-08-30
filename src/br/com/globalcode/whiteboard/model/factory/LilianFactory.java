package br.com.globalcode.whiteboard.model.factory;

import java.awt.Color;
import java.awt.event.MouseEvent;

import br.com.globalcode.whiteboard.model.LilianShape;

public final class LilianFactory extends ShapeFactory {

	private LilianShape lilianShape;

	public LilianFactory(Color color) {
		super(color);
	}

	@Override
	public LilianShape getShape() {
		return lilianShape;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (lilianShape == null || lilianShape.isComplete()) {
			lilianShape = new LilianShape(getColor(), e.getPoint());
		} else {
			lilianShape.addPoint(e.getPoint());
		}

	}

	@Override
	public String getName() {
		return "Lilian Shape";
	}

}
