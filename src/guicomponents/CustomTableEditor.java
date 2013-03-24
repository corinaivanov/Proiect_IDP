package guicomponents;

import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CustomTableEditor extends AbstractCellEditor
							implements TableCellEditor,ActionListener {

	private JButton detailsButton = new JButton("...");
	public CustomTableEditor() {

	}

	public void actionPerformed(ActionEvent e) {

	}

//Implement the one CellEditor method that AbstractCellEditor doesn't.
	public Object getCellEditorValue() {
		return new Panel();
	}

//Implement the one method defined by TableCellEditor.
	public Component getTableCellEditorComponent(JTable table,
                        Object value,
                        boolean isSelected,
                        int row,
                        int column) {
		if(column == 2)
			return detailsButton;
		return null;
		//return super.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

}