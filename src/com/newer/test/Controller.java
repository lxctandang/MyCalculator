package com.newer.test;

import java.util.LinkedList;
import java.util.Stack;

public class Controller implements Callback {
	Calculator calculator;

	// 保存存储过程和结果的缓冲字符串
	StringBuilder process = new StringBuilder("");
	StringBuilder result = new StringBuilder("请先输入数字，进行计算");

	// 定义了两个标志
	boolean pointflag = true;
	boolean opflag = false;
	boolean errorflag = false;
	boolean flag = true;

	Stack<String> inputNumber = new Stack<String>();

	LinkedList<String> numberOp = new LinkedList<String>();

	@Override
	public void inputNumber(String number) {
		// 判断数字是否是正规输入。
		if(flag) {
			result.delete(0, result.length());
			flag = false;
		}
		if (number.equals(".")) {
			if (pointflag && !inputNumber.isEmpty()) {
				inputNumber.push(number);
				result.append(number);
				pointflag = false;
			} else {
				process.delete(0, process.length());
				process.append("错误小数点，请重新输入");
				errorflag = true;
			}
		} else {
			inputNumber.push(number);
			result.append(number);
			errorflag = false;
			opflag = true;
		}
	}

	@Override
	public void inputOp(String op) {
		if (op.equals("C")) {
			myClear();
		}
		else if (op.equals("<")) {
			myBack();
		}
		else if (inputNumber.isEmpty() || !opflag) {
			process.delete(0, process.length());
			process.append("错误运算符，请重新输入");
			errorflag = true;
		} else {
			StringBuilder text = new StringBuilder("");
			while (!inputNumber.isEmpty()) {
				text.append(inputNumber.pop());
			}
			text.reverse();
			numberOp.add(text.toString());
			if (op.equals("=")) {
				result.delete(0, result.length());
				result.append(calculator.nitoPostfixtoResult(numberOp));
			} else {
				numberOp.add(op);
				result.delete(0, result.length());
			}
			pointflag = true;
			opflag = false;
		}
	}

	@Override
	public String outputProcess() {
		// TODO Auto-generated method stub
		if (!errorflag) {
			process.delete(0, process.length());
			for (String str : numberOp) {
				process.append(str);
			}
		}
		return process.toString();
	}

	public void myClear()  {
		pointflag = true;
		opflag = false;
		errorflag = false;
		flag = true;
		inputNumber.clear();
		numberOp.clear();
		process.delete(0, process.length());
		result.delete(0, result.length());
		result.append("请先输入数字，进行计算");
	}
	
	public void myBack() {
		if(numberOp.size()==0&&result.length()==1) {
			result.delete(0, result.length());
			inputNumber.pop();
			result.append("请先输入数字，进行计算");
			flag = true;
		}
		else if(!inputNumber.isEmpty()) {
			inputNumber.pop();
			result.delete(result.length()-1, result.length());
		}
	}
	@Override
	public String outputResult() {
		return result.toString();
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

}
