/* ***************************************************
 * <>
 * <>
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
		
		int i =0;
		while (i != l.GetSize())
		{
			i++;
			this.InsertAfter(i);
		}	
	}

	// navigates to the beginning of the list
	public void First()
	{
		if (!this.IsEmpty())
		{	
			curr = head;
		}
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
		if (!this.IsEmpty() && pos >= 0 && pos < GetSize())
		{	
			curr.setData(pos);
		}
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if (!this.IsEmpty())
		{
			if (curr != head)
			{
				Node n = head;
				while (n.getLink() != curr)
				{
					n = n.getLink();
					curr = n;
				}
			}
		}	
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if (!this.IsEmpty())
		{
			if curr (!= tail)
			{
				Node n = head;
				while (n.getLink != curr)
				{
					n = n.getLink();
				}
				curr.setLink(n.getLink());
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
			return -1;
		else
			return num_items;
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
		Node H = head;
		if (this.IsEmpty())
		{
			InsertAfter(data);
			num_items--;
		}
		else if (curr == head)
		{
			n.setLink(curr);
			head = n;
			curr = n;
		}
		else
		{
			while (H != curr)
			{
				H.getLink();
			}
			n.setLink(H.getLink());
			H.setLink(n);
			curr = n;
		}
		num_items++;
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
		}
		else if (curr == tail) 
		{
			curr.setLink(n); 
			curr = n; 
			tail = n;
		}
		else
		{
			n.setLink(curr.getLink()); 
			curr.setLink(n); 
			curr = n; 
		}
		num_items++;
	}
	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if (!this.IsEmpty())
		{
			Node n = this.head;
			if (n == curr)
			{
				head = null;
				curr = null;
				tail = null;
			}
			else if (n != curr)
			{ 
				n = n.getLink();
				curr = n;
				curr.setLink(curr.getLink().getLink());
			}
			num_items--;
		}			
	}
/*
	if (!this.IsEmpty())
		{
			if (this.GetPos() == this.GetSize() - 1)
			{
				curr--;
			}
			else
			{
				while (curr != tail)
					curr.getData();
					curr.getLink();
				for (int i=curr; i<end; i++)
					list[i] = list[i+1];
			}
			end--;
		}
	
*/	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if (!this.IsEmpty())
		{
			this.curr.setData(data);
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
/*
// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		List newList = new List(this);
		
		for (int i=0; i<l.GetSize(); i++)
			newList.InsertAfter(i);

		return newList;
		
	}
*/
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
