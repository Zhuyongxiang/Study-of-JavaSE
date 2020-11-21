package pers.zyx.swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QQLogin extends JFrame implements ActionListener {
	JButton m_loginButton;	//��¼��ť

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQLogin app = new QQLogin();
		app.go();
	}

	public void go() {
		setTitle("QQ");
		setSize(395, 305);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ñ���ͼƬ
		ImageIcon bg = new ImageIcon("pictures/�ǿ�.jpg");
		JLabel label = new JLabel(bg);
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		getLayeredPane().add(label, new Integer(-30001)); // Integer.MIN_VALUE
		//�õ�����һ������ (Container)����,����Ϊ������������,�����������Ҫʱ�����ص�
		
		
		// ����ContentPane͸��
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setOpaque(false);	//�Ƿ�͸��

		// contentPane = topPanel + buttonPanel
		
		//contentPane���ַ�ʽ
		contentPane.setLayout(new BorderLayout());
		
		JPanel topPanel = getTopPanel();
		topPanel.setOpaque(false);
		contentPane.add(topPanel, "Center");		//topPanelλ���м�
		JPanel buttonPanel = getButtonPanel();
		contentPane.add(buttonPanel, "South");		//buttonPanelλ���ϱ�

		setVisible(true);
	}

	private JPanel getTopPanel() {
		// topPanel = blank + userInfoPanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));	//TopPanel����2��1�в���
		panel.add(new JLabel(" "));		//��userInfo�������һ���ձ�ǩ����һ�У�
		JPanel userInfo = getUserInfoPanel();	//userInfoλ�ڵڶ���
		userInfo.setOpaque(false);
		panel.add(userInfo);
		return panel;
	}

	private JPanel getUserInfoPanel() {
		JPanel userInfoPanel = new JPanel();
		// userInfoPanel = ͷ�� + accountPanel + registerPanel
		userInfoPanel.setLayout(new FlowLayout());
		// 1��ͷ��
		JLabel pic = new JLabel(new ImageIcon("pictures/ͷ��.jpg"));
		userInfoPanel.add(pic);
		// 2���û��������롢������Ϣ
		JPanel accountPanel = getAccountPanel();
		accountPanel.setOpaque(false);
		userInfoPanel.add(accountPanel);
		// 3��ע����һ����밴ť
		JPanel registerPanel = getRegisterPanel();
		registerPanel.setOpaque(false);
		userInfoPanel.add(registerPanel);
		return (userInfoPanel);
	}

	private JPanel getAccountPanel() {
		JPanel accountPanel = new JPanel();

		// accountPanel = user + password + checkPanel
		accountPanel.setLayout(new BorderLayout(0, 5));
		// 1.�û��ʺ�
		String[] ids = { "535516201                        ", "15887002414                        ",
				"382195495                        " };
		JComboBox<String> user = new JComboBox<String>(ids);	//�û��������б����
		user.setEditable(true);	//���������б���Ƿ�ɱ༭
		accountPanel.add(user, "North");

		// 2.����
		JPasswordField password = new JPasswordField(15);
		accountPanel.add(password, "Center");

		// 3.���ø�ѡ��
		JPanel checkPanel = getCheckPanel();
		checkPanel.setOpaque(false);
		accountPanel.add(checkPanel, "South");

		return (accountPanel);
	}

	private JPanel getCheckPanel() {		//��ȡ��ס������Զ���¼��ѡ��
		JPanel checkPanel = new JPanel();

		// checkPanel = check1 + check2
		checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.X_AXIS));
		Font font = new Font("����", Font.BOLD, 12);
		JCheckBox check1 = new JCheckBox("��ס����", true);
		check1.setFont(font);
		checkPanel.add(check1);

		JCheckBox check2 = new JCheckBox("�Զ���¼", false);
		check2.setFont(font);
		checkPanel.add(check2);
		
		return (checkPanel);
	}

	private JPanel getRegisterPanel() {			//ע���˺ź��һ�����
		JPanel registerPanel = new JPanel();
//		registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
		registerPanel.setLayout(new GridLayout(3, 1));
		// registerPanel = button1 + button2
		JButton button1=new JButton("ע���˺�");
		button1.setForeground(Color.white);
		button1.setBorderPainted(false);		//�Ƿ��б߿�
		button1.setFocusPainted(false);			//�Ƿ���ƽ���
		button1.setContentAreaFilled(false);	//�Ƿ����
//		button1.setAlignmentX(Component.LEFT_ALIGNMENT);	//���ö��뷽ʽ
		registerPanel.add(button1);
		button1.addActionListener(this);
		JButton button2=new JButton("�һ�����");
		button2.setForeground(Color.white);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);
//		button2.setAlignmentX(Component.LEFT_ALIGNMENT);
		registerPanel.add(button2);
		
		JButton button3=new JButton();
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.setContentAreaFilled(false);
		registerPanel.add(button3);
		
		button2.addActionListener(this);

		return (registerPanel);
	}

	private JPanel getButtonPanel() {	//���˺ŵ�¼����¼����ά���¼
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(50, 0));

		// buttonPanel = button1 + button2
		JButton button1 = new JButton(new ImageIcon("pictures/���˺ŵ�¼.jpg"));
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setContentAreaFilled(false);
		buttonPanel.add(button1, "West");
		button1.addActionListener(this);

		m_loginButton = new JButton("      ��           ¼      ");
		buttonPanel.add(m_loginButton, "Center");
		m_loginButton.addActionListener(this);

		JButton button2 = new JButton(new ImageIcon("pictures/��ά���¼.jpg"));
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);
		buttonPanel.add(button2, "East");
		button2.addActionListener(this);
		return (buttonPanel);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == (Object) m_loginButton)
			JOptionPane.showMessageDialog(null, "login");
		else
			JOptionPane.showMessageDialog(null, "button pressed");
	}
}
