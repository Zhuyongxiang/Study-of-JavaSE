package pers.zyx.swing;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {

	public static void main(String[] args) {   
		// TODO Auto-generated method stub
		JFrame f = new JFrame("BorderLayout");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel cp = (JPanel)f.getContentPane();
	    cp.setLayout(new BorderLayout());
	    cp.add("North", new JButton(new ImageIcon("pictures/bei.jpg")));
	    cp.add("East", new JButton(new ImageIcon("pictures/dong.jpg")));
	    cp.add("South", new JButton(new ImageIcon("pictures/nan.jpg")));
	    cp.add("West", new JButton(new ImageIcon("pictures/xi.jpg")));
	    cp.add("Center", new JButton(new ImageIcon("pictures/zhong.jpg")));
	    f.pack();
	    f.setVisible(true); 
	}

}
