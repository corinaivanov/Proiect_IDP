package app;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IGuiMediator {

	public void login();
	
	public void registerUsernameField(JTextField usernameField);
	
	public void registerPassField(JTextField passField);
	
	public void registerTypeCombo(JComboBox typeCombo);
	
	public void registerMainPanel(MainGuiPanel mainPanel);
	
	public void registerSelfServicesTable(JTable table);
}
