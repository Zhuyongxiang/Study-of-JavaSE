package pers.zyx.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class CardLayoutTest2 implements ItemListener {

	String str1, str2;
	JPanel displayPanel = new JPanel();
	JPanel buttonPanle = new JPanel();
	JPanel textsPanle = new JPanel();
	
	JTextField textField = new JTextField(15);
	CardLayout card = new CardLayout();
	JComboBox controlComboBox = new JComboBox();

	public CardLayoutTest2() {
		JFrame frame = new JFrame();
		Container panel = frame.getContentPane();
		panel.setLayout(new GridLayout(2, 1));
		JPanel controlPanel = new JPanel();

		str1 = new String("JPanel with JButtons");
		str2 = new String("JPanel with JTextField");
		controlComboBox.addItem(str1);
		controlComboBox.addItem(str2);
		controlComboBox.addItemListener(this);
		controlPanel.add(controlComboBox);

		displayPanel.setLayout(card);

		// ÏÔÊ¾°´Å¥µÄJPanel
		buttonPanle.setLayout(new GridLayout(1, 3));
		buttonPanle.add(new JButton("button1"));
		buttonPanle.add(new JButton("button2"));
		buttonPanle.add(new JButton("button3"));

		textsPanle.setLayout(new FlowLayout());
		textsPanle.add(textField);
		
		displayPanel.add("buttons",buttonPanle);
		displayPanel.add("texts",textsPanle);

		panel.add(controlPanel);
		panel.add(displayPanel);
		
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent e) {
//		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (controlComboBox.getSelectedItem()==str1) {
				card.show(displayPanel, "buttons");
			} 
			else if (controlComboBox.getSelectedItem()==str2) {
				card.show(displayPanel, "texts");
			}
//		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardLayoutTest2();
	}

}
