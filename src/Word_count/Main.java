package Word_count;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class Main {
	public static void main(String args[]) {
		JFrame jFrame = new JFrame("Character Count");
		JLabel j2, j3, j4;
		JTextArea text;
		JLabel j1;
		JButton submit, clear;
		text = new JTextArea("");
		submit = new JButton("SUBMIT");
		clear = new JButton("CLEAR");
		j1 = new JLabel("Enter Your string Here : ");
		j2 = new JLabel("Character with Spaces : ");
		j3 = new JLabel("Character Without Spaces : ");
		j4 = new JLabel("Words : ");
		Font txtFont = new Font(Font.SERIF, Font.PLAIN, 16);
		j1.setFont(txtFont);
		j2.setFont(txtFont);
		j3.setFont(txtFont);
		j4.setFont(txtFont);
		j1.setBounds(10, 25, 200, 30);
		text.setBounds(18, 60, 450, 300);
		j2.setBounds(10, 370, 400, 30);
		j3.setBounds(10, 400, 400, 30);
		j4.setBounds(10, 430, 400, 30);
		submit.setBounds(100, 470, 100, 50);
		clear.setBounds(275, 470, 100, 50);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = text.getText().strip();
				int count = 0, i, word = 0;
				j2.setText("Character with Spaces : " + str.length());
				for (i = 0; i < str.length(); i++) {
					if (str.charAt(i) != ' ')
						count++;
					else
						word++;
				}
				j3.setText("Character Without Spaces : " + count);
				j4.setText("Words : " + (word + 1));
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				j2.setText("Character with Spaces : ");
				j3.setText("Character Without Spaces : ");
				j4.setText("Words : ");
			}
		});
		jFrame.add(j1);
		jFrame.add(text);
		jFrame.add(j2);
		jFrame.add(j3);
		jFrame.add(j4);
		jFrame.add(submit);
		jFrame.add(clear);
		jFrame.setSize(500, 570);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

