package com;

import java.util.ArrayList;

public class Solution {
	private int n;
	private int m;
	private Stack<Integer> stack[][];
	private String operations;

	private int BL;
	private int BR;
	private int BU;
	private int BD;

	public Solution(int n2, int m2) {
		n = n2;
		m = m2;
		stack = new Stack[n][m];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				stack[i][j] = new Stack<Integer>();
			}
		}
		this.operations = "";
		BL = 0;
		BR = m - 1;
		BU = 0;
		BD = n - 1;
	}
	
	/*
	 * Performs the Left Operation.
	 */
	private final void rotateL() {
		// Puts Left most to second stack;
		// Don't ensure anything.
		int j = BL;
		for (int i = BU; i <= BD; ++i) {
			while (!stack[i][j].empty()) {
				int g = stack[i][j].pop();
				stack[i][j + 1].push(-g);
			}
		}
		BL = j + 1;
	}
	/*
	 * Performs the Right Operation
	 */
	private final void rotateR() {
		int j = BR;
		for (int i = BU; i <= BD; ++i) {
			while (!stack[i][j].empty()) {
				int g = stack[i][j].pop();
				stack[i][j - 1].push(-g);
			}
		}
		BR = j - 1;
	}
	
	/*
	 * Performs the Top Operation
	 */
	private final void rotateT() {
		int i = BU;
		for (int j = BL; j <= BR; ++j) {
			while (!stack[i][j].empty()) {
				int g = stack[i][j].pop();
				stack[i + 1][j].push(-g);
			}
		}
		BU = i + 1;
	}

	private final void rotateB() {
		int i = BD;
		for (int j = BL; j <= BR; ++j) {
			while (!stack[i][j].empty()) {
				int g = stack[i][j].pop();
				stack[i - 1][j].push(-g);
			}
		}
		BD = i - 1;
	}
	
	/*
	 * Executes the Rotations
	 */
	private final void solve() {
		for (int i = 0; i < operations.length(); i++) {
			char c = operations.charAt(i);
			switch (c) {
			case 'T':
				rotateT();
				break;
			case 'B':
				rotateB();
				break;
			case 'L':
				rotateL();
				break;
			case 'R':
				rotateR();
				break;
			default:
				break;
			}
		}
	}
	// Pushes an Element into the stack at index (i,j);
	public void push(int i, int j, int x) {
		stack[i][j].push(x);
	}

	public void setOperations(String r) {
		this.operations = r;
	}

	public void print() {
		this.solve();
		assert (BL == BR);
		assert (BU == BD);
		int i = BU;
		int j = BL;
		ArrayList<Integer> put = new ArrayList<>();
		while (!stack[i][j].empty()) {
			int g = stack[i][j].pop();
			if(g > 0)
				continue;
			put.add(g);
		}
		for(i = put.size() - 1; i >= 0; i--) {
			int e = put.get(i);
			String g = Card.to_string(e);
			System.out.print(g);
			if(i > 0)
				System.out.print(" ");
		}
		System.out.println();
	};

}
