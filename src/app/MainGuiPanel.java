package app;
import guicomponents.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MainGuiPanel extends JPanel implements ActionListener {

	IGuiMediator mediator;
	JToolBar toolbar;
	JPanel cards;
	JTable selfServiceTable;
	
	
	public MainGuiPanel(IGuiMediator med){
		mediator = med;
		init();
		med.registerMainPanel(this);
	}
	
	enum Pages { Login, SelfServices, AuctionServices; }
	
	public void init(){
		toolbar = new JToolBar();
		
		toolbar.setFloatable(false);
		
		initPages();
		/*GridBagLayout gbl = new GridBagLayout();
		gbl.layoutContainer(this);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill   = GridBagConstraints.BOTH;
		constraints.weightx = 500;
		constraints.weighty = 400;
			
		gbl.setConstraints(this, constraints);
		
		this.setLayout(gbl);
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(toolbar, constraints);
		
		JTextField textField = new JTextField();
		constraints.gridx = 1;
		toolbar.add(textField, constraints);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill   = GridBagConstraints;
		constraints.weightx = 800;
		constraints.weighty = 100;
			
		gbl.setConstraints(this, constraints);
		
		this.setLayout(gbl);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(toolbar, constraints);*/
	}
	public void initPages(){
		
		JPanel cardLogin = initLoginPanel();
		
		JPanel cardSelfServices = initSelfServicesPanel();
		JPanel auctionServices = new JPanel();
		
		cards = new JPanel(new CardLayout());
		cards.add(cardLogin, Pages.Login.toString());
		cards.add(cardSelfServices, Pages.SelfServices.toString());
		cards.add(auctionServices, Pages.AuctionServices.toString());
		
		this.add(cards, BorderLayout.CENTER);
		CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, Pages.Login.toString());
	}
	
	private JPanel initLoginPanel(){
		
		JPanel cardLogin = new JPanel();
		
		GridBagConstraints constraints = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		gbl.layoutContainer(cardLogin);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill   = GridBagConstraints.BOTH;
		constraints.weightx = 800;
		constraints.weighty = 600;
		gbl.setConstraints(cardLogin, constraints);
		cardLogin.setLayout(gbl);
		
		JTextField usernameField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 2;
		cardLogin.add(usernameField, constraints);
		mediator.registerUsernameField(usernameField);
		
		JTextField passField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 3;
		cardLogin.add(passField, constraints);
		mediator.registerPassField(passField);
		
		String comboBoxItems[] = { UserModel.UserType.Buyer.toString(), UserModel.UserType.Seller.toString() };
		JComboBox cb = new JComboBox(comboBoxItems);
		constraints.gridx = 1;
		constraints.gridy = 4;
		cb.setEditable(false);
		cardLogin.add(cb, constraints);
		mediator.registerTypeCombo(cb);
		
		LoginButton loginButton = new LoginButton(this, mediator);
		constraints.gridx = 1;
		constraints.gridy = 5;
		
		cardLogin.add(loginButton, constraints);
		return cardLogin;
		
	}
	
	private JPanel initSelfServicesPanel(){
		JPanel servPanel = new JPanel();		
		selfServiceTable	= new JTable();
		selfServiceTable.setDefaultEditor(Object.class,new CustomTableEditor());
		this.mediator.registerSelfServicesTable(selfServiceTable);
		servPanel.add(new JScrollPane(selfServiceTable));
		return servPanel;
	}
	
	public void UpdateServicesView(){
		CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, Pages.SelfServices.toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof Command)
			((Command)source).execute();
		if(source instanceof JTable){
			
		}
	}
}
