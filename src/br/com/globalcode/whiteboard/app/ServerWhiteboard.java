package br.com.globalcode.whiteboard.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.globalcode.whiteboard.model.Shape;

public class ServerWhiteboard {

	public ServerWhiteboard(final Whiteboard whiteboard) throws IOException,
			ClassNotFoundException {
		final ServerSocket serverSocket = new ServerSocket(8070);

		final Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					Socket socket;
					try {
						socket = serverSocket.accept();
						ObjectInputStream oIS = new ObjectInputStream(
								socket.getInputStream());
						Shape shape = (Shape) oIS.readObject();
						whiteboard.addShape(shape);
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				}
			}
		}, "ServerWhiteboard");

		thread.setDaemon(true);
		thread.start();
	}
}
