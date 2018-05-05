import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) 
	{
		if(args.length != 1) return;
		
		int k = Integer.parseInt(args[0]);
		
		if(k <= 0) return;
		
		RandomizedQueue<String> rq = new RandomizedQueue<String>();	
		String input;

		try
		{
			while(StdIn.hasNextLine())
			{
				input = StdIn.readString();
				//StdOut.println(input);
				rq.enqueue(input);
			}
		}
		catch(java.util.NoSuchElementException e)
		{
			
		}
		
		StdOut.println("K: " + k + ", rq.size(): " + rq.size());
		if( k > rq.size() ) return;
		
		Iterator<String> itor = rq.iterator();
		for(int i=0; i<k; i++)
		{
			StdOut.println(itor.next());			
		}
	}
}
