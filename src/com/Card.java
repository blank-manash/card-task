package com;

/*
 * A Card Interface.
 */

public class Card {

	private final static Character deck[] = { 'C', 'D', 'H', 'S' };
	private final static Character card[] = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };

	public static Integer toInt(String str) {
		char a = str.charAt(0);
		char b = str.charAt(1);
		char c = str.charAt(2);
		int v = 13 * find_index(deck, b) + find_index(card, c);
		if (a == 'F')
			v = -v;
		return v;
	}

	public static String to_string(int v) {
		String ret = "U";
		if (v < 0)
			ret = "F";
		v = Math.abs(v);
		ret = ret + String.valueOf(deck[v / 13]) + String.valueOf(card[v % 13]);
		return ret;
	}

	private static int find_index(Character ar[], char c) {
		for (int i = 0; i < ar.length; ++i) {
			if (Character.compare(c, ar[i]) == 0)
				return i;
		}
		return -1;
	}

}
