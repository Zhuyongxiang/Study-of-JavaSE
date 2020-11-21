package pers.zyx.swing;
import javax.swing.*;
import java.awt.*;

public abstract class GridLayoutTest implements LayoutManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("GridLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel cp=(JPanel)frame.getContentPane();
		cp.setLayout(new GridLayout(3,2));
		JLabel label1=new JLabel("1");
		label1.setFont(new Font("宋体",Font.BOLD, 30));
		JLabel label2=new JLabel("2");
		label2.setFont(new Font("宋体",Font.BOLD, 30));
		JLabel label3=new JLabel("3");
		label3.setFont(new Font("宋体",Font.BOLD, 30));
		JLabel label4=new JLabel("4");
		label4.setFont(new Font("宋体",Font.BOLD, 30));
		JLabel label5=new JLabel("5");
		label5.setFont(new Font("宋体",Font.BOLD, 30));
		JLabel label6=new JLabel("6");
		label6.setFont(new Font("宋体",Font.BOLD, 30));
		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.add(label5);
		cp.add(label6);
		frame.setContentPane(cp);
		frame.pack();
		frame.setVisible(true);
	}

}
