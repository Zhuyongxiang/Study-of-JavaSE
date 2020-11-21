package pers.zyx.graphics;
import java.awt.*;
import javax.swing.*;

public class task2 extends JFrame{

	public task2(){
		super("演示字体、颜色、绘图");
		setVisible(true);
		setSize(480,250);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("SansSerif",Font.BOLD,12));
		g.setColor(Color.blue);
		g.drawString("字体ScanSerif，粗体，12号，蓝色",20,50);
		
		g.setFont(new Font("Serif",Font.ITALIC,14));
		g.setColor(new Color(255,0,0));
		g.drawString("字体Serif，斜体，14号，红蓝色",250,50);
		
		g.drawLine(20,60,460,60);
		
		g.setColor(Color.green);
		g.drawRect(20, 70, 100, 50);
		g.fillRect(130, 70, 100, 50);
		
		g.setColor(Color.yellow);
		g.drawRoundRect(240, 70, 100, 50, 50, 50);
		g.fillRoundRect(350, 70, 100, 50, 50, 50);
		
		g.setColor(Color.cyan);
		g.draw3DRect(20, 130, 100, 50, true);
		g.fill3DRect(130, 130, 100, 50, true);
		
		g.setColor(Color.pink);
		g.drawOval(240, 130, 100, 50);
		g.fillOval(350, 130, 100, 50);
		
		g.setColor(new Color(0,120,20));
		g.drawArc(20, 190, 100, 50, 0, 90);
		g.fillArc(130, 190, 100, 50, 0, 90);
		
		g.setColor(Color.black);
		int xValues[]= {250,280,290,300,330,310,320,290,260,270};
		int yValues[]= {210,210,190,210,210,220,230,220,230,220};
		g.drawPolygon(xValues, yValues, 10);
		
		int xValues2[]= {360,390,400,410,440,420,430,400,370,380};
		g.fillPolygon(xValues2,yValues,10);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		task2 app=new task2();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
