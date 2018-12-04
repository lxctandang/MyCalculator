package com.newer.test;

import javax.swing.JButton;

public class NumberButton extends JButton{
	
	Callback callback;
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}


	public NumberButton(String name) {
		super();
		setText(name);
		
		// TODO Auto-generated constructor stub
	}
	
	

}
