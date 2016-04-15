/**************************
Author = Martin Rahardja
Student ID = 17678821
AMI Assignment 2015
***************************/
import java.io.*;
import java.util.*;


public class Search
{
	public static void main (String[] args)
	{
		//Open scanner for user input
		Scanner sc = new Scanner(System.in);

		String answer; //variable to store user input for loops

		String userInput[] = new String[6];
		boolean userPrompt = true, flagSign = false;
		String question;

		for(int i=0; i<5; i++)
		{
			question = "";

			if(i<args.length)
			{
				if(args[i] != null)
					userInput[i] = args[i];
			}
			else
			{
				switch(i)
				{
				case 0:
					question = "Enter search type";
					break;
				case 1:
					question = "Enter data file";
					break;
				case 2:
					question = "Enter heuristic file";
					break;
				case 3:
					question = "Enter start node";
					break;
				case 4:
					question = "Enter goal node";
					break;
				}
				System.out.println(question);
				userInput[i] = sc.nextLine();
			}
		}
		//check if the user specified the -all flag
		if(args.length == 6)
		{
		   userInput[5] = args[5];
		   if(userInput[5].equals("-all"))
			   flagSign = true;
		}

		LinkedList myList = new LinkedList();

		readNodes(userInput[1], myList);
		readEdges(userInput[2], myList);


		if(userInput[0].equals("greedy-search"))
		{
			do
			{
				try
				{

					findPath(myList, userInput[3], userInput[4]);
					/*
					when flagsign is not specified
					ask user is the loop need to repeat
					*/
					if(!flagSign)
					{
						System.out.println("Do another search? Y/N");
						answer = sc.nextLine();
						if(answer.equals("N"))
							userPrompt = false;
					}
				}
				catch(Exception e)
				{
					//enter when no more solution can be obtain
					System.out.println("No more solution");
					userPrompt = false;
					flagSign = false;
				}
			}while(flagSign || userPrompt);
		}
	    sc.close();

	}

	public static void readNodes(String filePath, LinkedList myList)
	{

		try {
		//Opening reader to read from file
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String textData;
		//Read Data per line
		while ((textData = br.readLine()) != null)
		{
			//Split the data by black space
			String[] item = textData.split(" ");

			int value = Integer.parseInt(item[1]);

			Nodes newNode = new Nodes(item[0], value);
			//Store all the node into one linked list
			myList.addNewNode(newNode);
		}

		br.close();
		}
		catch (Exception e)
		{ e.printStackTrace();}

	}

	public static void readEdges(String filePath, LinkedList myList)
	{
		try {
		//Opening reader to read from file
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String textData;
		//Read data per line
		while ((textData = br.readLine()) != null)
		{
			String[] item = textData.split(" ");
			int value = Integer.parseInt(item[2]);

			//Search the Node with the same name
			Nodes first = myList.searchNode(item[0]);
			Nodes second = myList.searchNode(item[1]);

			//Create the edge in the order of the first node as the start
			Edge newEdge = new Edge(first, second, value);
			first.addEdge(newEdge);
			//Create the edge in the order of the second node as the start
			Edge newEdgeRev = new Edge(second, first, value);
			second.addEdge(newEdgeRev);



		}
		br.close();
		}
		catch (Exception e)
		{ e.printStackTrace();}

	}

	public static void findPath(LinkedList myList, String startN, String goalN)
	{

		ListofEdge find;
		Edge path;
		String solution = startN;
		Nodes pathN, temp = myList.searchNode(startN); //set temp as the start node
		while(!temp.checkName(goalN)) // if temp is not the goal node, enter the loop
		{
			//setting the node as visited
			temp.setVisited();

			find = temp.getEdge();
			pathN = find.searchEdge(goalN);
			//check if the goal node is connected directly with the node we currently in
			if(pathN != null)
			{
				if( pathN.checkName(goalN))
				{
					temp = pathN;
					solution += "-" + goalN;
				}
			}
			else // get the smallest edge from the node we currently in
			{
				path = find.getSmallestEdge();
				temp = path.getPointB();
				solution += "-" + temp.getName(); // put the result in the solution
			}
		}

		System.out.println(solution);


	}


}
