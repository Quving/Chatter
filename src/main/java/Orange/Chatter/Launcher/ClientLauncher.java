package Orange.Chatter.Launcher;

import Orange.Chatter.Client.Client;
import Orange.Chatter.Gui.ChatterGui;
import Orange.Chatter.Gui.ChatterGuiController;

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
		ChatterGuiController guiController = new ChatterGuiController(chatterGui);
		Client client;

	}
}
