package finalproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainMenu extends JFrame implements ActionListener{

	JButton button1 = new JButton("Insert");
	JButton button2 = new JButton("View");
	JButton button3 = new JButton("Update");
	JButton button4 = new JButton("Delete");
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
		initFrame();
	}
	
	public void initFrame() {
		setTitle("BobaCool");
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		addText();
		addButton();
	}
	
	public void addText() {
		JLabel title = new JLabel("BobaCool");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font(null, Font.BOLD, 30));
		
		add(title, BorderLayout.NORTH);
	}
	
	public void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		button1.setBounds(0, 0, 400, 75);
		button2.setBounds(0, 75, 400, 75);
		button3.setBounds(0, 150, 400, 75);
		button4.setBounds(0, 225, 400, 75);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button1)) {
			new InsertMenu();
			setVisible(false);
		}else if(e.getSource().equals(button2)) {
			new ViewMenu();
			setVisible(false);
		}else if(e.getSource().equals(button3)) {
			new UpdateMenu();
			setVisible(false);
		}else if(e.getSource().equals(button4)) {
			new DeleteMenu();
			setVisible(false);
		}
	}
}
