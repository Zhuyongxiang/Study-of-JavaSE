package pers.zyx.graphics;

import java.awt.*;
import javax.swing.*;

public class task1 extends JFrame {

	public task1() {
		super("画图");
		setVisible(true);
		setSize(370, 460);
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 370, 450);
		Color blue = new Color(0, 100, 255);
		g.setColor(blue);
		g.fillOval(65, 60, 240, 230);
		g.fillRect(109, 290, 150, 120);
		int xValues[] = { 109, 70, 63, 109 };
		int yValues[] = { 290, 278, 308, 321 };
		g.fillPolygon(xValues, yValues, 4);
		int xValues1[] = { 259, 305, 295, 259 };
		int yValues1[] = { 290, 308, 332, 321 };
		g.fillPolygon(xValues1, yValues1, 4);
		g.setColor(Color.WHITE); // 设置当前颜色
		g.fillOval(41, 271, 40, 40); // 绘制实心椭圆
		g.fillOval(292, 305, 40, 40); // 绘制实心椭圆
		g.fillOval(173, 402, 20, 20); // 绘制实心椭圆
		g.fillOval(90, 405, 90, 25); // 绘制实心椭圆
		g.fillOval(186, 405, 90, 25); // 绘制实心椭圆
		g.setColor(Color.BLACK); // 设置当前颜色
		g.drawOval(41, 271, 40, 40); // 绘制空心椭圆
		g.drawOval(292, 305, 40, 40); // 绘制空心椭圆
		g.drawOval(90, 405, 90, 25); // 绘制空心椭圆
		g.drawOval(186, 405, 90, 25); // 绘制空心椭圆
		g.setColor(Color.WHITE); // 设置当前颜色
		g.fillOval(85, 130, 200, 150); // 绘制实心椭圆
		g.fillOval(123, 260, 120, 112);// 绘制实心椭圆
		g.setColor(Color.RED); // 设置当前颜色
		g.fillRoundRect(103, 275, 166, 16, 15, 15); // 绘制实心圆角矩形
		g.setColor(new Color(204, 204, 0));// 设置颜色
		g.fillOval(169, 278, 30, 30); // 绘制实心椭圆
		g.setColor(Color.BLACK); // 设置当前颜色
		g.drawLine(171, 285, 197, 285);// 绘制一条直线
		g.drawLine(169, 290, 200, 290);// 绘制一条直线
		g.fillOval(179, 293, 10, 10); // 绘制实心椭圆
		g.drawLine(184, 300, 184, 307); // 绘制一条直线
		g.drawArc(148, 290, 70, 70, 0, -180); // 绘制一段圆弧
		g.drawLine(148, 325, 218, 325);// 绘制一直线
		g.setColor(Color.WHITE); // 设置当前颜色
		g.fillOval(123, 100, 60, 70); // 绘制实心椭圆
		g.fillOval(183, 100, 60, 70); // 绘制实心椭圆
		g.setColor(Color.BLACK); // 设置当前颜色
		g.drawOval(123, 100, 60, 70);// 绘制空心椭圆
		g.drawOval(183, 100, 60, 70); // 绘制空心椭圆
		g.fillOval(152, 138, 10, 16); // 绘制实心椭圆
		g.fillOval(202, 138, 10, 16); // 绘制实心椭圆
		g.setColor(Color.RED); // 设置当前颜色
		g.fillOval(169, 158, 27, 27); // 绘制实心椭圆
		g.setColor(Color.BLACK); // 设置当前颜色
		g.drawOval(169, 158, 27, 27);// 绘制空心椭圆
		g.setColor(Color.WHITE); // 设置当前颜色
		g.fillOval(184, 161, 10, 13); // 绘制实心椭圆
		g.setColor(Color.BLACK); // 设置当前颜色
		g.drawArc(90, 60, 190, 190, -45, -90);// 绘制一段圆弧
		g.drawLine(183, 185, 183, 250); // 绘制一条直线
		g.drawLine(100, 182, 148, 189); // 绘制一条直线
		g.drawLine(93, 200, 148, 200); // 绘制一条直线
		g.drawLine(98, 217, 148, 211); // 绘制一条直线
		g.drawLine(219, 189, 268, 182); // 绘制一条直线
		g.drawLine(219, 200, 272, 200); // 绘制一条直线
		g.drawLine(219, 211, 269, 218); // 绘制一条直线
		g.setFont(new Font("隶书", Font.PLAIN, 24));
		g.setColor(Color.BLUE); // 设置颜色
		g.drawString("哆啦a梦", 20, 70);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		task1 app = new task1();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
