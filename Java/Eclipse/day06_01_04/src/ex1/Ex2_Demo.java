package ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_Demo extends JFrame{
	
	private JPanel p;
	private JButton b;
	public Ex2_Demo() {
		setTitle("테스트!");
		add(p=new JPanel());
		p.add(b=new JButton("Click"));
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("hi");
				p.setBackground(Color.green);
			}
		});
		p.setBackground(Color.red);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex2_Demo();
	}
}
