package com.newer.test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {
	String mark;
	String result;
	
//	public static void main(String[] args) {
//		Calculator calculator = new Calculator();
//		System.out.println(calculator.computer("123","+", "123"));
//		
//	}
//	
	
	// 中缀表达式转换成后缀表达式,返回的是一个后缀表达式的队列
	public LinkedList<String> toPostfix(LinkedList<String> nifix)  {
		Stack<String> opStack = new Stack<>();
		LinkedList<String> postfix = new LinkedList<>();
		Pattern pattern = Pattern.compile("\\+|-|\\*|/");
		for(String str: nifix)  {
			if(!pattern.matcher(str).matches()) {
				postfix.add(str);
			}
			else {
				if(opStack.isEmpty()) {
					opStack.push(str);
				}
				else {
					// 比较当前的 栈顶字符 和  str 的大小关系。
					while(!opStack.isEmpty()&&precedence(opStack.peek(),str)>=0) {
						postfix.add(opStack.pop());
					}
					opStack.push(str);
				}
			}
		}
		while(!opStack.isEmpty()) {
			postfix.add(opStack.pop());
		}
		return postfix;
	}
	
	public String computer(String a,String mark,String b)  {
		BigDecimal frist = new BigDecimal(a);
		BigDecimal next = new BigDecimal(b);
		switch(mark)  {
		case "+":
			result=String.valueOf(frist.add(next));
			break;
		case "-":	
			result=String.valueOf(frist.subtract(next));
			break;
		case "*":
			result=String.valueOf(frist.multiply(next));
			break;
		case "/":
			result=String.valueOf(frist.divide(next));
			break;
		}
		return result;
 	}
	
	
	// 用LinkedList列表实现队列的功能,计算后缀表达式的结果。
	public String postfixResult(LinkedList<String> postfix) {
		Stack<String> numberStack = new Stack<>();
		Pattern pattern = Pattern.compile("\\+|-|\\*|/");
		
		for(String str:postfix) {
			if(!pattern.matcher(str).matches()) {
				numberStack.push(str);
			}
			else {
				String next = numberStack.pop();
				String frist = numberStack.pop();
				result = computer(frist,str,next);
				numberStack.push(result);
			}
		}
		return numberStack.pop();
	}
	
	public String nitoPostfixtoResult(LinkedList<String> nifix) {
		result=postfixResult(toPostfix(nifix));
		return result;
	}
	
	// 判断运算符的优先级----其实可以使用带判断大小的枚举更好一些。
	public int precedence(String first,String next) {
		int number_1=0;
		int number_2=0;
		switch(first) {
		case "+":
			number_1=1;
			break;
		case "-":	
			number_1=1;
			break;
		case "*":
			number_1=2;
			break;
		case "/":
			number_1=2;
			break;
		}
		switch(next) {
		case "+":
			number_2=1;
			break;
		case "-":	
			number_2=1;
			break;
		case "*":
			number_2=2;
			break;
		case "/":
			number_2=2;
			break;
		}
		return number_1==number_2?0:number_1-number_2;
	}
		
}
