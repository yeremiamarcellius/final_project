package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import dao.MenuDAO;

public class ViewMenu extends JFrame implements ActionListener{

	JMenuItem back = new JMenuItem("Back to main menu");
	
	public ViewMenu() {
		// TODO Auto-generated constructor stub
		initFrame();
	}
	
	public void initFrame() {
		setTitle("View Menu");
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		initMenuBar();
		initTable();	
		
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Actions");

		back.addActionListener(this);

		menu1.add(back);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}

	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stok Menu");
		MenuDAO menuDAO = new MenuDAO();
		
		JTable table = new JTable(menuDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 400, 400);
		
		add(scroll);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}
	}

}
