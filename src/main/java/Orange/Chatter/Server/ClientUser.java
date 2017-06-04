package Orange.Chatter.Server;

import java.net.Socket;

public class ClientUser {

	private int _id;
	private String _name;
	private Socket _clientSocket;

	public ClientUser(Socket clientSocket) {
		_name = "Client_";
		_clientSocket = clientSocket;
	}

	public Socket getSocket() {
		return _clientSocket;
	}

	public String getName() {
		return _name;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getUniqueIdentifier() {
		return _name + _id;
	}

	public int getId() {
		return _id;
	}

}
