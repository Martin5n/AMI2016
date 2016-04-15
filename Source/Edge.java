/**************************
Author = Martin Rahardja
Student ID = 17678821
AMI Assignment 2015
***************************/

public class Edge // Store the edge data, two nodes and the value
{
	private Nodes pointA;
	private Nodes pointB;
	private int value;
	private Edge next;

	public Edge(Nodes nodeA, Nodes nodeB, int inValue)
	{
		pointA = nodeA;
		pointB = nodeB;
		value = inValue;
		next = null;
	}

	public Edge (Edge inEdge)
	{
		pointA = inEdge.getPointA();
		pointB = inEdge.getPointB();
		value = inEdge.getValueofEdge();
		if(inEdge.getNext() != null)
		{
		   next = inEdge.getNext();
		}
		else
		{
			next = null;
		}
	}

	public Nodes getPointA()
	{
		return pointA;
	}

	public Nodes getPointB()
	{
		return pointB;
	}

	public int getValueofEdge()
	{
		return value;
	}

	public Edge getNext()
	{
		return next;
	}

	public void setNext(Edge newEdge)
	{
		next = newEdge;
	}

	public String toString()
	{
		String outString;
		outString = pointA.getName() + " " + pointB.getName()+ " " + value ;
		return outString;
	}
}
