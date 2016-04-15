/**************************
Author = Martin Rahardja
Student ID = 17678821
AMI Assignment 2015
***************************/
public class ListofEdge // Store the linked list of edge
{
	private Edge head;
	private int count;

	public ListofEdge()
	{
		head = null;
		count = 0;
	}

	public ListofEdge(ListofEdge inList)
	{
		if(inList != null)
		{
		   head = inList.getHead();
		   count = inList.getCount();
		}
	}

	public Edge getHead()
	{
		return head;
	}

	public int getCount()
	{
		return count;
	}

	public void addNewEdge(Edge connect)
	{
		Edge temp;
		if(head == null)
		{
			head = connect;
			count++;
		}
		else
		{
			temp = head;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(connect);
			count++;

		}
	}

	public boolean isEmpty()
	{
		boolean isEmpty = true;
		if(head != null)
		{
			isEmpty = false;
		}
		return isEmpty;
	}

	public Nodes searchEdge(String name)
	{
		Edge temp= head;
		Nodes tempNode = null, result = null;

		if(temp != null)
		{
			for(int i = 0; i<count; i++)
			{
				if(temp != null)
				{
					tempNode = temp.getPointB();

					if(tempNode.checkName(name))
					{
						result = tempNode;
					}

					temp = temp.getNext();

				}
			}
		}
		return result;
	}

	public ListofEdge getNotVisited() // give another linked list of the edge that the other nodes has not been visited
	{
		ListofEdge newList = new ListofEdge();
		Edge temp = head, newEdge;
		int i=0;
		while(temp !=null && i<count)
		{
			if(!temp.getPointB().checkVisit())
			{
				newEdge = new Edge(temp.getPointA(), temp.getPointB(), temp.getValueofEdge()); // creating new object of edge
				newList.addNewEdge(new Edge(newEdge));
			}
			temp = temp.getNext();
			i++;

		}

		return newList;
	}

	//smallest edge only between nodes that has not been visited
	public Edge getSmallestEdge()
	{
		Edge result = null, temp;
		ListofEdge newList = this.getNotVisited(); // use list of edge that not been visited
		if(!newList.isEmpty())
		{
			if(newList != null)
			{
				result = newList.getHead();
				temp = result.getNext();
				for(int i =0; i< newList.getCount(); i++)
				{
					if(temp != null)
					{
					   if(result.getValueofEdge() > temp.getValueofEdge())
					   {
						   result =  temp;
					   }
					   temp = temp.getNext();
					}
				}
			}
		}
		return result;
	}

	public String toString()
	{
		String outString= "";
		Edge temp = head;
		for(int i=0; i<count; i++)
		{
			outString += temp.toString() + "\n";
			temp = temp.getNext();
		}
		return outString;
	}

}
