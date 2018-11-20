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
	public ArrayList<Model> quizQuestions = new ArrayList<>();
	public int count, imageCounter;
	String question;
	JRadioButton rdbtnOption;
	JRadioButton rdbtnOption_1;
	JRadioButton rdbtnOption_2;
	JRadioButton rdbtnOption_3;
	JLabel imageLabel;
	JPanel panel;
	Image image2;
	JLabel lblQuestions;


	
	public void setQuizObject(ArrayList<Model> arrayList) {
		quizQuestions = arrayList;
		question = quizQuestions.get(count).getQuestion();
		System.out.println("question is \n" + this.quizQuestions.get(0).getQuestion());

	}

	public void setImage() throws IOException {
		if (imageCounter >= 0 && imageCounter < 4) {
			image2 = ImageIO.read(new File("src/resources/" + this.quizQuestions.get(count).getImages()[imageCounter]))
					.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
			imageLabel.setIcon(new ImageIcon(image2));
		} else if (imageCounter == -1) {
			image2 = ImageIO.read(new File("src/resources/Starter_img.jpg")).getScaledInstance(panel.getWidth(),
					panel.getHeight(), Image.SCALE_SMOOTH);
			imageLabel.setIcon(new ImageIcon(image2));
		}
	}
	public void setCount() {
		if (count < 4) {
			count++;
		}
	}
	public int getCount() {
		return count;
	}


	public void setScreen() throws IOException {
		String question = this.quizQuestions.get(count).getQuestion();
		lblQuestions.setText("<html>" + "Question:" + question + "</html>");
		setImage();
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public QuestionsPage(ArrayList<Model> arrayList, int count) throws IOException {
		quizQuestions = arrayList;
		this.count = count;
		imageCounter = -1;

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

		panel = new JPanel();
		panel.setBounds(150, 67, 383, 235);
		Image image = ImageIO.read(new File("src/resources/Starter_img.jpg")).getScaledInstance(panel.getWidth(),
				panel.getHeight(), Image.SCALE_SMOOTH);

		imageLabel = new JLabel(new ImageIcon(image));
		panel.add(imageLabel);
		contentPane.add(panel);

		// question
		lblQuestions = new JLabel();
		lblQuestions.setFont(new Font("Calibri", Font.BOLD, 15));
		lblQuestions.setBounds(96, 362, 496, 73);
		lblQuestions.setText("<html>" + "Question: "
				+ "" + "</html>");
		contentPane.add(lblQuestions);

		// radio btn group
		btngrp = new ButtonGroup();

		rdbtnOption = new JRadioButton("option 1");
		rdbtnOption.setBounds(150, 457, 260, 23);
		rdbtnOption.setActionCommand("option 1");
		contentPane.add(rdbtnOption);

		rdbtnOption_1 = new JRadioButton("option 2");
		rdbtnOption_1.setBounds(150, 483, 260, 23);
		rdbtnOption_1.setActionCommand("option 2");
		contentPane.add(rdbtnOption_1);

		rdbtnOption_2 = new JRadioButton("option3");
		rdbtnOption_2.setBounds(150, 509, 260, 23);
		rdbtnOption_2.setActionCommand("option 3");

		contentPane.add(rdbtnOption_2);

		rdbtnOption_3 = new JRadioButton("option4");
		rdbtnOption_3.setBounds(150, 535, 260, 23);
		rdbtnOption_3.setActionCommand("option 4");

		contentPane.add(rdbtnOption_3);

		btngrp.add(rdbtnOption);
		btngrp.add(rdbtnOption_1);
		btngrp.add(rdbtnOption_2);
		btngrp.add(rdbtnOption_3);

		// next button
		Button button_1 = new Button("Next");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("next btn clicked!!");
				setCount();
				try {
					setScreen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				String question = quizQuestions.get(count).getQuestion();
//				lblQuestions.setText("<html>" + "Question:" + question + "</html>");
//				
			}
		});
		button_1.setBounds(522, 559, 70, 22);
		contentPane.add(button_1);

		Button button = new Button("Hints");

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				imageCounter++;
				try {
					setImage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(466, 320, 70, 22);
		contentPane.add(button);

		setScreen();
	}
}
