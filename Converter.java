/*
 * Matthew White
 * CMSC 350 - Spring '21
 * Contains the conversion methods used in the GUI(main()).
 */
package prePostConvert;
import java.util.*;

public class Converter {
	static boolean isOperator(String s) {
		switch (s) {
		case ("+"):
		case ("-"):
		case ("*"):
		case ("/"):
			return true;
		}
		return false;
	}
	
	public String prefixToPostfix(String expression) throws Exception {
		Stack<String> revStack = new Stack<String>();
		Stack<String> useStack = new Stack<String>();
		StringTokenizer token = new StringTokenizer(expression);
		
		while(token.hasMoreTokens()) {
			revStack.push(token.nextToken());
		}
		while(!revStack.isEmpty()) {
			if(!isOperator(revStack.peek())){
				useStack.push(revStack.pop());
			}else {
				String operand1 = useStack.pop();
				String operand2 = useStack.pop();
				String operator = revStack.pop();
				String temp = operand1+" "+operand2+" "+operator;
				useStack.push(temp);
			}
		}
		String convertedExpression = useStack.pop();
		//if block MUST be after this final .pop() or StackNotEmpty will be thrown
		if(!useStack.isEmpty()) {
			throw new StackNotEmpty();
		}
		return convertedExpression;
	}
	
	public String postfixToPrefix(String expression) {
		Stack<String> stack = new Stack<String>();
		Stack<String> stackTwo = new Stack<String>();
		StringTokenizer token = new StringTokenizer(expression, " ");
		
		//items go into stack reversed, not good for this operation
		while(token.hasMoreTokens()) {
		stack.push(token.nextToken());
		}
		//reversed item order for proper operation
		while(!stack.isEmpty()) {
			stackTwo.push(stack.pop());
		}
		
		while(!stackTwo.isEmpty()) {
			if(!isOperator(stackTwo.peek())) {
				stack.push(stackTwo.pop());
			}else {
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				String operator = stackTwo.pop();
				String temp = operator+" "+operand1+" "+operand2;
				stack.push(temp);
			}
		}
		String convertedString = stack.pop();
		//if block MUST be after this final .pop() or StackNotEmpty will be thrown
		if(!stack.isEmpty()) {
			throw new StackNotEmpty();
		}
		return convertedString;
	}
}
