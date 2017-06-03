package Orange.Chatter.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Orange.Chatter.IdGen;

public class Server {

	private ServerSocket _echoServer = null;
	private Socket clientSocket = null;
	private IdGen _idgen;
	private BroadCaster _bcaster;
	private ClientManager _clientman;

	public Server() {
		_idgen = new IdGen();
		_clientman = new ClientManager();
		_bcaster = new BroadCaster(_clientman);
	}

	public void start() {
		try {
			_echoServer = new ServerSocket(2222);

		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("The server has started. Waiting for incoming connections. "
				+ "To stop it press <CTRL><C>.");

		while (true) {
			try {
				clientSocket = _echoServer.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			registerChatClient();
		}
	}

	public void registerChatClient() {
		ClientUser user = new ClientUser("Client_" + _idgen.getId(), clientSocket);
		_clientman.addClient(user);
		new ServerThread(user, "Client_" + _idgen.getId(), _bcaster).start();
	}
}
