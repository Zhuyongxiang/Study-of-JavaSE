package pers.zyx.swing;
import javax.swing.*;
import java.awt.*;

public class PanelTest {

	private static JPanel getFieldPanel() {
	    JPanel p = new JPanel();
	    p.setLayout(new FlowLayout());
	    p.add(new JLabel("Name:"));
	    p.add(new JTextField(12));
	    p.add(new JCheckBox("Java", true));
	    p.add(new JCheckBox("C++", true));
	    p.add(new JCheckBox("Perl", false));
	    return p;
	}
	private static JPanel getButtonPanel() {
	    JPanel p = new JPanel();
	    p.setLayout(new FlowLayout());
	    p.add(new JButton("OK"));
	    p.add(new JButton("Cancel"));
	    return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("FlowLayout");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel cp = (JPanel)f.getContentPane();
	    cp.setLayout(new FlowLayout());
	    cp.add(getFieldPanel());
	    cp.add(getButtonPanel());
	    f.pack();
	    f.setVisible(true);
	}

}
