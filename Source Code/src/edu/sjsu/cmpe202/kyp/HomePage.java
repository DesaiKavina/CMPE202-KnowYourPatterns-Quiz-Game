package edu.sjsu.cmpe202.kyp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8445162697750475525L;
	
	private JPanel contentPane;
	ArrayList<Model> listObject = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 451);
		contentPane = new JPanel();
		ReadJson readJson =new ReadJson();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKnowYourPatterns = new JLabel("Know Your Patterns");
		lblKnowYourPatterns.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblKnowYourPatterns.setHorizontalAlignment(SwingConstants.CENTER);
		lblKnowYourPatterns.setBounds(208, 13, 238, 39);
		contentPane.add(lblKnowYourPatterns);

		JButton btnNewButton = new JButton("Easy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Easy level selected!!");

				dispose();
				listObject= readJson.getEasy1();
				
				try {
					QuestionsPage qp = new QuestionsPage(listObject,0);
//					qp.setCount(0);
					qp.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(261, 84, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Medium level selected!!");
			}
		});
		btnMedium.setBounds(261, 142, 97, 25);
		contentPane.add(btnMedium);

		JButton btnNewButton_1 = new JButton("Difficult");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Difficult level selected!!");
			}
		});
		btnNewButton_1.setBounds(261, 197, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
