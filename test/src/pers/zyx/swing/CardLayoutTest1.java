package pers.zyx.swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CardLayoutTest1 implements ActionListener {
	JButton first = new JButton("第一张");
	JButton pre = new JButton("上一张");
	JButton next = new JButton("下一张");
	JButton last = new JButton("最后一张");
	JFrame frame = new JFrame();
	Container panel = frame.getContentPane();
	JPanel panel1 = new JPanel();
	CardLayout card = new CardLayout();

	public CardLayoutTest1() {
		panel.setLayout(new GridLayout(2, 1));
		panel1.setLayout(card);
		for (int i = 0; i < 5; i++) {
			panel1.add(new JButton("button" + (i+1)));
		}
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 4));
		panel2.add(first);
		panel2.add(pre);
		panel2.add(next);
		panel2.add(last);
		first.addActionListener(this);
		pre.addActionListener(this);
		next.addActionListener(this);
		last.addActionListener(this);
		panel.add(panel1);
		panel.add(panel2);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == first) {
			card.first(panel1);
		} else if (e.getSource() == pre) {
			card.previous(panel1);
		} else if (e.getSource() == next) {
			card.next(panel1);
		} else if (e.getSource() == last) {
			card.last(panel1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new CardLayoutTest1();
	}

}
