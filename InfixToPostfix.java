/* ***************************************************
 * <Colton Richardson>
 * <10/28/17>
 * <InfixToPostfix>
 *
 * <converts infix expressions to their postfix equivalents
 * and subsequently evaluates them>
 *************************************************** */
import java.io.*;

public class InfixToPostfix
{	
	// the main function is just a driver!
	public static void main(String[] args) //(done)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;

			// read input, one expression at a time
			while ((line = br.readLine()) != null)
			{
				// declare and initialize the infix and postfix queues
				Queue<Character> infix = new Queue<Character>(); // ... <-- declare and initialize the infix queue here 
				Queue<Character> postfix = new Queue<Character>(); // ... <-- declare and initialize the postfix queue here 

				// build the infix queue and display it
				for (int i=0; i<line.length(); i++)
				{
					char x = line.charAt(i);
					infix.Enqueue(x); // ... <-- enqueue each character to the infix queue here
				}
				System.out.println(infix); // ... <-- display the infix queue here

				// convert it to its postfix equivalent and display it
				postfix = Convert(infix);
				System.out.println(postfix); // ... <-- display the postfix queue here

				// calculate the result and display it
				System.out.println(Calculate(postfix));
				System.out.println();
			}

			br.close();
		} catch (Exception e) {}
	}

	// given an infix queue, this method converts it to a postfix queue
	public static Queue<Character> Convert(Queue<Character> infix) //(done)
	{
		Stack<Character> operS = new Stack<Character>();
		Queue<Character> postfixQ = new Queue<Character>(); 
		while (!infix.IsEmpty())
		{
			char token = infix.Dequeue(); 
			if (IsOperand(token))
			{	
				postfixQ.Enqueue(token);
			}
			else if (token == ')')
			{
				char op = operS.Pop(); 
				while (op != '(')
				{
					postfixQ.Enqueue(op);
					op = operS.Pop();
				}
			}
			else
			{
				Character op = operS.Peek(); 
				while (StackPriority(op) >= InfixPriority(token))
				{
					op = operS.Pop();
					postfixQ.Enqueue(op);
					op = operS.Peek();
				}
				operS.Push(token);
			}			
		}
		while (!operS.IsEmpty())
		{
			char op = operS.Pop();
			postfixQ.Enqueue(op);
		}
		return postfixQ;
	}

	// given a postfix queue, this method calculates the numeric result using a stack
	public static Stack Calculate(Queue<Character> postfix) //(done)
	{
		double x,y;
		Stack<Double> s = new Stack<Double>();
		
		for(int z = postfix.Size(); z != 0; z = postfix.Size())
		{
			char a = postfix.Dequeue();
			if(IsOperand(a))
			{
				double j = (Character.getNumericValue(a)*1.0);
				s.Push(j);
			}
			else
			{
				if (a == '*')
				{	
					x = s.Pop();
					y = s.Pop();
					s.Push(y * x);
				}
				else if (a == '/')
				{
					x = s.Pop();
					y = s.Pop();
					s.Push(y / x);
				}
				else if (a == '+')
				{	
					x = s.Pop();
					y = s.Pop();
					s.Push(y + x);
				}
				else if (a == '-')
				{
					x = s.Pop();
					y = s.Pop();
					s.Push(y - x);
				}
				else if (a == '^')
				{
					x = s.Pop();
					y = s.Pop();
					s.Push(Math.pow(y,x));
				}
			}
		}
		return s;
	}

	// given a character from an expression, this method determines whether or not it is an operand
	// it's ok to use the simple char primitive type here
	public static boolean IsOperand(char c) //(done)
	{
		if (c >= '0' && c <= '9')
			return true;
		else
			return false;
	}

	// given a character that represents an operator from an expression, this method returns its infix priority
	// it's ok to use the simple char primitive type here
	public static int InfixPriority(char c) //(done)
	{
		switch(c)
		{
			case '(': 
				return 4;
			case '^':
				return 3;
			case '*': 
			case '/':
				return 2;
			case '+': 
			case '-':
				return 1;
			default:
				return 0;
		}
	}

	// given a character that represents an operator from an expression, this method returns its stack priority
	// since the character comes form the stack, we use the Character object here (since the stack could be empty which would return null)
	public static int StackPriority(Character c) //(not done)
	{
		if (c == null)
		{
			return 0;
		}
		switch(c)
		{
			case '^': 
			case '*':
			case '/':
				return 2;
			case '+': 
			case '-':
				return 1;
			default:
				return 0;
		}
	}
}