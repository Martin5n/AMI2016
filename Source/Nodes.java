/**************************
Author = Martin Rahardja
Student ID = 17678821
AMI Assignment 2015
***************************/

public class Nodes
{

	private String name;
	private int value;
	private ListofEdge connection; //to store the list of Edges it connect with
	private boolean visited; //false when node has not been visited
	private Nodes next;

	public Nodes(String inName, int inValue)
	{
		name = inName;
		value = inValue;
		connection = new ListofEdge();
		visited = false;
		next = null;
	}

	public Nodes(Nodes inNodes)
	{
		name = inNodes.getName();
		value = inNodes.getValue();
		connection = inNodes.getEdge();
		visited = inNodes.checkVisit();
		next = inNodes.getNext();
	}

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;

	}

	public ListofEdge getEdge()
	{
		return connection;
	}

	public Nodes getNext()
	{
		return next;
	}

	public void addEdge(Edge inEdge)
	{
		connection.addNewEdge(inEdge);
	}

	public boolean checkVisit()
	{
		return visited;
	}

	public void setVisited()
	{
		visited = true; // true when node has been visited
	}

	public void setNext(Nodes newItem)
	{
		next = newItem;
	}

	public String toString()
	{
		String outString;
		outString = name + " " + value;
		return outString;
	}

	public boolean checkName(String inName)
	{
		return name.equals(inName);
	}

	public boolean equal(Nodes checkNode) //two nodes is the same if the name and value are the same
	{
		boolean isEqual = false;
		if(	checkName(checkNode.getName()))
		{
			if (value == checkNode.getValue())
			{
				isEqual = true;
			}
		}

		return isEqual;
	}

}
