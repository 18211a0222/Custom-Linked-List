package com.monocept.test;

import com.monocept.model.LinkedList;

public class CustomLinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insertAtPosition(2, 4);
		list.printList();
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);

		System.out.println("length of the linked list is " + list.getLength());

		System.out.println("\nthe linked list is ");
		list.printList();

		list.deleteByKey(1);

		System.out.println("\nthe linked list after deleting element with data 1 (which is head) : ");
		list.printList();

		list.deleteByKey(4);
		System.out.println("\nthe linked list after deleting element with data 4 :  ");
		list.printList();

		list.deleteByKey(10);

		System.out.println("\nthe linked list when trying to delete which is not present in the list : ");
		list.printList();

		list.deleteFirst();

		System.out.println("\nthe linked list after deleting the first element :  ");
		list.printList();

		list.deleteLast();

		System.out.println("\nthe linked list after deleting the last element : ");
		list.printList();

		list.deleteAtPosition(0);

		System.out.println("\nthe linked list after deleting the element at position zero (which is head) ");
		list.printList();

		list.deleteAtPosition(2);

		System.out.println("\nthe linked list after deleting the element at position 2");
		list.printList();

		list.deleteAtPosition(10);

		System.out.println("\nthe linked list when tried to delete position which is not present");
		list.printList();
	}
}
