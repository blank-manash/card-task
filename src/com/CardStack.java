package com;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Main Class To start the function.
 */
public class CardStack {

	public static void main(String[] args) {
		ArrayList<Solution> testCases = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0)
				break;
			
			// Add the card-box;
			Solution t = new Solution(n, m);
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					String g = sc.next();
					int z = Card.toInt(g);
					t.push(i, j, z);
				}
			}
			// Add Operations;
			String opr = sc.next();
			t.setOperations(opr);
			
			testCases.add(t);
		}
		sc.close();
		for (Solution s : testCases) {
			s.print();
		}
	}

}
