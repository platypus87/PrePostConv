/*
 * Matthew White
 * CMSC 350 - Spring '21
 * PURPOSE: Take in an expression and convert it from one format to another, i.e. prefix to postfix. 
 * This file contains the GUI portion of the program.
 */
package prePostConvert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	private static JLabel expression, result;
	private static JButton preToPost, postToPre;
	private static JTextField input;
	private static Converter convert = new Converter();

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		expression = new JLabel("Enter Expression:");
		expression.setBounds(10, 20, 80, 25);
		panel.add(expression);
		
		input = new JTextField(20);
		input.setBounds(10, 50, 80, 25);
		panel.add(input);
		
		//Postfix to Prefix button and listener
		postToPre = new JButton("Postfix To Prefix");
		postToPre.setBounds(10, 100, 25, 15);
		postToPre.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
			result.setText(convert.postfixToPrefix(input.getText()));
			}catch(java.util.EmptyStackException e) {
				JFrame err1 = new JFrame();
				JOptionPane.showMessageDialog(err1, "Cannot Convert, check equation for accuracy","Alert",JOptionPane.WARNING_MESSAGE);
			}catch(StackNotEmpty e) {
				JFrame err2 = new JFrame();
				JOptionPane.showMessageDialog(err2,"Incorrect Format: Items left in Stack!","ALERT",JOptionPane.WARNING_MESSAGE);
			}
			
		}
	});
		panel.add(postToPre);
		
		//Prefix to Postfix button and Listener
		preToPost = new JButton("Prefix To Postfix");
		preToPost.setBounds(10, 130, 25, 15);
		preToPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
				result.setText(convert.prefixToPostfix(input.getText()));
				}
				catch (java.util.EmptyStackException e){
					JFrame err1 = new JFrame();
					JOptionPane.showMessageDialog(err1, "Cannot Convert, check equation for accuracy","Alert",JOptionPane.WARNING_MESSAGE);
				} catch (StackNotEmpty e) {
					JFrame err2 = new JFrame();
					JOptionPane.showMessageDialog(err2,"Incorrect Format: Items left in Stack!","ALERT",JOptionPane.WARNING_MESSAGE);
				} catch (Exception e) {
					JFrame err3 = new JFrame();
					JOptionPane.showMessageDialog(err3, e,"System Generated",JOptionPane.WARNING_MESSAGE);
				}
				
			}	
		});
		panel.add(preToPost);
		
		//Displays conversion if successful
		result = new JLabel("Result: ");
		result.setBounds(10, 350, 40,25);
		panel.add(result);
		
		frame.setVisible(true);		
	}
}

