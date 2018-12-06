package com.newer.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class OpButton extends JButton{
    Callback callback;
    private JLabel resultLabel = new JLabel("0");
	private JLabel processLabel = new JLabel("");
	
	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}

	public void setProcessLabel(JLabel processLabel) {
		this.processLabel = processLabel;
	}
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
	public OpButton(String name) {
		super();
		setText(name);
        addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				callback.inputOp(getText());
				processLabel.setText(callback.outputProcess());
				resultLabel.setText(callback.outputResult());
			}
		});
	}
	
}
