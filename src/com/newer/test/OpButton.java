package com.newer.test;

import javax.swing.JButton;

public class OpButton extends JButton{
    Callback callback;
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
	public OpButton(String name) {
		super();
		setText(name);
		// TODO Auto-generated constructor stub
	}
	
}
