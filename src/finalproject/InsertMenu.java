package finalproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.MenuDAO;

public class InsertMenu extends JFrame implements ActionListener {

	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	JTextField txtNama = new JTextField();
	JTextField txtHarga = new JTextField();
	JTextField txtStock = new JTextField();
	
	public InsertMenu() {
		// TODO Auto-generated constructor stub
		initFrame();
	}
	
	public void initFrame() {
		setTitle("Insert Menu");
		setSize(400, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		setVisible(true);
		
		initComponent();
	}
	
	public void initComponent() {
		JLabel nama = new JLabel("Nama :");
		add(nama);
		add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		add(harga);
		add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		add(stok);
		add(txtStock);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		add(save);
		add(cancel);
	}
	
	public boolean validateData() {
		if(txtNama.getText().isEmpty() || txtHarga.getText().isEmpty() || txtStock.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(validateData() == false) {
				JOptionPane.showMessageDialog(null, "Please fill all input");
			}else {
				MenuDAO menuDAO = new MenuDAO();
				menuDAO.insertData(txtNama.getText(), txtHarga.getText(), txtStock.getText());
				JOptionPane.showMessageDialog(null, "Success Add Data");
			}
		}else if(e.getSource().equals(cancel)){
			new MainMenu();
			setVisible(false);
		}
	}

}
