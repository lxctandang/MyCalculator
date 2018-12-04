package com.newer.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class MyFrame extends JFrame {
	private JPanel backGroundPane;
	private String[] str = { "C", "<", "+/-", "/", 
			"7", "8", "9", "*", 
			"4", "5", "6", "-",
			"1", "2", "3", "+",
			"0", "？",".", "=" };
	private Callback callback;
	private JLabel resultLabel = new JLabel("0");
	private JLabel processLabel = new JLabel("");
	
	/**
	 * Create the frame.
	 */
	public MyFrame() {

		// 给窗口进行初始化。
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		setResizable(false);
		backGroundPane = new JPanel();
		backGroundPane.setBackground(Color.BLACK);
		backGroundPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		backGroundPane.setLayout(new BorderLayout(0, 0));
		setContentPane(backGroundPane);

		//添加各种组件添加各种组件
		initFrame();
	}
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
public void initFrame() {
		
		//标签面板
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(2, 1, 1, 1));
		labelPanel.setBackground(Color.BLACK);
		
        //两个标签按钮，显示运算过程和计算结果。
		processLabel.setForeground(Color.WHITE);
		processLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		processLabel.setFont(new Font("黑体", Font.PLAIN, 50));

		
		resultLabel.setForeground(Color.WHITE);
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		resultLabel.setFont(new Font("黑体", Font.PLAIN, 50));

		//把两个标签添加到面板上。
		labelPanel.add(processLabel);
		labelPanel.add(resultLabel);

		//把标签面板放置到背景面板的北部区域。
		backGroundPane.add(labelPanel, BorderLayout.NORTH);

		//创建按钮面板，放置各种不同类型的按钮。
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setLayout(new GridLayout(5, 4, 1, 1));
		backGroundPane.add(buttonPanel, BorderLayout.CENTER);
			 

		//添加按钮。
		for (int i = 0; i < str.length; i++) {
			// 按钮的初始化
			JButton tempButton = new JButton(str[i]);
			tempButton.setFont(new Font("宋体", Font.PLAIN, 40));
			tempButton.setBackground(Color.LIGHT_GRAY);
			if((i+1)%4==0) 
				tempButton.setBackground(Color.ORANGE);
			
			// 给每个按钮添加监听器
			buttonPanel.add(tempButton);
			setVisible(true);
		}
		
	}

}
