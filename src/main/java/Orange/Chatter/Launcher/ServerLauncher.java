package Orange.Chatter.Launcher;

import Orange.Chatter.Server.Server;

public class ServerLauncher {

	public static void main(String args[]) {
		Server server = new Server();
		server.start();
	}
}
