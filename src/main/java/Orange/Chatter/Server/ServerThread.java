package Orange.Chatter.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	private Socket _clientSocket;
	private Scanner is;
	private PrintStream _os;
	private String _line;
	private final String _id;
	private BroadCaster _bcaster;

	public ServerThread(Socket clientSocket, String id, BroadCaster bcaster) {
		_clientSocket = clientSocket;
		_id = id;
		_bcaster = bcaster;

		try {
			is = new Scanner(_clientSocket.getInputStream());
			_os = new PrintStream(_clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		_os.print("Welcome " + _id + "!\n");
	}

	public void run() {

		while (true) {
			if (is.hasNext()) {
				_line = is.nextLine();
				_bcaster.broadCast(_line);;
				_os.println("From server: " + _line);
				System.out.println(_line);
			}
		}
	}
}
