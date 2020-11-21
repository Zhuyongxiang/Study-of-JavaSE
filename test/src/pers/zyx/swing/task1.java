package pers.zyx.swing;
import java.awt.*;
import javax.swing.*;

public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Swing Frame");
		Container contentPane=frame.getContentPane();
		JPanel panel=new JPanel();	//容纳label和button组件，并产生黑色边框（contentPane无法产生黑色边框）
		panel.setBorder(BorderFactory.createLineBorder(Color.black,5));
		JLabel label=new JLabel("Label",SwingConstants.CENTER);
		JButton button= new JButton("button");
		panel.setLayout(new GridLayout(2,1));
		panel.add(label);
		panel.add(button);
		contentPane.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
