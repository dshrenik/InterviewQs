package Misc;

import java.util.Stack;

public class LinkedList {
	
	public class Link {

		public int value;
		public Link next;

		public Link(int value) {
			this.value = value;
		}

	}
	
	Link head;

	public void addFront(int value) {

		Link newLink = new Link(value);
		if(head == null) {
			head = newLink;
		}
		else {
			newLink.next = head;
			head = newLink;
		}
	}
	
	public Link find(int key) {
		Link current = head;
		
		while(current != null) {
			if(current.value == key) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public Link delete(int key) {
		if(head != null) {
			Link current = head;
			Link previous = head;
			
			while(current != null) {
			
				if(current.value == key) {
					if(current == head) {
						head = head.next;
						return current;
					}
					else {
						previous.next = current.next;
						return current;
					}
				}
				
				previous = current;
				current = current.next;
				
			}
			
		}
		
		return null;
	}
	
	public void display() {
		Link current = head;
		while(current != null) {
			System.out.print(current.value + "  ");
			current = current.next;
		}
		System.out.println();
	}

	public Link nthToLast(int n) {
		Link p1 = head;
		Link p2 = head;
		
		for(int i=0; i<n; i++) {
			if(p2==null) {
				return null;
			}
			p2 = p2.next;
		}
		
		if(p2 == null) {
			return null;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}

	public void reverse() {
		Link newHead = null;
		Link previous = this.head;
		Link current = this.head;

		while(current != null) {
			previous = current;
			current = current.next;

			previous.next = newHead;
			newHead = previous;
		}

		this.head = newHead;
	}
	
	// Not working
	public Link reverseRecursive(Link head) {
		
		if(head == null || head.next==null) {
			return head;
		}
		
		Link rest = head.next;
		head.next = null;
		Link a = reverseRecursive(rest);
		rest.next = head;
		
		return a;
	}
	
	// Not working
	public void swapKthFromBeginningAndKthFromEnd(int k) {
		Link start = head;
		Link end = head;
		Link runner = head;
		
		for(int i=0; i<(k-1); i++) {
			start = start.next;
			runner = runner.next;
		}
		
		while(runner.next != null) {
			end = end.next;
			runner = runner.next;
		}

		Link t1 = start;
		Link t2 = start.next;
		Link t3 = start.next.next;
		
		Link t4 = end;
		Link t5 = end.next;
		Link t6 = end.next.next;

		start.next = t5;
		start.next.next = t3;

		end.next = t2;
		end.next.next = t6;
	}
	
	public void swapTwoConsecutiveNodes() {
		
		if(head == null || head.next == null) {
			return;
		}
		
		Link temp1 = head;
		Link temp2 = head.next;
		
		temp1.next = temp2.next;
		head = temp2;
		temp2.next = temp1;
		
		Link prev, a, b;
		a = head.next;

		while(true) {
			prev = a;
			a = prev.next;
			if(a == null) {
				return;
			}
			b = a.next;
			if(b == null) {
				return;
			}

			Link temp = b.next;

			prev.next = b;
			b.next = a;
			a.next = temp;
		}

	}

	// Not working
	public void reverseK(int k) {
		Link previous = this.head;
		Link current = this.head;

		Link head = null;
		Link tail = null;
		
		while(current != null) {

			Link newHead = null;
			Link newTail = null;
			
			for(int i=0; i<k && current != null; i++) {
				previous = current;
				current = current.next;

				previous.next = newHead;
				newHead = previous;
				if(tail==null) {
					tail = previous;
				}
				if(newTail==null) {
					newTail = previous;
				}
			}
			
			if(head == null) {
				head = newHead;
			}
			
			tail.next = newHead;
			tail = newTail;

		}

		this.head = head;
	}

	public void printNthNodeFromEnd(int n) {
		Link runner = head;
		Link current = head;

		for(int i=0; i<n; i++) {
			if(runner == null) {
				return;
			}
			runner = runner.next;
		}

		while(runner != null) {
			current = current.next;
			runner = runner.next;
		}

		System.out.println(current.value);
	}

	// Incomplete
	public boolean isPalindrome() {

		Link current = head;
		Link runner = head;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(head.value);
		
		while(runner.next != null) {
			runner = runner.next;
			if(runner.next == null) {
				break;
			}
			runner = runner.next.next;
			if(runner.next == null) {
				break;
			}
			current = current.next;
			
			stack.push(current.value);
		}

		return true;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.addFront(8);
		list.addFront(7);
		list.addFront(6);
		list.addFront(5);
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);

//		list.delete(4);
		
		list.display();
		
//		list.reverse();
//		list.display();
		
//		list.reverseK(7);
//		System.out.println();
//		list.display();
		
//		list.printNthNodeFromEnd(1);
		
//		list.swapKthFromBeginningAndKthFromEnd(3);
//		list.display();
		
		list.swapTwoConsecutiveNodes();
		list.display();
		
//		System.out.println();
//		Link rev = list.reverseRecursive(list.head);
//		while(rev != null) {
//			System.out.print(rev.value + "  ");
//		}
		
		
//		list.display();
		
//		System.out.println(list.find(3));
		
//		System.out.println();
//		System.out.println(list.nthToLast(0).value);
		
		
	}

}

