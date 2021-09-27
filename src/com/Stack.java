package com;
/*
 * Implement Using a Singly Linked List.
 * The First element is the head;
 */
public class Stack<T> {
	/*
	 * Represents a single node in the linked list.
	 */
	private class node {
		T value;
		node next;

		node(T d) {
			this.value = d;
			next = null;
		}
	}
	// The head of the Stack, i.e the first element.
	public node head = null;

	// Push an element into the stack.
	public void push(T x) {
		node r = new node(x);
		if (head == null) {
			head = r;
			return;
		}
		node l = lastNode();
		l.next = r;
	}
	// Helper function to the get the last element of the stack.
	private node lastNode() {
		assert (head != null);
		node l = head;
		while (l.next != null)
			l = l.next;
		return l;
	}
	// 
	public T pop() {
		assert (head != null);
		node l = head;
		if (head.next == null) {
			T v = head.value;
			head = null;
			return v;
		} else {
			while (l.next.next != null) {
				l = l.next;
			}
			T v = l.next.value;
			l.next = null;
			return v;
		}
	}

	public T peek() {
		assert (head != null);
		node l = lastNode();
		return l.value;
	}

	public boolean empty() {
		return (head == null);
	}
}
