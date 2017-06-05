package Orange.Chatter.Client;

import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Orange.Chatter.Gui.ChatterGui;

public class Client {

	private Socket _clientSocket = null;
	private ChatterGui _chattergui;
	private StyledDocument _doc;

	public Client(ChatterGui chattergui) {
		_chattergui = chattergui;
		_doc = _chattergui.get_doc();
		connect("vingu.online", 25552);

	}

	public void connect(String host, int port) {
		System.out.println("Connecting");
		try {
			printToDisplay("Trying to connect to '" + host + "' on port " + port, "system");
			printToDisplay("> Please wait...", "system");
			_clientSocket = new Socket(host, port);
			printToDisplay("> Connected!", "system");

		} catch (UnknownHostException e) {
			printToDisplay("Host couldn't be found " + host, "system");
		} catch (IOException e) {
			e.printStackTrace();
			printToDisplay("Couldn't get I/O for the connection to the host " + host, "system");
		}

		if (_clientSocket != null) {
			new ClientListenerThread(_clientSocket, this).start();
			new ClientWriter(_clientSocket, this);
		}
	}

	public void printToDisplay(String text, String target) {
		System.out.println(text);

		SimpleAttributeSet keyWord = new SimpleAttributeSet();

		if (target.equals("system")) {
			StyleConstants.setForeground(keyWord, new Color(0, 153, 51));
			StyleConstants.setBold(keyWord, true);
		} else if (target.equals("server")) {
			StyleConstants.setForeground(keyWord, new Color(0, 102, 255));
			StyleConstants.setBold(keyWord, true);
		} else {
			StyleConstants.setForeground(keyWord, Color.GREEN);
		}

		try

		{
			_doc.insertString(_doc.getLength(), text.trim() + "\n", keyWord);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public ChatterGui getChatterGui() {

		return _chattergui;
	}

}