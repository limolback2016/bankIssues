package limolb5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class BankGUI extends JFrame{
	public JFrame frame = new JFrame();
	private static final String VIEW_CUSTOMERS = "View Customers";
	private static final String NEW_CUSTOMER = "New Customer";
	private static final String DELETE_CUSTOMER = "Delete Customer";
	private static final String NEW_SAVING_ACCOUNT = "New Saving Account";
	private static final String NEW_CREDIT_ACCOUNT = "New Credit Account";
	private static final String VIEW_CUSTOMER = "View Customer";
	private static final String SHOW_TRANSACTION = "Show Transactions";
	private static final String CLOSE_ACCOUNT = "Close Account";
	
	private JTextField display;
	
	
	public BankGUI() {
		buildFrame();

	}
	
	public static void main(String[] args) {
		BankGUI bankGUI = new BankGUI();
		bankGUI.setVisible(true);

	}
	
	private void buildFrame() {
		buildMenu();
		buildButton();
		setBounds(1200, 300, 300, 400);
		setLayout(null);
		setTitle("Virtual Bank");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem file_new = new JMenuItem("New");

		JMenuItem file_exit = new JMenuItem("Exit");

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("View");
		JMenu about = new JMenu("About");
		JMenu newSubmenu = new JMenu();
		
		newSubmenu.add(file_new);
		newSubmenu.add(file_exit);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(about);
		file.add(file_new);
		file.add(file_exit);
		
		setJMenuBar(menuBar);
	}
	
	private void buildButton() {
		JButton showCustomers = new JButton(VIEW_CUSTOMERS);
		JButton newCustomer = new JButton(NEW_CUSTOMER);
		JButton deleteCustomer = new JButton(DELETE_CUSTOMER);
		JButton createSavAcc = new JButton(NEW_SAVING_ACCOUNT);
		JButton createCredAcc = new JButton(NEW_CREDIT_ACCOUNT);
		JButton viewCustomer = new JButton(VIEW_CUSTOMER);
		JButton showTransactions = new JButton(SHOW_TRANSACTION);
		JButton closeAccount = new JButton(CLOSE_ACCOUNT);
		
		newCustomer.setBounds(30, 30, 220, 25);
		createSavAcc.setBounds(30, 60, 220, 25);
		createCredAcc.setBounds(30, 90, 220, 25);
		showCustomers.setBounds(30, 120, 220, 25);
		showTransactions.setBounds(30, 150, 220, 25);
		viewCustomer.setBounds(30, 180, 220, 25);
		deleteCustomer.setBounds(30, 210, 220, 25);
		closeAccount.setBounds(30, 240, 220, 25);
		
		add(newCustomer);
		add(createSavAcc);
		add(createCredAcc);
		add(showCustomers);
		add(showTransactions);
		add(viewCustomer);
		add(deleteCustomer);
		add(closeAccount);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String buttonText = event.getActionCommand();
			
			switch (buttonText) {
			case VIEW_CUSTOMERS:
				addToDisplay(buttonText);
				break;
			case VIEW_CUSTOMER:
				
				break;
			case NEW_CUSTOMER:
				break;
			case NEW_SAVING_ACCOUNT:
				break;
			case NEW_CREDIT_ACCOUNT:
				break;
			case DELETE_CUSTOMER:
				break;
			case SHOW_TRANSACTION:
				break;
			case CLOSE_ACCOUNT:
				break;
			}
		}
	}
	
	private void addToDisplay(String buttonText) {
		display.setText(buttonText);
	}
	

}
