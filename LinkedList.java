package com.monocept.test;

public class LinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static LinkedList insert(LinkedList list, int data) {

		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}

		return list;
	}

	public static LinkedList insertAtPosition(LinkedList list, int position, int data) {
        Node head = list.head;
        if (position < 1 || position > LinkedList.getLength(list))
        {
            System.out.print("Invalid position");
        	return list;
        }	
       else if (position == 1) {
            Node new_node = new Node(data);
            new_node.next = head;
            head = new_node;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    Node new_node = new Node(data);
  
                    new_node.next = head.next;
  
                    head.next = new_node;
                    break;
                }
                head = head.next;
            }
        }
        System.out.println("\nlinked list after adding the element with data " + data + " at position " + position + " is ");
        return list;
	}
	
	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("\nLinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.data + " ");

			currNode = currNode.next;
		}
		System.out.println("\n");
	}

	public static LinkedList deleteByKey(LinkedList list, int key) {
		Node currNode = list.head, prev = null;

		if (currNode != null && currNode.data == key) {
			list.head = currNode.next;

			System.out.println(key + " found and deleted");

			return list;
		}

		while (currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}

		if (currNode != null) {
			prev.next = currNode.next;

			System.out.println(key + " found and deleted");
		}

		if (currNode == null) {
			System.out.println(key + " not found");
		}

		return list;
	}

	public static LinkedList deleteAtPosition(LinkedList list, int index) {
		Node currNode = list.head, prev = null;

		if (index == 0 && currNode != null) {
			list.head = currNode.next;

			System.out.println(index + " position element deleted");

			return list;
		}

		int counter = 0;

		while (currNode != null) {

			if (counter == index) {
				prev.next = currNode.next;

				System.out.println(index + " position element deleted");
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		if (currNode == null) {
			System.out.println(index + " Index out of bounds");
		}

		return list;
	}

	public static LinkedList deleteFirst(LinkedList list) {
		return deleteAtPosition(list, 0);
	}

	public static LinkedList deleteLast(LinkedList list) {
		return deleteAtPosition(list, LinkedList.getLength(list) - 1);
	}

	public static int getLength(LinkedList list) {
		int counter = 0;
		Node currNode = list.head;

		while (currNode != null) {
			currNode = currNode.next;
			counter++;
		}
		return counter;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insertAtPosition(list, 2, 4);
		printList(list);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

		System.out.println("length of the linked list is " + LinkedList.getLength(list));

		System.out.println("\nthe linked list is ");
		printList(list);

		deleteByKey(list, 1);

		System.out.println("\nthe linked list after deleting element with data 1 (which is head) : ");
		printList(list);

		deleteByKey(list, 4);
		System.out.println("\nthe linked list after deleting element with data 4 :  ");
		printList(list);

		deleteByKey(list, 10);

		System.out.println("\nthe linked list when trying to delete which is not present in the list : ");
		printList(list);

		deleteFirst(list);

		System.out.println("\nthe linked list after deleting the first element :  ");
		printList(list);

		deleteLast(list);

		System.out.println("\nthe linked list after deleting the last element : ");
		printList(list);

		deleteAtPosition(list, 0);

		System.out.println("\nthe linked list after deleting the element at position zero (which is head) ");
		printList(list);

		deleteAtPosition(list, 2);

		System.out.println("\nthe linked list after deleting the element at position 2");
		printList(list);

		deleteAtPosition(list, 10);

		System.out.println("\nthe linked list when tried to delete position which is not present");
		printList(list);

	}
}
