package edu.sjsu.cmpe202.kyp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Try extends JFrame {

	private JPanel contentPane;

	String name ="mili";
	int qcount=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Try frame = new Try();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void my(String str){
		System.out.println("str"+str);
		this.name=str;
		System.out.println("name is"+this.name);
		JLabel lblHello = new JLabel("Hello"+this.name);
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setBounds(67, 37, 286, 16);
		contentPane.add(lblHello);
	}
	
	public void count(){
		
	}

	/**
	 * Create the frame.
	 */
	public Try() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblCount = new JLabel("count :"+this.qcount);
		lblCount.setBounds(172, 89, 56, 16);
		contentPane.add(lblCount);
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qcount++;
				System.out.println("count is"+qcount);
				
				lblCount.setText("count is"+qcount);
			}
		});
		btnNext.setBounds(153, 125, 97, 25);
		contentPane.add(btnNext);
		
		
		System.out.println("this.name"+ name);
		
	}

}
