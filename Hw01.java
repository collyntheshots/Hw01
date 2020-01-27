import java.io.*;
import java.util.*;

class Node
{
	int data;
	Node rightChild, leftChild;
	public Node(int data) { this.data = data; }
}

class BST
{
	Node root;

	public void insert(int data)
	{
		this.root = insertData(this.root, data);
		System.out.println("inserted " + data);
	}

	private Node insertData(Node root, int data)
	{
		if (root == null)
			return new Node(data);

			return searchData(root, data);
	}

	public void delete(int data)
	{
		System.out.println("deleted" + data);
	}

	public void search(int data)
	{
		Node root = searchData(this.root, data);
		System.out.println("searched for " + data);
		System.out.println("Found " + root.data);
	}

	private Node searchData(Node root, int data)
	{
		if (this.root == null || this.root.data == data)
			return this.root;

		if (data < root.data)
			root.leftChild = insertData(root.leftChild, data);
		else if (data >= root.data)
			root.rightChild = insertData(root.rightChild, data);

		return root;
	}

	public void print()
	{
		inOrder(this.root);
		System.out.println("printed the whole tree");
	}

	private void inOrder(Node root)
	{
		if (root != null)
		{
			inOrder(root.leftChild);
			System.out.println(root.data);
			inOrder(root.rightChild);
		}
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
