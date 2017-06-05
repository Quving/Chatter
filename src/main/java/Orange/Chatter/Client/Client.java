package Orange.Chatter.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import Orange.Chatter.Gui.ChatterGuiController;

public class Client {

	private Socket _clientSocket = null;
	private ChatterGuiController _chatterguicontroller;

	public Client(ChatterGuiController chatterguicontroller) {
		_chatterguicontroller = chatterguicontroller;
	}

	public void connect(String host, int port) {
		try {
			System.out.println("Trying to connect. Host: " + host + "Port:" + port);
			System.out.println("> Please wait...");

			_clientSocket = new Socket(host, port);

			System.out.println("> Connected!");

		} catch (UnknownHostException e) {
			System.err.println("Host could'nt be found " + host);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't get I/O for the connection to the host " + host);
		}

		if (_clientSocket != null) {
			new ClientListenerThread(_clientSocket, _chatterguicontroller).start();
			new ClientWriterThread(_clientSocket, _chatterguicontroller).start();
		}
	}
}