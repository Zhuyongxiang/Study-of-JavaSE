package pers.zyx.swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QQLogin extends JFrame implements ActionListener {
	JButton m_loginButton;	//登录按钮

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQLogin app = new QQLogin();
		app.go();
	}

	public void go() {
		setTitle("QQ");
		setSize(395, 305);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置背景图片
		ImageIcon bg = new ImageIcon("pictures/星空.jpg");
		JLabel label = new JLabel(bg);
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		getLayeredPane().add(label, new Integer(-30001)); // Integer.MIN_VALUE
		//得到的是一个容器 (Container)对象,可以为容器添加了深度,允许组件在需要时互相重叠
		
		
		// 设置ContentPane透明
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setOpaque(false);	//是否透明

		// contentPane = topPanel + buttonPanel
		
		//contentPane布局方式
		contentPane.setLayout(new BorderLayout());
		
		JPanel topPanel = getTopPanel();
		topPanel.setOpaque(false);
		contentPane.add(topPanel, "Center");		//topPanel位于中间
		JPanel buttonPanel = getButtonPanel();
		contentPane.add(buttonPanel, "South");		//buttonPanel位于南边

		setVisible(true);
	}

	private JPanel getTopPanel() {
		// topPanel = blank + userInfoPanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));	//TopPanel采用2行1列布局
		panel.add(new JLabel(" "));		//在userInfo上面添加一个空标签（第一行）
		JPanel userInfo = getUserInfoPanel();	//userInfo位于第二行
		userInfo.setOpaque(false);
		panel.add(userInfo);
		return panel;
	}

	private JPanel getUserInfoPanel() {
		JPanel userInfoPanel = new JPanel();
		// userInfoPanel = 头像 + accountPanel + registerPanel
		userInfoPanel.setLayout(new FlowLayout());
		// 1、头像
		JLabel pic = new JLabel(new ImageIcon("pictures/头像.jpg"));
		userInfoPanel.add(pic);
		// 2、用户名、密码、参数信息
		JPanel accountPanel = getAccountPanel();
		accountPanel.setOpaque(false);
		userInfoPanel.add(accountPanel);
		// 3、注册和找回密码按钮
		JPanel registerPanel = getRegisterPanel();
		registerPanel.setOpaque(false);
		userInfoPanel.add(registerPanel);
		return (userInfoPanel);
	}

	private JPanel getAccountPanel() {
		JPanel accountPanel = new JPanel();

		// accountPanel = user + password + checkPanel
		accountPanel.setLayout(new BorderLayout(0, 5));
		// 1.用户帐号
		String[] ids = { "535516201                        ", "15887002414                        ",
				"382195495                        " };
		JComboBox<String> user = new JComboBox<String>(ids);	//用户名下拉列表组件
		user.setEditable(true);	//设置下拉列表框是否可编辑
		accountPanel.add(user, "North");

		// 2.密码
		JPasswordField password = new JPasswordField(15);
		accountPanel.add(password, "Center");

		// 3.设置复选框
		JPanel checkPanel = getCheckPanel();
		checkPanel.setOpaque(false);
		accountPanel.add(checkPanel, "South");

		return (accountPanel);
	}

	private JPanel getCheckPanel() {		//获取记住密码和自动登录复选框
		JPanel checkPanel = new JPanel();

		// checkPanel = check1 + check2
		checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.X_AXIS));
		Font font = new Font("宋体", Font.BOLD, 12);
		JCheckBox check1 = new JCheckBox("记住密码", true);
		check1.setFont(font);
		checkPanel.add(check1);

		JCheckBox check2 = new JCheckBox("自动登录", false);
		check2.setFont(font);
		checkPanel.add(check2);
		
		return (checkPanel);
	}

	private JPanel getRegisterPanel() {			//注册账号和找回密码
		JPanel registerPanel = new JPanel();
//		registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));
		registerPanel.setLayout(new GridLayout(3, 1));
		// registerPanel = button1 + button2
		JButton button1=new JButton("注册账号");
		button1.setForeground(Color.white);
		button1.setBorderPainted(false);		//是否有边框
		button1.setFocusPainted(false);			//是否绘制焦点
		button1.setContentAreaFilled(false);	//是否填充
//		button1.setAlignmentX(Component.LEFT_ALIGNMENT);	//设置对齐方式
		registerPanel.add(button1);
		button1.addActionListener(this);
		JButton button2=new JButton("找回密码");
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

	private JPanel getButtonPanel() {	//多账号登录、登录、二维码登录
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout(50, 0));

		// buttonPanel = button1 + button2
		JButton button1 = new JButton(new ImageIcon("pictures/多账号登录.jpg"));
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setContentAreaFilled(false);
		buttonPanel.add(button1, "West");
		button1.addActionListener(this);

		m_loginButton = new JButton("      登           录      ");
		buttonPanel.add(m_loginButton, "Center");
		m_loginButton.addActionListener(this);

		JButton button2 = new JButton(new ImageIcon("pictures/二维码登录.jpg"));
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
