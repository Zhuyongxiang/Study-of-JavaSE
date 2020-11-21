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
		setLayout(flowLayout);//设置布局
		
		JComboBox<String> comboBox = new JComboBox<>();// 创建一个下拉菜单
		comboBox.setPreferredSize(new Dimension(100, 20));//设置下拉菜单的宽度、高度
		
		for (int i = 1; i < 6; i++) {// 通过循环添加选项
			comboBox.addItem("选项" + i);
		}
		comboBox.addItemListener(new ItemListener() {// 添加选项事件监听器
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();// 获得事件类型
				String item = e.getItem().toString();// 获得触发此次事件的选项
				if (stateChange == ItemEvent.SELECTED) {// 查看是否由选中选项触发
					System.out.println("此次事件由      选中  选项“" + item + "”触发！");
					// 查看是否由取消选中选项触发
				} else if (stateChange == ItemEvent.DESELECTED) {
					System.out.println("此次事件由  取消选中  选项“" + item + "”触发！");
				} else {// 由其他原因触发
					System.out.println("此次事件由其他原因触发！");
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
