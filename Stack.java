public class Stack<Type> extends List<Type>
{
  private List<Type> l;
  
  public Stack()
  {
  
  }
  
  public Stack(Stack<Type> s)
  {
  
  }
  
  public String toString()
  {
  
  }
  
  public void Push(Type data)
  {
  
  }
  
  public void Pop()
  {
  
  }
  
  public Type Peek()
  {
  
  }
  
  public int Size()
  {
  
  }
  
  public boolean IsEmpty()
  {
  
  }
  
  public boolean IsFull()
  {
  
  }
  
  public boolean Equals(Stack<Type> s)
  {
  
  }
  
  public Stack Add(Stack<Type> s)
  {
	Stack newOne = this;
	newOne.l.Add(s.l);
	return newOne;
  }
}