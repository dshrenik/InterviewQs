package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Tree {

	public class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static int count = 0;

	TreeNode root;

	public Tree(int value) {
		this.root = new TreeNode(value);
	}

	public TreeNode find(int key) {
		TreeNode current = root;

		while(current != null) {
			if(current.value == key) {
				return current;
			}
	
			if(key < current.value) {
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		
		return null;
	}

	public void insert(int value) {

		TreeNode newNode = new TreeNode(value);
		if(root == null) {
			root = newNode;
		}
		else {
			TreeNode current = root;
			TreeNode previous = root;

			while(true) {
				if(value < current.value) {
					current = current.left;
					if(current == null) {
						previous.left = newNode;
						return;
					}
				}
				else {
					current = current.right;
					if(current == null) {
						previous.right = newNode;
						return;
					}
				}
				previous = current;
			}

		}
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root.value);
			inorder(root.right);
		}
	}
	
	public void kthLargest(TreeNode root, int k) {
		if(root != null) {
			kthLargest(root.right, k);
			
			count++;
			
			if(count == k) {
				System.out.println(root.value);
				return;
			}
			
			kthLargest(root.left, k);
			
		}
	}

	// Given a Binary tree, find the level at which the tree is complete.
	public int checkLevel(TreeNode t, int level){
		if(t.left != null && t.right != null){
			level ++;
			return Math.min(checkLevel(t.left,level),checkLevel(t.right,level));
		}
		else {
			return level;			
		}
	}

	public static List<ArrayList<TreeNode>> getListofLists(TreeNode root) {
		List<ArrayList<TreeNode>> listOfLists = new ArrayList<ArrayList<TreeNode>>();
		
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		listOfLists.add(list);
		
		int level = 0;
		
		while(true) {
			for(int i=0; i<listOfLists.get(level).size(); i++) {
				list = new ArrayList<TreeNode>();
				
				if(listOfLists.get(level).get(i) != null) {
					if(listOfLists.get(level).get(i).left != null) {
						list.add(listOfLists.get(level).get(i).left);
					}
					
					if(listOfLists.get(level).get(i).right != null) {
						list.add(listOfLists.get(level).get(i).right);
					}
				}
			}
			
			if(list.size() > 0) {
				listOfLists.add(list);
			}
			else {
				break;
			}
			
			level++;
		}
		
		return listOfLists;
	}
	
	public List<Integer> getNPreOrder(TreeNode root, int n) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		while(true) {
			if(list.size() == n) {
				break;
			}
			
			TreeNode current = stack.pop();
			if(current == null) {
				break;
			}
			
			list.add(current.value);
			
			TreeNode node = current.right;
			if(node != null) {
				stack.push(node);
			}
			
			node = current.left;
			if(node != null) {
				stack.push(node);
			}
			
		}
		
		return list;
	}
	
	// Not working
	public List<Integer> getNInOrder(TreeNode root, int n) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		while(true) {
			if(list.size() == n) {
				break;
			}
			
			TreeNode current = stack.peek();
			if(current == null) {
				break;
			}
			
			TreeNode node = current.right;
			if(node != null) {
				stack.push(node);
			}
			
			node = current.left;
			if(node != null) {
				stack.push(node);
			}
			else {
				stack.pop();
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(2);
		
		tree.inorder(tree.root);
		System.out.println();
		
//		tree.kthLargest(tree.root, 3);
		
//		System.out.println(tree.checkLevel(tree.root, 0));
		
		List<Integer> list = tree.getNInOrder(tree.root, 4);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
		
	}

}