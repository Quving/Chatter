package Orange.Chatter.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import Orange.Chatter.Gui.ChatterGui;

public class Client {

	private Socket _clientSocket = null;
	private ChatterGui _chattergui;
	private JTextArea _display;

	public Client(ChatterGui chattergui) {
		_chattergui = chattergui;
		_display = _chattergui.get_display();
		this.connect("vingu.online", 25552);

	}

	public void connect(String host, int port) {
		try {
			printToDisplay("Trying to connect to '" + host + "' on port:" + port);
			printToDisplay("> Please wait...");
			_clientSocket = new Socket(host, port);
			printToDisplay("> Connected!");

		} catch (UnknownHostException e) {
			printToDisplay("Host could'nt be found " + host);
		} catch (IOException e) {
			e.printStackTrace();
			printToDisplay("Couldn't get I/O for the connection to the host " + host);
		}

		if (_clientSocket != null) {
			new ClientListenerThread(_clientSocket, this).start();
			new ClientWriter(_clientSocket, this);
		}
	}

	public void printToDisplay(String text) {
		_display.append(text.trim() + "\n");
	}

	public ChatterGui getChatterGui() {
		return _chattergui;
	}

}