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
	
	JLabel imageLabel;
	JPanel panel;
	Image image2;

	

	// public String getQuestion() {
	// question = this.quizQuestions.get(count).getQuestion();
	// return question;
	// }

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

	public void displayImage() throws IOException {
		

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
		// ImageIcon imageIcon = new ImageIcon(image);
		imageLabel = new JLabel(new ImageIcon(image));
		panel.add(imageLabel);
		contentPane.add(panel);

		

		//
		// JLabel label = new JLabel();
		// label.setIcon(new ImageIcon("myImage.PNG"));;
		// panel.add(label);

		// lblQuestions = new JLabel(this.question);
		// lblQuestions.setFont(new Font("Calibri", Font.BOLD, 17));
		// lblQuestions.setBounds(96, 362, 496, 73);
		// contentPane.add(lblQuestions);







		Button button = new Button("Hints");
		// Image image1 = ImageIO.read(new
		// File("src/resources/Adapter_1.jpg")).getScaledInstance(panel.getWidth(),
		// panel.getHeight(), Image.SCALE_SMOOTH);
		// image2 = ImageIO.read(new
		// File("src/resources/Adapter_2.jpg")).getScaledInstance(panel.getWidth(),
		// panel.getHeight(), Image.SCALE_SMOOTH);

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

		

		displayImage();
	}
}
