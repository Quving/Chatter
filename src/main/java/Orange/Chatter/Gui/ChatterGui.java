package Orange.Chatter.Gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledDocument;

public class ChatterGui {
	private JFrame _frame;
	private JPanel _panel;
	private JButton _send;
	private JTextPane _display;
	private JTextField _chatfield;
	private JScrollPane _scrollpane;
	private StyledDocument _doc;

	public ChatterGui() {
		_frame = new JFrame("ChatterClient");
		_frame.setSize(new Dimension(480, 400));
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_panel = new JPanel(new GridBagLayout());
		_panel.setBorder(new TitledBorder(new EtchedBorder(), "Console"));

		GridBagConstraints c = new GridBagConstraints();

		_frame.add(_panel);

		// TextPane to show log.
		_display = new JTextPane();
		_display.setEditable(false);
		_display.setPreferredSize(_frame.getSize());
		_doc = _display.getStyledDocument();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;

		// ScrollPanel
		_scrollpane = new JScrollPane(_display);
		_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		_panel.add(_scrollpane, c);

		// Chatfield
		_chatfield = new JTextField();
		_chatfield.requestFocusInWindow();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		_panel.add(_chatfield, c);

		// Send Button
		_send = new JButton("send");
		c.gridx = 1;
		c.gridy = 1;
		_panel.add(_send, c);

		// Display the window.
		_frame.pack();
		_frame.setVisible(true);
	}

	public JFrame get_frame() {
		return _frame;
	}

	public JPanel get_panel() {
		return _panel;
	}

	public JButton get_send() {
		return _send;
	}

	public JTextPane get_display() {
		return _display;
	}

	public JTextField get_chatfield() {
		return _chatfield;
	}

	public JScrollPane get_scrollpane() {
		return _scrollpane;
	}

	public StyledDocument get_doc() {
		return _doc;
	}
}