//import java.util.Iterator;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueueUT
{
	private static class Node
	{
		int value;
		Node next;
		
		public Node(int v)
		{
			value = v;
			next = null;
		}		
	}
	
	public static void utSimpleRandomizedQueue()
	{
		StdOut.println("calling utSimpleRandomizedQueue...");
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		
		StdOut.println("Default Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());
		
		for(int i=0; i < 10; i++)
		{
			rq.enqueue(i);
		}
		StdOut.println("Enqueue Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());		
		// rq.dump_state();
				
		Integer j = 0;
		Iterator<Integer> itor = rq.iterator();
		for(int i=0; i < 10; i++)
		{
			j = rq.dequeue();
			//j = itor.next();
			StdOut.println("itor->Next: " + j);
		}
		//rq.dump_state();		
		StdOut.println("Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());
		
		StdOut.println("calling utSimpleRandomizedQueue...done.");		
	}	
	
	private static void utSimpleLinkList()
	{		
		Node list = new Node(1);				
		Node head = list;
		list.next = new Node(2);
		list = list.next;
		list.next = new Node(3);
	
		for(list=head; list!=null; list=list.next)
		{
			StdOut.println("Out: " + list.value);
		}
		list = head;
		head = head.next;	//delete item

		for(list=head; list!=null; list=list.next)
		{
			StdOut.println("Out: " + list.value);
		}
		
	}
	
	public static void main(String[] args)   // unit testing (optional)
	{
		utSimpleRandomizedQueue();
		//utSimpleLinkList();
	}
}