/* ***************************************************
 * <Colton Richardson>
 * <9/30/17>
 * <Linked List.java>
 *
 * <a simple, short program/class description>
 *************************************************** */
 // the Node class
class Node
{
	private int data;
	private Node link;

	// constructor
	public Node()
	{
		this.data = 0;
		this.link = null;
	}

	// accessor and mutator for the data component
	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	// accessor and mutator for the link component
	public Node getLink()
	{
		return this.link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
}

// the List class
class List
{
	public static final int MAX_SIZE = 50;

	private Node head;
	private Node tail;
	private Node curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List()
	{
			this.head = null;
			this.curr = null;
			this.tail = null;
			this.num_items = 0;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		this.head = null;
		this.curr = null;
		this.tail = null;
		this.num_items = 0;
		
		int i=0;
		Node n = l.head;
		while (i < l.GetSize())
		{
			InsertAfter(n.getData());
			n = n.getLink();
			i++;
		}	
		
	}

	// navigates to the beginning of the list
	public void First()
	{
		curr = head;
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		curr = tail;
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if (!this.IsEmpty())
		{
			if (pos < num_items - 1)
			{
				Node n = head;
				int i = 0;
				while (i < pos)
				{
					n = n.getLink();
					i++;
				}
				curr = n;
			}
		}
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if (!this.IsEmpty())
		{
			Node n = head;
			Node p = head;
			while (p != curr && p.getLink() != null)
			{
				n = p;
				p = p.getLink();
			}
			curr = n;
		}
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if(!IsEmpty())
		{
			if (curr.getLink() != null)
			{
				curr=curr.getLink();
			}
		}
	}
	
	// returns the location of the current element (or -1)
	public int GetPos()
	{
		int i = 0;
		Node n = head;
		if (this.IsEmpty())
		{	
			return -1;
		}	
		else 
		{	
			while (n != curr)
			{
				i++;
				n = n.getLink();
			}
			return i;
		}
	}
	
	// returns the value of the current element (or -1)
	public int GetValue() // little difference
	{
		
		if (this.IsEmpty())
		{	
			return -1;
		}
		else
		{
			return curr.getData();
		}
		
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize() // little difference
	{
		return num_items;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data)
	{	
		Node n = new Node();
		n.setData(data);
		if (this.IsEmpty())
		{
			head = n;
			curr = n;
			tail = n;
			num_items = 1;
		}
		else if (curr == head)
		{
			n.setLink(head);
			head = n;
			curr = n;
			num_items++;
		}
		else
		{
			int i = GetPos();
			Prev();
			InsertAfter(data);
			SetPos(i);
		}
	}
	
	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data)
	{
		Node n = new Node(); 
		n.setData(data);
		if (this.IsEmpty()) 
		{	
			head = n;
			curr = n;
			tail = n;
			num_items = 1;
		}
		else 
		{	
			if (!this.IsFull())
			{	
				if (curr == tail) 
				{
					tail.setLink(n); 
					curr = n; 
					tail = n;
				}
				else
				{
					n.setLink(curr);
					Prev();
					curr.setLink(n);
					curr = n;
				}
				num_items++;
			}
		}
	}
	
	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if (!this.IsEmpty())
		{
			Node a = new Node();
			Node b = new Node();
			Node c = new Node();
			Node d = curr.getLink();
			if (curr == tail)
			{
				Prev();
				a = curr;
				Prev();
				b = curr;
				Next();
				curr = c;
				curr.setData(a.getData());
				b.setLink(curr);
				tail = curr;
			}
			else
			{
				if (curr == head)
				{
					Next();
					head = curr;
				}
				else
				{
					Prev();
					curr.setLink(d);
					Next();
				}
			}
			num_items--;
		}
	}
	
	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if(!this.IsEmpty())
		{	
			curr.setData(data);
		}
	}
	
	// returns if the list is empty
	public boolean IsEmpty()
	{
		return (this.GetSize() == 0);	
	}
	
	// returns if the list is full
	public boolean IsFull()
	{
		return (MAX_SIZE == this.GetSize());
	}

// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		if(GetSize() != l.GetSize())
		{	
			return false;
		}
		else
		{	
			return true;
		}
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		List newList = new List(this);
		int i=0;
		Node n = l.head;
		while (i < l.GetSize())
		{
			newList.InsertAfter(n.getData());
			n = n.getLink();
			i++;
		}
		return newList;
	}
	
	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		if (this.IsEmpty())
			return "NULL";
		
		String s = "";
		Node n = this.head;
		while(n != null)
		{
			s += n.getData() + " ";
			n = n.getLink(); 
		}
		return s;
	}	
}