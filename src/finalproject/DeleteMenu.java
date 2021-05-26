package finalproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import dao.MenuDAO;

public class DeleteMenu extends JFrame implements ActionListener, MouseListener {

	JTable table;
	JLabel txtNama, txtHarga, txtStok;
	JButton delete, back;
	String id = "";
	
	public DeleteMenu() {
		// TODO Auto-generated constructor stub
		initFrame();
		addButton();
	}
	
	public void initFrame() {
		setTitle("Delete Data");
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
		initComponent();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode Menu");
		column.add("Nama Menu");
		column.add("Harga Menu");
		column.add("Stok Menu");
		MenuDAO menuDAO = new MenuDAO();
		
		table = new JTable(menuDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		table.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}
	
	public void initComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel nama = new JLabel("Nama :");
		txtNama = new JLabel();
		panel.add(nama);
		panel.add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		txtHarga = new JLabel();
		panel.add(harga);
		panel.add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		txtStok = new JLabel();
		panel.add(stok);
		panel.add(txtStok);
		
		add(panel);
	}
	
	public void addButton() {
		delete = new JButton("Delete Data");
		back = new JButton("Back To Main Menu");
		delete.addActionListener(this);
		back.addActionListener(this);
		add(back);
		add(delete);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectRowIndex = table.getSelectedRow();
		id = table.getValueAt(selectRowIndex, 0).toString();
		String nama = table.getValueAt(selectRowIndex, 1).toString();
		String harga = table.getValueAt(selectRowIndex, 2).toString();
		String stok = table.getValueAt(selectRowIndex, 3).toString();
		
		txtNama.setText(nama);
		txtHarga.setText(harga);
		txtStok.setText(stok);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(delete)) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "You have to choose data first!");
			}else {
				MenuDAO menuDAO = new MenuDAO();
				menuDAO.deleteData(id);
				JOptionPane.showMessageDialog(null, "Success Delete!");
				new DeleteMenu();
				setVisible(false);
			}
		}
	}

}
