import java.util.Scanner;

/**
 * Author: Hemant Tripathi
 */


public class LinkList {
	
	public static void main(String[] args) {
		boolean isResume = true;
		Node headerNode = new Node();
		while(isResume) {
			System.out.println("Selection an option...");
			System.out.println("1. Add a node at the beginning of list");
			System.out.println("2. Add a node in the middle of list");
			System.out.println("3. Add a node at the end of list");
			System.out.println("4. Remove a node from the start of list");
			System.out.println("5. Remove a node from the middle of list");
			System.out.println("6. Remove a node from the end of list");
			System.out.println("7. Show all nodes of the list");
			System.out.println("8. Exit");
			
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			
			switch(num) {
				case 1:
					System.out.println("Enter node into beginning of list:");
					int data = in.nextInt();
					Node startNode = new Node(data);
					headerNode.addNodeToBeinning(startNode);
					System.out.println("Node added successfully!");
					break;
				
				case 2:
					System.out.println("Enter the data for Node:");
					int nodeData = in.nextInt();
					System.out.println("Enter the position of node in the list:");
					int position = in.nextInt();
					Node newNode = new Node(nodeData);
					boolean isAdded = headerNode.addToPosition(newNode, position);
					if(isAdded) {
						System.out.println("Node added successfully!");
					} else {
						System.out.println("Unable to add the node!");
					}
					break;
					
				case 3:
					System.out.println("Enter the data for Node:");
					int nodeValue = in.nextInt();
					Node endNode = new Node(nodeValue);
					headerNode.addToEnd(endNode);
					System.out.println("Node added successfully!");
					break;
					
				case 4:
					System.out.println("Remove node from beginning:");
					boolean success = headerNode.removeNodeFromStart();
					if(success) {
						System.out.println("Removed first Node");
					} else {
						System.out.println("Unable to remove first Node.");
					}
					break;
					
				case 5:
					System.out.println("Removing node from a position");
					System.out.println("Enter the position of node in the list:");
					int nodePosition = in.nextInt();
					boolean isRemoved = headerNode.removeNodeFromPosition(nodePosition);
					if(isRemoved) {
						System.out.println("Removed Node");
					} else {
						System.out.println("Unable to remove first Node.");
					}
					break;
					
				case 6:
					
					break;
					
				case 7:
					System.out.println("Displaying all nodes!");
					headerNode.showAllNodes();
					break;
					
				case 8:
					isResume = false;
					break;
			}
		}
	}
	
	static class Node {
		int data;
		Node next = null;
		
		public Node() {
			
		}
		
		public Node(int d) {
			data = d;
		}
		
		public void addToEnd(Node endNode) {
			Node header = this;
			while(header.next != null) {
				header = header.next;
			}
			header.next = endNode;
		}
		
		public boolean addToPosition(Node newNode, int position) {
			Node header = this;
			int counter = 0;
			while(header.next != null && counter < position-1) {
				counter++;
				header = header.next;
			}
			if(counter < position-1) {
				return false;
			} else {
				newNode.next = header.next;
				header.next = newNode;
				return true;
			}
		}
		
		public void addNodeToBeinning(Node newNode) {
			Node header = this;
			newNode.next = header.next;
			header.next = newNode;
		}
		
		public boolean removeNodeFromStart() {
			Node header = this;
			Node deleteNode = null;
			if(header.next != null) {
				deleteNode = header.next;
				header = deleteNode.next;
				this.next = header;
				deleteNode.next = null;
				deleteNode = null;
				return true;
			} else {
				return false;
			}
		}
		
		public boolean removeNodeFromPosition(int position) {
			Node header = this;
			Node deleteNode = null;
			int counter = 0;
			if(header.next != null) {
				deleteNode = header.next;
			}
			while(header.next != null && counter < position-1) {
				counter++;
				header = header.next;
			}
			if(counter < position-1) {
				return false;
			} else {
				deleteNode = header.next;
				header = deleteNode.next;
				this.next = header;
				deleteNode.next = null;
				deleteNode = null;
				return true;
			}
		}
		
		public void showAllNodes() {
			Node header = this;
			System.out.println("LinkList is: ");
			while(header.next != null) {
				header = header.next;
				System.out.println("  "+header.data);
			}
		}
	}

}
