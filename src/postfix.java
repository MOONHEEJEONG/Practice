import java.util.Scanner;
import java.util.Stack;

public class postfix {

	public static void main(String[] args) {
		
		
		
		Stack<Character> stack = new Stack<Character>();
		
		int test_case ;
		String input = null;
		
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		
		for(int j=0; j<test_case; j++) {
		
		input = sc.next();
		String output = null ;
		
		/*
		 * 숫자면 출력한다
		 * 연산자면 top에 있는 연산자가 우선순위가 더 높거나 같으면 꺼낸다. 낮으면  push한다.
		 * 곱하기, 나눗셈일 경우 스택의 top 이 곱,나누기이면 그걸 먼저 뺀다
		 * 여는 괄호는 무시한다
		 * 닫는 괄호는 pop을 실행한다.
		 * 
		 * */
		
		
		for(int i=0; i<input.length(); i++ ) {
			
			if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='/') {
					while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(input.charAt(i)) ) {
						output+= stack.pop();
						output+= ' ';

				}
									
				stack.push(input.charAt(i));
				
			}else if(input.charAt(i)=='(') {
				stack.push(input.charAt(i));
								
			}else if(input.charAt(i)==')') {
				
				while(stack.peek() != '(') {
					output+= stack.pop();
					output+= ' ';
				}
				
				stack.pop();
				
			}else {
				if(output==null) {
					output= Character.toString(input.charAt(i));
					if( i+1 < input.length() &&(input.charAt(i+1)<'0' || input.charAt(i+1)>'9') ) {
						output+= ' ';
					}
					
				}else {
				output+= input.charAt(i);
				if( i+1 < input.length() &&(input.charAt(i+1)<'0' || input.charAt(i+1)>'9') ) {
					output+= ' ';
				}}
			}							
			
		}
		
			while(!stack.isEmpty()) {
				output+= ' ';
				output += stack.pop();
			}
			
	
		
		System.out.println(output);		
		
		
		}
		
	}
	
	static int precedence(int op) {
		switch(op) {
		
		case '(':
			return 0;
			
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 3;
		}
		}
	
	
	}
	

