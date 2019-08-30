package br.com.globalcode.whiteboard.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import br.com.globalcode.whiteboard.model.factory.CircleFactory;
import br.com.globalcode.whiteboard.model.factory.LilianFactory;
import br.com.globalcode.whiteboard.model.factory.LineFactory;
import br.com.globalcode.whiteboard.model.factory.RectangleFactory;
import br.com.globalcode.whiteboard.model.factory.ShapeFactory;
import br.com.globalcode.whiteboard.model.factory.StrokeFactory;
import br.com.globalcode.whiteboard.model.factory.TriangleFactory;

/**
 * @author limae
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() throws UnknownHostException, IOException, ClassNotFoundException {
		super("Whiteboard");

		// Determina as cores disponíveis
		final List<Color> colors = Arrays.asList(Color.RED, Color.GREEN,
				Color.BLUE);
		final Color initialColor = colors.get(0);

		// Determina as fábricas de shapes disponíveis
		final List<ShapeFactory> shapeFactories = Arrays.<ShapeFactory> asList(
				new LineFactory(initialColor), new RectangleFactory(
						initialColor), new CircleFactory(initialColor),
				new StrokeFactory(initialColor), new TriangleFactory(
						initialColor), new LilianFactory(initialColor));

		// Painel onde as shapes serão desenhadas
		final Whiteboard whiteboard = new Whiteboard(shapeFactories.get(0),
				new NetworkSenderWhiteboardListener());

		new ServerWhiteboard(whiteboard);

		// Combo para seleção da shape que se deseja construir
		final JComboBox shapeFactoriesCombo = new JComboBox(
				shapeFactories.toArray());

		// Combo para seleção da cor da shape que se deseja construir
		final JComboBox colorCombo = new JComboBox(colors.toArray());

		// Criação de um classe anônima para responder eventos sobre o comboBox
		// de fábricas de shapes
		shapeFactoriesCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				final ShapeFactory shapeFactory = (ShapeFactory) shapeFactoriesCombo
						.getSelectedItem();
				final Color color = (Color) colorCombo.getSelectedItem();
				shapeFactory.setCurrentColor(color);
				whiteboard.setShapeFactory(shapeFactory);
			}
		});

		// Criação de um classe anônima para responder eventos sobre o comboBox
		// de cores
		colorCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				final ShapeFactory shapeFactory = (ShapeFactory) shapeFactoriesCombo
						.getSelectedItem();
				final Color color = (Color) colorCombo.getSelectedItem();
				shapeFactory.setCurrentColor(color);
			}
		});

		add(colorCombo, BorderLayout.NORTH);
		add(whiteboard, BorderLayout.CENTER);
		add(shapeFactoriesCombo, BorderLayout.SOUTH);

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException, ClassNotFoundException {
		new MainFrame();
	}

}
