package edu.sjsu.cmpe202.kyp.builder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import edu.sjsu.cmpe202.kyp.Question;
import edu.sjsu.cmpe202.kyp.Observer.Scores;
import edu.sjsu.cmpe202.kyp.data.DataLoaderImpl;
import edu.sjsu.cmpe202.kyp.memento.Caretaker;
import edu.sjsu.cmpe202.kyp.memento.Originator;
import edu.sjsu.cmpe202.kyp.strategy.DifficultyLevel;

public class HomeScreenBuilder extends AbstractGameScreenBuilder {


	public HomeScreenBuilder() {
		
	}

	@Override
	protected void buildBorder() {
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setBounds(100, 100, 930, 700);
		screen.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}

	@Override
	protected void buildContent() {

		// JLabel lblNewLabel = new JLabel("Your Score: " +
		// score.getCurrentScore());
		// lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		// lblNewLabel.setBounds(25, 20, 189, 27);
		// contentPane.add(lblNewLabel);

		JLabel lblNewLabel = new JLabel("Your Score: " );
		lblNewLabel.setForeground(SystemColor.windowBorder);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 21));
		lblNewLabel.setBounds(20, 102, 202, 39);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton(DifficultyLevel.EASY.toString());

		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Easy level selected!!");
			
			}
		});
		btnNewButton.setBounds(391, 152, 157, 83);
		contentPane.add(btnNewButton);

		JButton btnMedium = new JButton(DifficultyLevel.MEDIUM.toString());
		btnMedium.setForeground(SystemColor.windowBorder);
		btnMedium.setBackground(SystemColor.activeCaption);
		btnMedium.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Medium level selected!!");
				

			}
		});
		btnMedium.setBounds(391, 306, 157, 83);
		contentPane.add(btnMedium);

		JButton btnNewButton_1 = new JButton(DifficultyLevel.HARD.toString());

		btnNewButton_1.setForeground(SystemColor.windowBorder);
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Difficult level selected!!");
				

			}
		});
		btnNewButton_1.setBounds(391, 468, 157, 74);
		contentPane.add(btnNewButton_1);
	}

	

	@Override
	protected void buildScore() {
		// TODO Auto-generated method stub

	}

}
