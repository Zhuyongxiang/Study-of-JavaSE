package pers.zyx.graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class task3 extends JFrame{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Simple Swing Application");
		frame.setSize(200,200);
		JButton button=new JButton("Click me");
		JLabel label=new JLabel();
		JPanel contentPanel=(JPanel)frame.getContentPane();
		contentPanel.setLayout(new GridLayout(2,1));
		contentPanel.add(button);
		contentPanel.add(label);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String information=JOptionPane.showInputDialog("«Î ‰»Î“ª¥Æ◊÷∑˚");
				label.setText(information);
			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
