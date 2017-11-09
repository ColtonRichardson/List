/* ***************************************************
 * <Colton Richardson>
 * <10/21/2017>
 * <Queue.java>
 *
 * <A generic Queue class that is built off of generic List.>
 *************************************************** */
public class Queue<Type>
{
	private List<Type> l;	
	// constructor
	public Queue()
	{
		l = new List<Type>();
	}

	// copy constructor 
	public Queue(Queue<Type> q) 
	{
		l = new List<Type>(q.l);
	}
	
	// insert an item at the end of the queue
	public void Enqueue(Type data)
	{
		l.Last();
		l.InsertAfter(data);
	}
	
	// delete an item from the begining of the queue and return item
	public void Dequeue()
	{
		Type t = Peek();
		l.Remove();
	}
	
	// return, but doesn't delete the item at the begging of the queue
	public Type Peek()
	{
		Type t;
		l.First();
		t = l.GetValue();
		return t;
	}
	
	// return the size of the queue
	public int Size()
	{
		return l.GetSize();
	}
	
	// return if the queue is empty
	public boolean IsEmpty()
	{
		return l.IsEmpty();
	}

	// return if the queue is full
	public boolean IsFull()
	{
		return l.IsFull();
	}
	
	// compares two queues
	public boolean Equals(Queue<Type> q) 
	{
		return l.Equals(q.l);
	}
	
	// concatenate two queues
	public Queue<Type> Add(Queue<Type> q) 
	{
		Queue<Type> newOne = new Queue<Type>(this);
		newOne.l = newOne.l.Add(q.l);
		return newOne;
	}	
	
	//Queue output 
	public String toString()
	{
		return l.toString();
	}
}