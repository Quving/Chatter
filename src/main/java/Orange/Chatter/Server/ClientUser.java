package Orange.Chatter.Server;

import java.net.Socket;

public class ClientUser {

	private Socket _clientSocket;
	private String _id;

	public ClientUser(String id, Socket clientSocket) {
		_clientSocket = clientSocket;
	}

	public Socket getSocket() {
		return _clientSocket;
	}

	public String getId() {
		return _id;
	}

}
