package pers.zyx.graphics;

import java.awt.*;
import javax.swing.*;

public class task1 extends JFrame {

	public task1() {
		super("��ͼ");
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
		g.setColor(Color.WHITE); // ���õ�ǰ��ɫ
		g.fillOval(41, 271, 40, 40); // ����ʵ����Բ
		g.fillOval(292, 305, 40, 40); // ����ʵ����Բ
		g.fillOval(173, 402, 20, 20); // ����ʵ����Բ
		g.fillOval(90, 405, 90, 25); // ����ʵ����Բ
		g.fillOval(186, 405, 90, 25); // ����ʵ����Բ
		g.setColor(Color.BLACK); // ���õ�ǰ��ɫ
		g.drawOval(41, 271, 40, 40); // ���ƿ�����Բ
		g.drawOval(292, 305, 40, 40); // ���ƿ�����Բ
		g.drawOval(90, 405, 90, 25); // ���ƿ�����Բ
		g.drawOval(186, 405, 90, 25); // ���ƿ�����Բ
		g.setColor(Color.WHITE); // ���õ�ǰ��ɫ
		g.fillOval(85, 130, 200, 150); // ����ʵ����Բ
		g.fillOval(123, 260, 120, 112);// ����ʵ����Բ
		g.setColor(Color.RED); // ���õ�ǰ��ɫ
		g.fillRoundRect(103, 275, 166, 16, 15, 15); // ����ʵ��Բ�Ǿ���
		g.setColor(new Color(204, 204, 0));// ������ɫ
		g.fillOval(169, 278, 30, 30); // ����ʵ����Բ
		g.setColor(Color.BLACK); // ���õ�ǰ��ɫ
		g.drawLine(171, 285, 197, 285);// ����һ��ֱ��
		g.drawLine(169, 290, 200, 290);// ����һ��ֱ��
		g.fillOval(179, 293, 10, 10); // ����ʵ����Բ
		g.drawLine(184, 300, 184, 307); // ����һ��ֱ��
		g.drawArc(148, 290, 70, 70, 0, -180); // ����һ��Բ��
		g.drawLine(148, 325, 218, 325);// ����һֱ��
		g.setColor(Color.WHITE); // ���õ�ǰ��ɫ
		g.fillOval(123, 100, 60, 70); // ����ʵ����Բ
		g.fillOval(183, 100, 60, 70); // ����ʵ����Բ
		g.setColor(Color.BLACK); // ���õ�ǰ��ɫ
		g.drawOval(123, 100, 60, 70);// ���ƿ�����Բ
		g.drawOval(183, 100, 60, 70); // ���ƿ�����Բ
		g.fillOval(152, 138, 10, 16); // ����ʵ����Բ
		g.fillOval(202, 138, 10, 16); // ����ʵ����Բ
		g.setColor(Color.RED); // ���õ�ǰ��ɫ
		g.fillOval(169, 158, 27, 27); // ����ʵ����Բ
		g.setColor(Color.BLACK); // ���õ�ǰ��ɫ
		g.drawOval(169, 158, 27, 27);// ���ƿ�����Բ
		g.setColor(Color.WHITE); // ���õ�ǰ��ɫ
		g.fillOval(184, 161, 10, 13); // ����ʵ����Բ
		g.setColor(Color.BLACK); // ���õ�ǰ��ɫ
		g.drawArc(90, 60, 190, 190, -45, -90);// ����һ��Բ��
		g.drawLine(183, 185, 183, 250); // ����һ��ֱ��
		g.drawLine(100, 182, 148, 189); // ����һ��ֱ��
		g.drawLine(93, 200, 148, 200); // ����һ��ֱ��
		g.drawLine(98, 217, 148, 211); // ����һ��ֱ��
		g.drawLine(219, 189, 268, 182); // ����һ��ֱ��
		g.drawLine(219, 200, 272, 200); // ����һ��ֱ��
		g.drawLine(219, 211, 269, 218); // ����һ��ֱ��
		g.setFont(new Font("����", Font.PLAIN, 24));
		g.setColor(Color.BLUE); // ������ɫ
		g.drawString("����a��", 20, 70);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		task1 app = new task1();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
