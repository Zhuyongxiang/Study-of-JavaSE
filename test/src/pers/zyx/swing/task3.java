package pers.zyx.swing;
import java.awt.*;
import javax.swing.*;

public class task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		Container panel=frame.getContentPane();
		panel.setLayout(new FlowLayout());
		JButton button1=new JButton("button1");
		JButton button2=new JButton("button2");
		JButton button3=new JButton("button3");
		JButton button4=new JButton("button4");
		JButton button5=new JButton("button5");
		panel.add("North",button1);
		panel.add("South",button2);
		panel.add("Center",button3);
		panel.add("West",button4);
		panel.add("East",button5);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

}
