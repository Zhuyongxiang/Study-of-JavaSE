package pers.zyx.swing;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
import javax.swing.*;
 
public class t3 extends JFrame{
	
	private static final long serialVersionUID = 1L; 
	
	public t3() {
		setTitle("Hern");
		setBounds(400, 400, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout flowLayout = new FlowLayout();
		setLayout(flowLayout);//���ò���
		
		JComboBox<String> comboBox = new JComboBox<>();// ����һ�������˵�
		comboBox.setPreferredSize(new Dimension(100, 20));//���������˵��Ŀ�ȡ��߶�
		
		for (int i = 1; i < 6; i++) {// ͨ��ѭ�����ѡ��
			comboBox.addItem("ѡ��" + i);
		}
		comboBox.addItemListener(new ItemListener() {// ���ѡ���¼�������
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();// ����¼�����
				String item = e.getItem().toString();// ��ô����˴��¼���ѡ��
				if (stateChange == ItemEvent.SELECTED) {// �鿴�Ƿ���ѡ��ѡ���
					System.out.println("�˴��¼���      ѡ��  ѡ�" + item + "��������");
					// �鿴�Ƿ���ȡ��ѡ��ѡ���
				} else if (stateChange == ItemEvent.DESELECTED) {
					System.out.println("�˴��¼���  ȡ��ѡ��  ѡ�" + item + "��������");
				} else {// ������ԭ�򴥷�
					System.out.println("�˴��¼�������ԭ�򴥷���");
				}
			}
		});
		add(comboBox);
		
		setVisible(true);
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t3 test = new t3();
 
	}
 
}
