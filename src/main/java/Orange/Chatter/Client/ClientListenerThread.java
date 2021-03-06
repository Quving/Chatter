package Orange.Chatter.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ClientListenerThread extends Thread {
	private Scanner _is;
	private Client _client;
	private Socket _clientSocket;

	public ClientListenerThread(Socket clientSocket, Client client) {
		_client = client;
		_clientSocket = clientSocket;

		try {
			_is = new Scanner(_clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server listener started.");
	}

	public void run() {
		String responseLine;
		while (true)
			if (_is.hasNextLine()) {
				responseLine = _is.nextLine();
				_client.printToDisplay(responseLine, "server");

				if (responseLine.indexOf("*** Bye") != -1)
					break;
			}
	}
}
