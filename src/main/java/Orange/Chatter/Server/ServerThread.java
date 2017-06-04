package Orange.Chatter.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ServerThread extends Thread {
	private Scanner is;
	private PrintStream _os;
	private String _line;
	private BroadCaster _bcaster;
	private ClientUser _clientUser;

	public ServerThread(ClientUser user, BroadCaster bcaster) {
		_clientUser = user;
		_bcaster = bcaster;

		try {
			is = new Scanner(_clientUser.getSocket().getInputStream());
			_os = new PrintStream(_clientUser.getSocket().getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		_os.print("Welcome " + _clientUser.getUniqueIdentifier() + "!\n");
	}

	public void run() {

		while (true) {
			if (is.hasNext()) {
				_line = is.nextLine();
				_bcaster.broadCast(_clientUser, _line);
				System.out.println(_clientUser.getUniqueIdentifier() + ": " +_line);
			}
		}
	}
}
