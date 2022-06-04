package app;

import java.util.Stack;

public class Evaluate {
    public static int evaluate(String expression)
	{
		char[] tokens = expression.toCharArray();
		String operators = "+-x÷";
		Stack<Integer> values = new Stack<Integer>();//stores all values
		Stack<Character> ops = new Stack<Character>();//stores all operators
		
		for (int i = 0; i < tokens.length; i++)
		{
			if (tokens[i] == ' ')//skip space
				continue;

			if (Character.isDigit(tokens[i]))//if character is a digit add to values
			{
				StringBuffer valueBuffer = new StringBuffer();
				
				while (i < tokens.length && Character.isDigit(tokens[i])) 
					valueBuffer.append(tokens[i++]);
				values.push(Integer.parseInt(valueBuffer.toString()));
				i--;
			}

			else if (operators.indexOf(tokens[i])!=-1)//if character is an operator add to ops
			{
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				
				ops.push(tokens[i]);
			}
		}
        //assign value to operator
		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(
						char op1, char op2)
	{
		if ((op1 == 'x' || op1 == '÷') &&
			(op2 == '+' || op2 == '-'))
			return false;
	    return true;
	}

	public static int applyOp(char op, int b, int a)//add subtract divide or multiply
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case 'x':
			return a * b;
		case '÷':
			if (b == 0)//if 0 return an error
				throw new
				UnsupportedOperationException(
					"Error: Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

}
