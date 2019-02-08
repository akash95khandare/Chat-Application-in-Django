package com.bridgelab.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;


public class WordList {

	String[] word;
	String str;
	
	public String[] insertionSortStr(String [] arr, int start, int end) {
		for(int i=1; i<=end; i++)
			for(int j=i-1; j>=0; j--) {
				if(Math.abs(arr[j].hashCode())>Math.abs(arr[j+1].hashCode())) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		return arr;
	}

	public int binarySearchStr(String[] arr,int start, int end, String key) {
		int mid;
		while(start<end) {
			mid = (start+end)/2;
			if(Math.abs(arr[mid].hashCode())<Math.abs(key.hashCode())) start = mid + 1;
			else if(Math.abs(arr[mid].hashCode())>Math.abs(key.hashCode())) end = mid -1;
			else if(arr[mid].hashCode()==key.hashCode()) return mid;
		}
		return -1;
	}
	
	public void getWord(String key) {
		File fr = new File("abc.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fr));
			str = br.readLine();
			while(br.readLine()!=null) {
				str = str+br.readLine();
			}
			word = str.split(" ");
		} catch(Exception e) {
			e.printStackTrace();
		}
		UtilityClass u = new UtilityClass();
		word = insertionSortStr(word, 0, word.length-1);
		u.displayStringArr(word);
		System.out.println();
		if(binarySearchStr(word, 0, word.length-1, key)!=-1) System.out.println("\nWord found..");
		else System.out.println("\nWord did not found..");
	}
}
