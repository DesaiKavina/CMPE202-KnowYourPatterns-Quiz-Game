package edu.sjsu.cmpe202.kyp;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FinalPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4368460972645066924L;

	private JPanel contentPane;

	public ArrayList<Model> quizQuestions = new ArrayList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FinalPage frame = new FinalPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void iterateComponent() {
		int pad=100;
		for (int i = 0; i < 5; i++) {
			JLabel lblQuestions = new JLabel("<html>"+"Questions:  "+quizQuestions.get(i).getQuestion()+"</html>");
			lblQuestions.setBounds(20, 147+i*pad, 884, 29);
			contentPane.add(lblQuestions);

			JLabel lblCorrectAnswer = new JLabel("Correct Answer: "+quizQuestions.get(i).getAnswer());
			lblCorrectAnswer.setBounds(20, 173+i*pad, 884, 29);
			contentPane.add(lblCorrectAnswer);

			JLabel lblYourAnswer = new JLabel("Your Answer: "+quizQuestions.get(i).getChoosenAnswer());
			lblYourAnswer.setBounds(20, 202+i*pad, 884, 22);
			contentPane.add(lblYourAnswer);
		}

	}

	/**
	 * Create the frame.
	 */
	public FinalPage(ArrayList<Model> arrayList) {
		quizQuestions = arrayList;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKnowYourPatterns = new JLabel("Know Your Patterns");
		lblKnowYourPatterns.setHorizontalAlignment(SwingConstants.CENTER);
		lblKnowYourPatterns.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblKnowYourPatterns.setBounds(353, 11, 256, 29);
		contentPane.add(lblKnowYourPatterns);

		JLabel lblYourScoreIs = new JLabel("Your score is ");
		lblYourScoreIs.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblYourScoreIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourScoreIs.setBounds(427, 51, 88, 22);
		contentPane.add(lblYourScoreIs);

		JLabel lblNewLabel = new JLabel("55");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(414, 77, 101, 37);
		contentPane.add(lblNewLabel);

		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSummary.setBounds(20, 107, 88, 29);
		contentPane.add(lblSummary);
		
		

//		JLabel lblQuestions = new JLabel("Questions: ");
//		lblQuestions.setBounds(20, 147, 884, 29);
//		contentPane.add(lblQuestions);
//
//		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
//		lblCorrectAnswer.setBounds(20, 173, 884, 29);
//		contentPane.add(lblCorrectAnswer);
//
//		JLabel lblYourAnswer = new JLabel("Your Answer");
//		lblYourAnswer.setBounds(20, 202, 884, 22);
//		contentPane.add(lblYourAnswer);

		iterateComponent();
	}
}
