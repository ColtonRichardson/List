/* ***************************************************
 * <Colton Richardson>
 * <10/21/2017>
 * <Stack.java>
 *
 * <A generic Stack class that is built off of generic List.>
 *************************************************** */
public class Stack<Type> 
{	
	private List<Type> l;
	
	//Stack Constructor 
	public Stack()
	{
		l = new List<Type>();
	}
	
	//Copies Constructor 
	public Stack(Stack<Type> s) 
	{
		l = new List<Type>(s.l);
	}
	
	//Insert an item on top of the stack 
	public void Push(Type data)
	{
		l.First();
		l.InsertBefore(data);
	}
	
	//Delete an item from the top of the stack and return item 
	public Type Pop()
	{
		Type t = Peek();
		l.Remove();
		return t;
	}
	
	// Return, but don't delete the item on top of the stack 
	public Type Peek()
	{
		l.First();
		return l.GetValue();
	}
	
	// Return the size of the stack 
	public int Size()
	{
		return l.GetSize();
	}
	
	// Return if the stack is empty 
	public boolean IsEmpty()
	{
		return l.IsEmpty();
	}
	
	// Return if the stack is full 
	public boolean IsFull()
	{ 
		return l.IsFull();
	}
	
	// Compare two stacks 
	public boolean Equals(Stack<Type> s)
	{
		return l.Equals(s.l);
	}
	
	// Concatenate two stacks 
	public Stack<Type> Add(Stack<Type> s) 
	{	
		Stack<Type> newOne = new Stack<Type>(this);
		newOne.l = newOne.l.Add(s.l);
		return newOne;
	}
	
	//Stack output 
	public String toString()
	{
		return l.toString();
	}
}