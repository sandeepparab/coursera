import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
   private class node
   {
	   Item value;
	   node next;
	   //node prev;
	   public node(Item v)
	   {
		   value = v;
	   }
   }

   private int count = 0;
   private node head = null;
   
   public RandomizedQueue()                 // construct an empty randomized queue
   {
   }

   public boolean isEmpty()                 // is the randomized queue empty?
   {
	   return count == 0;
   }

   public int size()                        // return the number of items on the randomized queue
   {
	   return count;
   }

   public void enqueue(Item item)           // add the item
   {
	   if (item == null) throw new java.lang.IllegalArgumentException();
	   
	   node tmp = new node(item);
	   tmp.next = head;
	   //tmp.prev = null;
	   	   
	   head = tmp;	   	   

	   count++;
	   
	   //StdOut.println("q: index: n/a , Item: " + head.value + ", Count: " + count);
   }

   /*
   private void dump_state()
   {
	   for(int i=0; i< valid.length; i++)
	   {
		   StdOut.println("value[" + i + "]: " + value[i] + ", valid[" + i + "]: " + valid[i]);		   
	   }
   }
   */
   
   private int GetRandomIndex()
   {
	   // find next valid item to dequeue
	   int size = count;
	   
	   //StdRandom.setSeed(System.currentTimeMillis());
	   int index = StdRandom.uniform(Integer.MAX_VALUE) % size;
	   	   
	   return index;
   }
   
   public Item dequeue()                    // remove and return a random item
   {
	   if(isEmpty()) throw new java.util.NoSuchElementException();
	   
	   int index = GetRandomIndex();
	   
	   node temp_head = head;
	   node prev = head;
	   for(int i = 0; i < index; ++i)
	   {
		   prev = head;
		   head = head.next;
	   }

	   node ret = head;

	   if(index == 0)
	   {
		   head = head.next;
	   }
	   else
	   {
		   prev.next = head.next;
		   head = temp_head;
	   }
	   --count;

	   // debug
	   //StdOut.println("dq: Index: " + index + ", Item: " + ret.value + ", Count: " + count);
	   //for(node temp = head; temp!=null; temp=temp.next)
	   //{
	   //	   StdOut.println(">" + temp.value);
	   //}
	   // end debug
	   
	   return ret.value;
   }

   public Item sample()                     // return a random item (but do not remove it)
   {
	   if(isEmpty()) throw new java.util.NoSuchElementException();

	   int index = GetRandomIndex();
	   
	   node temp = head;
	   for(int i = 0; i < index; ++i)
	   {
		   temp = temp.next;
	   }	

	   return temp.value;
   }

   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
	   return new RandomizedQueueIterator(head, count);
   }
   
   private class RandomizedQueueIterator implements Iterator<Item>
   {
	   private node list;
	   private int count;
	   private int size;
	   private node start; 
	   
	   public RandomizedQueueIterator(node l, int c)
	   {		   
		   list = l;
		   count = c;
		   size = c;
		   if(c > 0)
		   {			   
			   int index = GetRandomIndex();
	
			   node start = list;
			   for(int i = 0; i < index;)
			   {
				   start = start.next;
				   if( start != null)
					   i++;			   
				   else
					   start = list;		// we past last item in the list
			   }
		   }
	   }

	   private int GetRandomIndex()
	   {
		   // find next valid item to dequeue
		   int size = count;
		   
		   //StdRandom.setSeed(System.currentTimeMillis());
		   int index = StdRandom.uniform(size) % size;
		   	   
		   return index;
	   }
	   
	   public boolean hasNext() { if(count > 0) return true; else return false; }
	   
	   public Item next()
	   {
		   if(!hasNext()) throw new java.util.NoSuchElementException();
		   
		   // Item value = start.value;
		   
		   if(count > 0)
		   {
			   if(start == null || start.next == null)
			   {
				   start = list;	// reset start
				   
			   } else {
				   
				   start = start.next;
			   }
			   
		   }		   
		   --count;
		   return start.value;
	   }
	   
	   public void remove() { throw new java.lang.UnsupportedOperationException(); } 
   }

   public static void main(String[] args)   // unit testing (optional)
   {
	   //StdOut.println("RandomizedQueue...Done.");
   }
}