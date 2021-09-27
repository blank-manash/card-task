package com;

import java.util.Scanner;

public class Solution {
	private int n;
	private int m;
	private Stack<Integer> stack[][];
	private String operations;
	
	public Solution(int n2, int m2) {
		n = n2;
		m = m2;
		stack = new Stack[n][m];
		this.operations = "";
	}
	
	
	public void push(int i, int j, int x) {
		stack[i][j].push(x);
	}

	
	public void setOperations(String r) {
		this.operations = r;
	}
	public void print() {};
	
	
}
