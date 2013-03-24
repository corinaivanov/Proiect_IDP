package app;
import javax.swing.SwingUtilities;


public class Main{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mediator med = new Mediator();
		SwingUtilities.invokeLater(new GuiThread(med));
		
	}

}

