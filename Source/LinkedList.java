/**************************
Author = Martin Rahardja
Student ID = 17678821
AMI Assignment 2015
***************************/
public class LinkedList //store the linked list of nodes
{
	private Nodes head;
	private int count;

	public LinkedList()
	{
		head = null;
		count = 0;
	}

	public int getCount()
	{
		return count;
	}

	public void addNewNode(Nodes newItem)
	{
		Nodes temp;
		if(head == null)
		{
			head = newItem;
			count++;
		}
		else
		{
			temp = head;
			while(temp.getNext()!= null)
			{
			   temp = temp.getNext();
			}
			temp.setNext(newItem);
			count++;
		}
	}



	public Nodes searchNode(String name)
	{
		Nodes temp=null;
		int i=0;
		if(head != null)
		{
			temp = head;
			while(!temp.checkName(name) && i <= count) // iterate until it finds the searched node
			{
				temp = temp.getNext();
				i++;
			}

		}
		return temp;
	}

	public void printAll()
	{
		Nodes temp;;
		if(head!=null)
		{
			temp = head;
			for(int i = 0; i<count; i++)
			{
				System.out.println(temp.toString());
				temp = temp.getNext();
			}
		}
	}


}
