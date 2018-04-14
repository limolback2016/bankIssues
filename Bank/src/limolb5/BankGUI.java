package limolb5;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BankGUI extends JFrame{
	public JFrame frame = new JFrame();
	
	public BankGUI() {
		addBankMenu();
		setBounds(1200, 300, 300, 400);
		setTitle("Virtual Bank");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addBankMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem file_new = new JMenuItem("New");
		JMenuItem file_exit = new JMenuItem("Exit");

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
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

	public static void main(String[] args) {
		BankGUI bankGUI = new BankGUI();
		bankGUI.setVisible(true);

	}

}
