import java.io.*;
import java.util.*;

class Node
{
	int data;
	Node rightChild;
	Node leftChild;
	public Node(int data) { this.data = data; }
}

class BST
{
	public BST()
	{
		System.out.println("BST created!!!");
	}

	public void insert(int data)
	{
		System.out.println("inserted" + data);
	}

	public void delete(int data)
	{
		System.out.println("deleted" + data);
	}

	public void search(int data)
	{
		System.out.println("searched" + data);
	}

	public void print()
	{
		System.out.println("printed the whole tree");
	}

}

public class Hw01
{
	public static void main(String [] args)
	{
		if (args.length > 0)
		{
			String readLine = "";
			BST bst = new BST();
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				//processFile(br);

				while ((readLine = br.readLine()) != null)
				{
					String [] splitLine = readLine.split(" ", 2);

					for (int i = 0; i < splitLine.length; i++)
						System.out.println("** " + splitLine[i] + " **");

					if (splitLine[0].equals("i"))
						bst.insert(Integer.parseInt(splitLine[1]));
					else if (splitLine[0].equals("d"))
						bst.delete(Integer.parseInt(splitLine[1]));
					else if (splitLine[0].equals("s"))
						bst.search(Integer.parseInt(splitLine[1]));
					else if (splitLine[0].equals("p"))
						bst.print();
					else if (splitLine[0].equals("q"))
						break;
				}

				br.close();
			}
			catch (Exception e)
			{
				System.err.println(e);
			}
		}
		else
		{
			System.out.println("Not enough arguments");
		}
	}
/*
	private static void processFile(BufferedReader br)
	{
		String readLine = "";
		while((readLine = br.readLine()) != null)
		{
			System.out.println(readLine);
		}
	}

*/
}
