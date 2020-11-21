package pers.zyx.swing;
import javax.swing.*;
import java.awt.*;

public class LabelButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Label and Button");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JLabel label = new JLabel("»ð¾¯°´Å¥£º");
        label.setFont(new Font("ËÎÌå", Font.PLAIN, 24));
        JButton button = new JButton(new ImageIcon("pictures/red.jpg"));
        f.getContentPane().add(label);
        f.getContentPane().add(button);
        f.setSize(300, 250);
        f.setVisible(true);   
	}

}
