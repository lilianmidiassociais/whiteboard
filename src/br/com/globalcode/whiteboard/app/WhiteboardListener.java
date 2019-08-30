package br.com.globalcode.whiteboard.app;

import java.io.IOException;

import br.com.globalcode.whiteboard.model.Shape;

public interface WhiteboardListener {

	void addShape(Shape shape) throws IOException;

}
