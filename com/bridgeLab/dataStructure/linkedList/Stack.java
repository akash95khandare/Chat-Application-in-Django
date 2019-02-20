package com.bridgeLab.dataStructure.linkedList;

import com.bridgeLab.dataStructure.linkedList.LinkedList;

public class Stack {

	LinkedList stack = new LinkedList();
	public void push(String item) {
		stack.add(item);
	}
	
	public void pop() {
		stack.removeLast();
	}
	
	public String peak() {
		if(stack.isEmpty()) return "-1";
		String str = stack.getLast();
		return str;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.size();
	}
}
