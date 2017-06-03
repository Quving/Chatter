package Orange.Chatter.Server;

import java.io.IOException;
import java.io.PrintStream;

public class BroadCaster {

	private ClientManager _clientman;

	public BroadCaster(ClientManager clientman) {
		_clientman = clientman;
	}

	public void broadCast(String message) {
		PrintStream _os = null;
		for (ClientUser cuser : _clientman.getAllUsers()) {
			try {
				_os = new PrintStream(cuser.getSocket().getOutputStream());
				_os.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
