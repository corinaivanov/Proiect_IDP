package app;
import javax.swing.JFrame;


public class Gui implements IGui{
	
	private IGuiMediator mediator;
	public Gui(IGuiMediator med){
		mediator = med;
	}
	
	public void Build(){
		JFrame frame = new JFrame("Auction House"); // title
		frame.setContentPane(new MainGuiPanel(mediator)); // content: the JPanel above
                frame.setLocationRelativeTo(null);
		frame.setSize(800, 600); // width / height
                //frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit application when window is closed
		frame.setVisible(true); // show it!
	}
	
}
