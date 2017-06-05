package Orange.Chatter.Server;

import java.util.Set;

public class ClientStatusChecker extends Thread {

	private Server _server;
	private ClientManager _clientman;
	private BroadCaster _bcaster;

	public ClientStatusChecker(Server server) {
		_server = server;
		_clientman = _server.get_clientman();
		_bcaster = _server.get_bcaster();
	}

	public void run() {
		while (true) {
			System.out.println(_clientman.getAllUsers().size());
			Set<ClientUser> list = _clientman.getAllUsers();
			for (ClientUser cuser : list) {
				System.out.println("Check status for " + cuser.getUniqueIdentifier());
				if (!cuser.getSocket().isConnected()) {
					_clientman.removeClientUser(cuser, _bcaster);
				} else {
					// Display. Todo.
				}
			}
			// Sleep to be able to synchronize.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
