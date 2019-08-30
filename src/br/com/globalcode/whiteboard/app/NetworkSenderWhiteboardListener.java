package br.com.globalcode.whiteboard.app;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.globalcode.whiteboard.model.Shape;

public class NetworkSenderWhiteboardListener implements WhiteboardListener {

	@Override
	public void addShape(Shape shape) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8070);
		ObjectOutputStream oOS = new ObjectOutputStream(
				socket.getOutputStream());
		oOS.writeObject(shape);
		socket.close();
	}

}
