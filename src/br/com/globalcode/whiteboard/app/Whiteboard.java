package br.com.globalcode.whiteboard.app;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import br.com.globalcode.whiteboard.model.Shape;
import br.com.globalcode.whiteboard.model.factory.ShapeFactory;

public class Whiteboard extends JPanel implements MouseMotionListener,
		MouseListener {

	private static final long serialVersionUID = -35851911903727854L;

	private final Set<Shape> shapes = new HashSet<Shape>();

	private final WhiteboardListener whiteboardListener;

	// propriedade mutável - Permite modificar a shape a ser construída
	private ShapeFactory shapeFactory;

	public Whiteboard(final ShapeFactory shapeFactory,
			final WhiteboardListener whiteboardListener) {
		setShapeFactory(shapeFactory);

		// É necessário ouvir os eventos para adicionar o shape corrente a essa
		// whiteboard
		// E redesenhar a tela toda a medida que o mouse é arrastado
		addMouseListener(this);
		addMouseMotionListener(this);
		this.whiteboardListener = whiteboardListener;
	}

	public void setShapeFactory(ShapeFactory shapeFactory) {
		// Remove a fábrica anterior como ouvinte
		removeMouseListener(this.shapeFactory);
		removeMouseMotionListener(this.shapeFactory);

		// Adiciona a nova fábrica como ouvinte
		addMouseListener(shapeFactory);
		addMouseMotionListener(shapeFactory);

		// Armazena a fábrica corrente para obter o shape ao término da sua
		// construção
		this.shapeFactory = shapeFactory;
	}

	public void addShape(Shape shape) {
		this.shapes.add(shape);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Redesenha as shapes previamente adicionadas
		for (Shape shape : shapes) {
			shape.draw((Graphics2D) g);
		}

		// Desenha a shape em construção
		final Shape currentShape = shapeFactory.getShape();
		if (currentShape != null) {
			currentShape.draw((Graphics2D) g);
		}
	}

	/**
	 * Adiciona o currentShape ao conjunto de shapes dessa whiteboard
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		final Shape currentShape = shapeFactory.getShape();
		if (currentShape != null) {
			shapes.add(currentShape);
			try {
				whiteboardListener.addShape(currentShape);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	/**
	 * Repinta o painel durante a construção de uma Shape.
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
