package Orange.Chatter.Launcher;

import Orange.Chatter.Client.Client;
import Orange.Chatter.Gui.ChatterGui;

public class ClientLauncher {

	public static void main(String[] args) {
		ChatterGui chatterGui = new ChatterGui();
		Client client = new Client(chatterGui);
	}
}
