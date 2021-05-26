package finalproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.MenuDAO;

public class UpdateMenu extends JFrame implements ActionListener, MouseListener {

	JTextField txtNama, txtHarga, txtStok;
	JButton update, back;
	JTable table;
	String id = "";
	
	public UpdateMenu() {
		// TODO Auto-generated constructor stub
		initFrame();
		addButton();
	}
	
	public void initFrame() {
		setTitle("Update Form");
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
		initFormUpdate();
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
		scroll.setBounds(0, 0, 400, 400);
		
		add(scroll);
	}
	
	public void initFormUpdate() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel nama = new JLabel("Nama :");
		txtNama = new JTextField();
		panel.add(nama);
		panel.add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		txtHarga = new JTextField();
		panel.add(harga);
		panel.add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		txtStok = new JTextField();
		panel.add(stok);
		panel.add(txtStok);
		
		add(panel);
	}
	
	public void addButton() {
		update = new JButton("Update Data");
		back = new JButton("Back To Main Menu");
		update.addActionListener(this);
		back.addActionListener(this);
		add(back);
		add(update);
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
		}else if(e.getSource().equals(update)) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "You have to choose data first!");
			}else {
				MenuDAO menuDAO = new MenuDAO();
				menuDAO.updateData(id, txtNama.getText(), txtHarga.getText(), txtStok.getText());
				JOptionPane.showMessageDialog(null, "Success Update!");
				new UpdateMenu();
				setVisible(false);
			}
		}
	}

}
