package Orange.Chatter.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Orange.Chatter.Client.Client;
import Orange.Chatter.Gui.ChatterGui.ChatterGuiLoginPanel;

public class Connect {
	private Client _client;
	ChatterGuiLoginPanel _panel;

	public Connect(Client client) {
		_client = client;
		_panel = _client.getChatterGui().get_chatterlogingui();

		// Default
		_panel._textfieldhost.setText("vingu.online");
		_panel._textfieldnick.setText("WandKlatscher69");
		_panel._textfieldport.setText("25552");

		_panel._buttonconnect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Connect");
				Connect.this.connect();
			}
		});
	}

	public void connect() {
		String host = _panel._textfieldhost.getText().trim();
		int port = Integer.parseInt(_panel._textfieldport.getText().trim());
		String nick = _panel._textfieldnick.getText().trim();
		nick.trim();
		JFrame frame = _client.getChatterGui().get_frame();
		frame.remove(_panel);
		frame.add(_client.getChatterGui().get_chattergui());
		frame.setVisible(true);
		_client.connect(host, port);

	}
}
