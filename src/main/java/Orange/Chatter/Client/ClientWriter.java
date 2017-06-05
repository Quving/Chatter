package Orange.Chatter.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import Orange.Chatter.Gui.ChatterGui;

public class ClientWriter {
	private Socket _clientSocket;
	private PrintStream _os;
	private BufferedReader _input;
	private ChatterGui _chattergui;

	public ClientWriter(Socket clientSocket, Client client) {
		_clientSocket = clientSocket;
		_chattergui = client.getChatterGui();

		_chattergui.get_send().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientWriter.this.sendToServer();
			}
		});

		try {
			_os = new PrintStream(_clientSocket.getOutputStream());
			_input = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server Writer started.");
	}

	protected void sendToServer() {
		String text = _chattergui.get_chatfield().getText().trim();
		_os.println(text);
	}
}
