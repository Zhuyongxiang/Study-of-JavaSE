package pers.zyx.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQ app = new QQ();
		app.show();
	}

	public void show() {
		/*
		 * ����Ļ�������
		 */
		JFrame jf = new JFrame();
		jf.setSize(420, 300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setResizable(false);
		/*
		 * ���ɴ����еĸ������
		 */
		ImageIcon imageQQ = new ImageIcon("pictures\\QQ���.jpg");
		JLabel component1 = new JLabel(imageQQ);
		// ���1 �ǽ����ϵ�QQ��ɫ���ͼ��ͼ�����ǰ�������JLabel�������
		ImageIcon imageqq = new ImageIcon("pictures\\QQͷ��.jpg");
		JLabel component2 = new JLabel(imageqq);
		// ���2 �ǽ����ϵ�QQ���ͼ��ͬ��ͼ�����ǰ�������JLabel�������
		JTextField component3 = new JTextField();
		// ���3���û����˺������
		JLabel component4 = new JLabel("�û��˺�");
		// ���4���û����˺�������ұߵ���ʾ��ǩ
		JTextField component5 = new JTextField();
		// ���5���û������������
		JLabel component6 = new JLabel("�û�����");
		// ���6���û�������������ұߵ���ʾ��ǩ
		JCheckBox component7 = new JCheckBox("��ס����");
		// ���7���û��ġ���ס���롱�Ĺ�ѡ��
		JCheckBox component8 = new JCheckBox("�Զ���¼");
		// ���8���û��ġ��Զ���¼���Ĺ�ѡ��
		JButton component9 = new JButton("��ȫ��¼");
		// ���8���û��ġ���ȫ��¼���İ���
		/*
		 * �Դ�����в���
		 */
		GridBagLayout gridBagLayout = new GridBagLayout(); // ʵ�������ֶ���
		jf.setLayout(gridBagLayout); // jf�����������ΪGridBagLayout����
		GridBagConstraints gridBagConstraints = new GridBagConstraints();// ʵ�����������������������й���
		gridBagConstraints.fill = GridBagConstraints.BOTH;// �÷�����Ϊ���������������ڵ�������������Ҫ��ʱ����ʾ���
		// NONE�������������С��
		// HORIZONTAL���ӿ������ʹ����ˮƽ��������������ʾ���򣬵��ǲ��ı�߶ȡ�
		// VERTICAL���Ӹ������ʹ���ڴ�ֱ��������������ʾ���򣬵��ǲ��ı��ȡ�
		// BOTH��ʹ�����ȫ��������ʾ����
		/*
		 * �ֱ�������������
		 */
		// ���1(gridx,gridy)��������Ͻ����꣬gridwidth��gridheight�����ռ�õ���������������
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.gridheight = 4;
		gridBagLayout.setConstraints(component1, gridBagConstraints);
		// ���2
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 4;
		gridBagLayout.setConstraints(component2, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component3, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component4, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component5, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component6, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component7, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component8, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagLayout.setConstraints(component9, gridBagConstraints);
		/*
		 * �������������jf���������ȥ
		 */
		jf.add(component1);
		jf.add(component2);
		jf.add(component3);
		jf.add(component4);
		jf.add(component5);
		jf.add(component6);
		jf.add(component7);
		jf.add(component8);
		jf.add(component9);

		jf.setVisible(true);
	}

}
