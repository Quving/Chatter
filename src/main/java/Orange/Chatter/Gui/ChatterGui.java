package Orange.Chatter.Gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private ChatterGuiPanel _chattergui;
	private ChatterGuiLoginPanel _chatterguilogin;

	public JFrame get_framei() {
		return _frame;
	}

	public ChatterGuiPanel get_chattergui() {
		return _chattergui;
	}

	public ChatterGuiLoginPanel get_chatterlogingui() {
		return _chatterguilogin;
	}

	public ChatterGui() {
		_frame = new JFrame("ChatterClient");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_chatterguilogin = new ChatterGuiLoginPanel();
		_chattergui = new ChatterGuiPanel();

		// Display the window.
		_frame.add(_chatterguilogin);
		_frame.pack();
		_frame.setVisible(true);
	}

	public class ChatterGuiLoginPanel extends JPanel {
		private static final long serialVersionUID = 720242964431427642L;
		private JLabel _labelhost;
		private JLabel _labelport;
		public JTextField _textfieldhost;
		public JTextField _textfieldport;
		private JLabel _labelnick;
		public JTextField _textfieldnick;
		public JButton _buttonconnect;

		public ChatterGuiLoginPanel() {
			ChatterGuiLoginPanel.this.setPreferredSize(new Dimension(480, 400));

			ChatterGuiLoginPanel.this.setLayout(new GridBagLayout());
			ChatterGuiLoginPanel.this.setBorder(new TitledBorder(new EtchedBorder(), "Connect"));
			GridBagConstraints c = new GridBagConstraints();

			// Host
			_labelhost = new JLabel("Host");
			c.insets = new Insets(0, 5, 0, 0);
			c.gridx = 0;
			c.gridy = 0;
			ChatterGuiLoginPanel.this.add(_labelhost, c);

			_textfieldhost = new JTextField(16);
			c.gridx = 1;
			ChatterGuiLoginPanel.this.add(_textfieldhost, c);

			// Port
			_labelport = new JLabel("Port");
			c.gridx = 0;
			c.gridy = 1;
			ChatterGuiLoginPanel.this.add(_labelport, c);

			_textfieldport = new JTextField(16);
			c.gridx = 1;

			ChatterGuiLoginPanel.this.add(_textfieldport, c);

			// Nick
			_labelnick = new JLabel("Nick");
			c.gridx = 0;
			c.gridy = 2;
			ChatterGuiLoginPanel.this.add(_labelnick, c);

			_textfieldnick = new JTextField(16);
			c.gridx = 1;
			ChatterGuiLoginPanel.this.add(_textfieldnick, c);

			// Connect
			_buttonconnect = new JButton("Connect");
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 3;
			ChatterGuiLoginPanel.this.add(_buttonconnect, c);

		}
	}

	public class ChatterGuiPanel extends JPanel {
		private static final long serialVersionUID = 7891211880023668546L;
		public JButton _send;
		public JTextPane _display;
		public JTextField _chatfield;
		public JScrollPane _scrollpane;
		public StyledDocument _doc;

		public ChatterGuiPanel() {
			ChatterGuiPanel.this.setPreferredSize(new Dimension(480, 400));
			ChatterGuiPanel.this.setLayout(new GridBagLayout());
			ChatterGuiPanel.this.setBorder(new TitledBorder(new EtchedBorder(), "Console"));

			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 1.0;
			c.weighty = 1.0;

			// TextPane to show log.
			_display = new JTextPane();
			_display.setEditable(false);
			_display.setPreferredSize(new Dimension(380, 300));
			_doc = _display.getStyledDocument();

			c.fill = GridBagConstraints.BOTH;

			c.gridx = 0;
			c.gridy = 0;

			// ScrollPanel
			_scrollpane = new JScrollPane(_display);
			_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			_scrollpane.setAutoscrolls(true);
			ChatterGuiPanel.this.add(_scrollpane, c);

			// Chatfield
			_chatfield = new JTextField();
			_chatfield.requestFocusInWindow();
			_chatfield.setAutoscrolls(true);
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 1;
			ChatterGuiPanel.this.add(_chatfield, c);

			// Send Button
			_send = new JButton("send");
			c.gridx = 1;
			c.gridy = 1;
			ChatterGuiPanel.this.add(_send, c);
		}
	}

	public JFrame get_frame() {
		return _frame;
	}

}