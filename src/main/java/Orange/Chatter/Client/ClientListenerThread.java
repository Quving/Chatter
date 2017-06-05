package Orange.Chatter.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import Orange.Chatter.Gui.ChatterGuiController;

public class ClientListenerThread extends Thread {
	private Socket _clientSocket;
	private Scanner _is;
	private ChatterGuiController _chatterguicontroller;

	public ClientListenerThread(Socket clientSocket, ChatterGuiController chatterguicontroller) {
		_clientSocket = clientSocket;
		_chatterguicontroller = chatterguicontroller;

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
				System.out.println(responseLine);

				if (responseLine.indexOf("*** Bye") != -1)
					break;
			}
	}
}
