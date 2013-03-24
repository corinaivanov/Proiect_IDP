package guicomponents;

import java.awt.Component;
import java.awt.Panel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.IGuiMediator;

public class CustomTableModel extends DefaultTableModel{
	
	IGuiMediator med;
	
	public CustomTableModel(String[] colArray, int i, IGuiMediator med) {
		super(colArray, i);
		this.med = med;
	}

	public boolean isCellEditable(int row, int col){
		return true;
	}
	
}
