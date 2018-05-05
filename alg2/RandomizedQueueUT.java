//import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueueUT
{
	public static void utSimpleRandomizedQueue()
	{
		StdOut.println("calling utSimpleRandomizedQueue...");
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		
		StdOut.println("Default Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());
		
		for(int i=0; i < 10; i++)
		{
			rq.enqueue(StdRandom.uniform(100) % 10);
		}
		StdOut.println("Enqueue Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());		
		//rq.dump_state();
				
		Integer j = 0;
		for(int i=0; i < 10; i++)
		{
			j = rq.dequeue();
			StdOut.println("deque: " + j);
		}
		//rq.dump_state();		
		StdOut.println("Size: " + rq.size() + " , isEmpty: " + rq.isEmpty());
		
		StdOut.println("calling utSimpleRandomizedQueue...done.");		
	}	
	
	public static void main(String[] args)   // unit testing (optional)
	{
		utSimpleRandomizedQueue();
	}
}