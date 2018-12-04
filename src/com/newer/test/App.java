package com.newer.test;

public class App {
	public static void main(String[] args) {
		Controller controll = new Controller();

		MyFrame myframe = new MyFrame();
		myframe.setCallback(controll);
	}
}
