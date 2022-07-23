package com.monocept.model;

import com.monocept.test.Node;

public class LinkedList {

	Node head;

	public void insert(int data) {

		Node new_node = new Node(data);
		new_node.setNext(null);

		if (head == null) {
			head = new_node;
		} else {
			Node last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}

			last.setNext(new_node);
		}
	}

	public void insertAtPosition(int position, int data) {
		if (position < 1 || position > getLength()) {
			System.out.print("Invalid position");
		} else if (position == 1) {
			Node new_node = new Node(data);
			new_node.setNext(head);
			head = new_node;
		} else {
			while (position-- != 0) {
				if (position == 1) {
					Node new_node = new Node(data);

					new_node.setNext(head.getNext());

					head.setNext(new_node);
					break;
				}
				head = head.getNext();
			}
		}
		System.out.println(
				"\nlinked list after adding the element with data " + data + " at position " + position++ + " is ");
	}

	public void printList() {
		Node currNode = head;

		System.out.print("\nLinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.getData() + " ");

			currNode = currNode.getNext();
		}
		System.out.println("\n");
	}

	public void deleteByKey(int key) {

		Node currNode = head, prev = new Node();

		if (currNode != null && currNode.getData() == key) {
			head = currNode.getNext();
		}
		
		while (currNode != null && currNode.getData() != key) {
			prev = currNode;
			currNode = currNode.getNext();
		}

		if (currNode != null) {
			prev.setNext((currNode.getNext()));
			System.out.println(key + " found and deleted");
		}
		if (currNode == null) {
			System.out.println(key + " not found");
		}

	}

	public void deleteAtPosition(int index) {
		Node currNode = head, prev = new Node();

		if (index == 0 && currNode != null) {
			head = currNode.getNext();
		}

		int counter = 0;

		while (currNode != null) {

			if (counter == index) {
				prev.setNext((currNode.getNext()));
				System.out.println(index + " position element deleted");
				break;
			} else {
				prev = currNode;
				currNode = currNode.getNext();
				counter++;
			}
		}

		if (currNode == null) {
			System.out.println(index + " Index out of bounds");
		}
	}

	public void deleteFirst() {
		deleteAtPosition(0);
	}

	public void deleteLast() {
		deleteAtPosition(getLength() - 1);
	}

	public int getLength() {
		int counter = 0;
		Node currNode = head;

		while (currNode != null) {
			currNode = currNode.getNext();
			counter++;
		}
		return counter;
	}
}
