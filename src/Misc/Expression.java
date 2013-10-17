package Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
(5 * 3) + 2 = 17

5 3 * 2 + = 17

[]
[5]
[5 3]
[15]
[15 2]
[17]

10 20 30 40 + + + = 100
 */


// Expression.java

public class Expression {
	public static void main(String[] args) {
		testCase("5 3 *", 15);
		testCase("15 2 *", 30);
		testCase("5 3 * 2 +", 17);
		testCase("10 20 30 40 + + +", 100);
		testCase("20 2 -", 18);
		testCase("50 5 /", 10);
	}

	// print expression, expected
	// print SUCCESS
	// print FAIL, got ___
	public static void testCase(String expression, int expected) {
		Expression exp = new Expression();
		
		System.out.println(expression + " ?= " + expected);
		if(exp.evaluateExpression(expression) == expected) {
			System.out.println("SUCCESS");
		}
		else {
			System.out.println("FAIL");
		} 
	}

	public int evaluateExpression(String expression) {

		if(expression == null) {
			throw new NullPointerException();
		}
		
		Map<String, Operator> map = new HashMap<String, Operator>();
		map.put("+", new Plus());
		map.put("-", new Minus());
		map.put("*", new Times());
		map.put("/", new Divide());
		map.put("abs", new Abs());

		Stack<String> stack = new Stack<String>();

		String[] objects = expression.split(" ");

		for(int i=0; i<objects.length; i++) {

			try {
				int n = Integer.parseInt(objects[i]);
				stack.push(objects[i]);
			}
			catch(Exception e) {
				
				if(map.get(objects[i]).arity() == 1) {
					int a = Integer.parseInt(stack.pop());
					String operands[] = {Integer.toString(a)};
					stack.push(Integer.toString(map.get(objects[i]).evaluate(operands)));
				}
				else if(map.get(objects[i]).arity() == 2) {
					int a = Integer.parseInt(stack.pop());
					int b = Integer.parseInt(stack.pop());
					String operands[] = {Integer.toString(a), Integer.toString(b)};
					stack.push(Integer.toString(map.get(objects[i]).evaluate(operands)));
				}
			}
		}

		return Integer.parseInt(stack.peek());

	}

	public interface Operator {
		public int evaluate(String[] operands);
		public int arity(); // how many operands it takes
	}

	public class Plus implements Operator {

		@Override
		public int evaluate(String[] operands) {
			
			int sum = Integer.parseInt(operands[0]);
			
			for(int i=1; i<operands.length; i++) {
				sum += Integer.parseInt(operands[i]);
			}
			return sum;
		}

		@Override
		public int arity() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public class Minus implements Operator {

		@Override
		public int evaluate(String[] operands) {

			int difference = Integer.parseInt(operands[0]);

			for(int i=1; i<operands.length; i++) {
				difference -= Integer.parseInt(operands[i]);
			}

			return difference;
		}

		@Override
		public int arity() {
			return 2;
		}

	}

	public class Times implements Operator {

		@Override
		public int evaluate(String[] operands) {

			int difference = Integer.parseInt(operands[0]);

			for(int i=1; i<operands.length; i++) {
				difference *= Integer.parseInt(operands[i]);
			}

			return difference;
		}

		@Override
		public int arity() {
			return 2;
		}

	}
	
	public class Divide implements Operator {

		@Override
		public int evaluate(String[] operands) {

			int difference = Integer.parseInt(operands[0]);

			for(int i=1; i<operands.length; i++) {
				difference /= Integer.parseInt(operands[i]);
			}

			return difference;
		}

		@Override
		public int arity() {
			return 2;
		}

	}
	
	public class Abs implements Operator {

		@Override
		public int evaluate(String[] operands) {

			return Math.abs(Integer.parseInt(operands[0]));
		}

		@Override
		public int arity() {
			return 1;
		}

	}
	
	



}
