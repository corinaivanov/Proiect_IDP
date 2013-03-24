package app;

import guicomponents.CustomTableModel;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Mediator implements IGuiMediator, INetworkMediator, IWebServiceClientMediator {

	IWebServiceClient webService;
	private int userId;
	
	JTextField usernameField;
	JTextField passField;
	JComboBox typeCombo;
	MainGuiPanel mainPanel;
	JTable selfServicesTable;
	
	public Mediator(){
		webService = new WebServiceClient();
	}
	
	public void login(){
		userId = webService.IsValidLogin(usernameField.getText(), passField.getText(), typeCombo.getSelectedItem().toString());
		if(userId > 0){
			UpdateServicesView(userId);
		}
	}
	
	public void registerUsernameField(JTextField usernameField){
		this.usernameField = usernameField;
	}
	
	public void registerPassField(JTextField passField){
		this.passField = passField;
	}
	
	public void registerTypeCombo(JComboBox typeCombo){
		this.typeCombo = typeCombo;
	}
	
	public void registerMainPanel(MainGuiPanel mainPanel){
		this.mainPanel = mainPanel;
	}
	
	public void UpdateServicesView(int userId){
		String colArray[] = {"Service name", "Status", "Offers"};
		CustomTableModel tableModel = new CustomTableModel(colArray,0,this);
		ArrayList rows = webService.GetServicesData(userId);
		for(int i = 0; i< rows.size(); i++)
			tableModel.addRow(((ArrayList)rows.get(i)).toArray());
		this.selfServicesTable.setModel(tableModel);
		this.mainPanel.UpdateServicesView();
	}	
	
	public void registerSelfServicesTable(JTable table){
		this.selfServicesTable = table;
	}

	
}
