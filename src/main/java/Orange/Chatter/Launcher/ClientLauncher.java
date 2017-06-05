package Orange.Chatter.Launcher;

import Orange.Chatter.Client.Client;
import Orange.Chatter.Gui.ChatterGui;

public class ClientLauncher {

	public static void main(String[] args) {
		// Client client;
		// if (args.length == 2) {
		// client = new Client(args[0], Integer.parseInt(args[1]));
		//
		// } else {
		// client = new Client("vingu.online", 25552);
		// }
		// client.connect();

		ChatterGui chatterGui = new ChatterGui();
		Client client = new Client(chatterGui);

	}
}
