package Orange.Chatter.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private BroadCaster _bcaster;
	private ClientManager _clientman;
	private Socket clientSocket = null;
	private ServerSocket _echoServer = null;

	public Server() {
		_clientman = new ClientManager();
		_bcaster = new BroadCaster(_clientman);
	}

	public void start() {
		try {
			_echoServer = new ServerSocket(2222);

		} catch (IOException e) {
			System.out.println(e);
		}
		System.out
				.println("The server has started. Waiting for incoming connections. " + "To stop it press <CTRL><C>.");

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
		ClientUser user = new ClientUser(clientSocket);
		user.setId(_clientman.generateId());
		_clientman.addClient(user, _bcaster);
		new ServerThread(user, _bcaster).start();
	}
}
