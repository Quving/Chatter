package Orange.Chatter.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private int _port;
	private String _host;
	private Scanner _is = null;
	private PrintStream _os = null;
	private boolean _closed = false;
	private Socket _clientSocket = null;
	private BufferedReader _inputLine = null;

	public Client(String host, int port) {

		_host = host;
		_port = port;

	}

	public void connect() {
		try {
			System.out.println("Trying to connect. Host: " + _host + "Port:" + _port);
			System.out.println("Please wait...");

			_clientSocket = new Socket(_host, _port);

			System.out.println("Connected!");

		} catch (UnknownHostException e) {
			System.err.println("Host could'nt be found " + _host);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't get I/O for the connection to the host " + _host);
		}

		if (_clientSocket != null) {
			new ClientListenerThread(_clientSocket).start();
			new ClientWriterThread(_clientSocket).start();

		}
	}

}