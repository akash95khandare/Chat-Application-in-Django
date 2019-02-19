package com.bridgeLab.dataStructure.linkedList;


public class LinkedList {

	Node head;
	public void add(String item) {
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;
		
		if(head==null) head = newNode;
		else {
			Node tempNode = head;
			while(tempNode.next!=null) {
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
		}
	}
	
	public void remove(String item) {
		Node tempNode = head;
		Node previousNode = tempNode;
		 do{
			 if(head.data.hashCode()==item.hashCode()) {
				 head = tempNode.next;
			 }
			 else if(tempNode.data.hashCode()!=item.hashCode()) {
				previousNode = tempNode;
				tempNode = tempNode.next;
			}else {
				previousNode.next = tempNode.next;
				break;
			}
		}while(tempNode!=null);
	}	

	public boolean search(String item) {
		Node tempNode = head;
		while(tempNode!=null){
				if(tempNode.data.hashCode()==item.hashCode()) return true;
				tempNode = tempNode.next;
			}
		 return false;
	}

	public String pollFirst() {
		String str = head.data;
		head = head.next;
		return str;
	}
	
	public boolean isEmpty() {
		if(head==null) return true;
		else return false;
	}

	public int size() {
		Node tempNode = head;
		int count = 0;
		
		if(tempNode!=null) {
			while(tempNode!=null){
				count++;
				tempNode = tempNode.next;
			}
		}else return 0;
		return count;
	}

	public void display() {
		Node tempNode = head;
		while(tempNode!=null){
			System.out.print(tempNode.data+" ");
			tempNode = tempNode.next;
		}
	}
	
	public void displayHash() {
		Node tempNode = head;
		while(tempNode!=null){
			System.out.print(Math.abs(tempNode.data.hashCode())+" ");
			tempNode = tempNode.next;
		}
	}

	private void addAfter(Node previousNode,Node newNode) {
		newNode.next=previousNode.next;
		previousNode.next=newNode;
	}
	
	public void sort(String item) {
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;
		if(head==null) {
			head = newNode;
		}else {
			Node tempNode = head;
			Node previousNode=head;
			if(Math.abs(head.data.hashCode())>Math.abs(item.hashCode())) {
				newNode.next = tempNode;
				head = newNode;
			}else {
				while(true) {
					if(Math.abs(tempNode.data.hashCode())>Math.abs(item.hashCode())) {
						addAfter(previousNode, newNode);
						break;
					}
					else if(tempNode.next==null && Math.abs(tempNode.data.hashCode())<Math.abs(item.hashCode())) {
						tempNode.next=newNode;
						break;
					}
					if(tempNode.next==null) {
						break;
					}
					previousNode = tempNode;
					tempNode = tempNode.next;
				}
			}
		}
	}

	public String getLast() {
		Node tempNode = head;
		while(tempNode.next!=null) {
			tempNode = tempNode.next;
		}
		return tempNode.data;
	}
	
	public void removeLast() {
		Node tempNode = head;
		Node previousNode = tempNode;
		if(tempNode.next==null) {
			head=null;
			return;
		}
		while(tempNode.next!=null) {
			previousNode = tempNode;
			tempNode = tempNode.next;
		}
		previousNode.next=null;
	}
}