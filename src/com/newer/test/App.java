package com.newer.test;

public class App {
	public static void main(String[] args) {
		
		// 计算器的运算模型--实现加减乘除运算
		Calculator calculator = new Calculator();
		
		// 控制器
		Controller controll = new Controller();
		controll.setCalculator(calculator);
		
		MyFrame myframe = new MyFrame(controll);
		
	}
}
