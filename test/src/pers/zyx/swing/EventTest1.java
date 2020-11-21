package pers.zyx.swing;

import javax.swing.*;
import java.awt.event.*;

class MyListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("I've been clicked");
	}
}

public class EventTest1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("click me");
		frame.getContentPane().add(button);
		frame.setSize(200, 200);
		MyListener listener = new MyListener();
		button.addActionListener(listener);	//当用户在此按钮上按下或释放鼠标时，发生动作事件。
		frame.setVisible(true);
	}
}
