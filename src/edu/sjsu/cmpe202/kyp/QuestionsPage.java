package edu.sjsu.cmpe202.kyp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ServantObject;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class QuestionsPage extends JFrame {

	private JPanel contentPane;
	private ButtonGroup btngrp;
	static ArrayList<Model> quizQuestions = new ArrayList<>();
	static int count;
	String question;
	JRadioButton rdbtnOption;
	JRadioButton rdbtnOption_1;
	JRadioButton rdbtnOption_2;
	JRadioButton rdbtnOption_3;
	JLabel imageLabel;
	Image image2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// question= quizQuestions.get(count).getQuestion();
					// System.out.println("\n\n"+question);
					// QuestionsPage frame = new QuestionsPage();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel lblQuestions;

	public void setQuizObject(ArrayList<Model> arrayList) {
		this.quizQuestions = arrayList;

	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setScreen() {
		setCount(count + 1);

		imageLabel.setIcon(new ImageIcon(image2));
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public QuestionsPage(ArrayList<Model> arrayList, int count) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKnowYourPatterns = new JLabel("Know your patterns");

		lblKnowYourPatterns.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblKnowYourPatterns.setHorizontalAlignment(SwingConstants.CENTER);
		lblKnowYourPatterns.setBounds(229, 11, 290, 45);
		contentPane.add(lblKnowYourPatterns);

		JPanel panel = new JPanel();
		panel.setBounds(150, 67, 383, 235);
		Image image = ImageIO.read(new File("src/resources/myImage.png")).getScaledInstance(panel.getWidth(),
				panel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		imageLabel = new JLabel(new ImageIcon(image));
		panel.add(imageLabel);
		contentPane.add(panel);
		

	}
}
