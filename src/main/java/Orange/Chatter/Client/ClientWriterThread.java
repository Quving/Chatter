package Orange.Chatter.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientWriterThread extends Thread {
	private Socket _clientSocket;
	private PrintStream _os;
	private BufferedReader _input;

	public ClientWriterThread(Socket clientSocket) {
		_clientSocket = clientSocket;

		try {
			_os = new PrintStream(_clientSocket.getOutputStream());
			_input = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server Writer started.");
	}

	public void run() {
		while (true) {
			try {
				String _line = _input.readLine();
				_os.println(_line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
