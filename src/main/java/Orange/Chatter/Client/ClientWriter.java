package Orange.Chatter.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import Orange.Chatter.Gui.ChatterGui;

public class ClientWriter {
	private Socket _clientSocket;
	private PrintStream _os;
	private ChatterGui _chattergui;

	public ClientWriter(Socket clientSocket, Client client) {
		_clientSocket = clientSocket;
		_chattergui = client.getChatterGui();

		_chattergui.get_send().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientWriter.this.sendToServer();
			}
		});

		_chattergui.get_chatfield().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ClientWriter.this.sendToServer();
			}
		});

		try {
			_os = new PrintStream(_clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server Writer started.");
	}

	private void sendToServer() {
		String text = _chattergui.get_chatfield().getText().trim();
		_os.println(text);

		// Clear
		_chattergui.get_chatfield().setText("");
	}
}
