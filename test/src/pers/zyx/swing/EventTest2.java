package pers.zyx.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventTest2 extends JPanel implements MouseMotionListener {
	int xVal = 0, yVal = 0;
	boolean firstTime = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventTest2 demo = new EventTest2();
		demo.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setTitle("Drag to draw");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		addMouseMotionListener(this);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		if (!firstTime)
			g.fillOval(xVal, yVal, 5, 5);
		else
			firstTime = false;
	}

	public void mouseDragged(MouseEvent e) {
		xVal = e.getX();
		yVal = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {

	}
}
