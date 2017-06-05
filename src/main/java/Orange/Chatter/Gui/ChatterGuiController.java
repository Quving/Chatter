package Orange.Chatter.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatterGuiController {

	private ChatterGui _chattergui;

	public ChatterGuiController(ChatterGui chattergui) {
		_chattergui = chattergui;

		_chattergui.get_send().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ChatterGuiController.this.sendAction();
			}
		});
	}

	public void setDisplayText(String text) {
		_chattergui.get_display().setText(text);
	}
	
	public String getTextFromChatField() {
		String text = _chattergui.get_chatfield().getText().trim();
		return text;
	}
	
	public void sendAction() {
		String text = _chattergui.get_chatfield().getText();
		return text;
	}

}
