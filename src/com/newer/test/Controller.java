package com.newer.test;

import java.math.BigDecimal;
import java.util.Stack;

public class Controller implements Callback {
   
	Stack<String> input = new Stack<String>();
	Stack<BigDecimal> numberStack = new Stack<BigDecimal>();
	Stack<String> opStack = new Stack<String>();
	
	
	@Override
	public void inputString(String number) {
		// 输入时可能发生异常。	
		input.push(number);
	}
	
	@Override
	public void inputOp(String op) {
		// 输入时可能发生异常
		opStack.push(op);
	}
	
	public void intputNumberStack() {
		StringBuilder builder = new StringBuilder();
		while(!input.isEmpty()) {
			builder.append(input.pop());
		}
		builder.reverse();
//		numberStack.push(BigDecimal);
	}
	
	
			
	
}
