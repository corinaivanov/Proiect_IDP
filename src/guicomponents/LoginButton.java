package guicomponents;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.IGuiMediator;
import app.Command;

public class LoginButton extends JButton implements Command {

	IGuiMediator med;
	
	public LoginButton(ActionListener act, IGuiMediator md) {
		super("Login");
		addActionListener(act);
		med = md;

	}

	public void execute() {
		med.login();
	}
}
