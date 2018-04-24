package limolb5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BankGUI extends JFrame{
	public JFrame frame = new JFrame();
	
	public BankGUI() {
		buildFrame();

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
		JButton showCustomers = new JButton("View Customers");
		JButton newCustomer = new JButton("New Customer");
		JButton deleteCustomer = new JButton("Delete Customer");
		JButton createSavAcc = new JButton("New Saving Account");
		JButton createCredAcc = new JButton("New Credit Account");
		JButton viewCustomer = new JButton("View Customer");
		JButton showTransactions = new JButton("Show Transactions");
		JButton closeAccount = new JButton("Close Account");
		
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

	public static void main(String[] args) {
		BankGUI bankGUI = new BankGUI();
		bankGUI.setVisible(true);

	}

}
