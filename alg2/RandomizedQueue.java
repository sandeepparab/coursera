import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{

   private Item[] value = null; 
   private Boolean[] valid = null;
   
   private Integer count = 0;
   
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
	   
	   // StdOut.println("count: " + count);	   
	   if(count == 0)
	   {		   
		   value = (Item[]) new Object[1];
		   valid = new Boolean[1];
	   } 

	   if(count == value.length)
	   {
		   Item[] tempQ = (Item[])new Object[count*2];
		   Boolean[] tempV = new Boolean[count*2];
		   int c = 0;
		   for(int i=0; i < count; ++i)
		   {
			   if(valid[i] == true)
			   {
				   tempQ[c] = value[i];
				   tempV[c] = true;
				   c++;
			   }
		   }
		   value = tempQ;
		   valid = tempV;
		   
		   count = c;
	   }
	   
	   // StdOut.println("length: " + value.length);
	   value[count] = item;
	   valid[count] = true;
	   
	   ++count;	   
   }
   
   private void dump_state()
   {
	   for(int i=0; i< valid.length; i++)
	   {
		   StdOut.println("value[" + i + "]: " + value[i] + ", valid[" + i + "]: " + valid[i]);		   
	   }
   }

   private int GetRandomIndex()
   {
	   int index=0;
	   
	   StdRandom.setSeed(System.currentTimeMillis());
	   index = StdRandom.uniform(100) % count;
	   
	   // find next valid item to dequeue
	   int size = (valid.length-1);
	   
	   while(valid[index] !=null && valid[index] == false)
	   {
		   //StdOut.println("[deque]index: " + index + ", valid: " + valid[index]);
		   index++;
		
		   if(index > size)
			   index = 0;	   		   
	   }
	   
	   return index;
   }
   
   public Item dequeue()                    // remove and return a random item
   {
	   if(isEmpty()) throw new java.util.NoSuchElementException();
	   
	   int index = GetRandomIndex();
	   
	   valid[index] = false;
	   Item temp = (Item)value[index];	   
	   --count;
	   
       return temp;
   }

   public Item sample()                     // return a random item (but do not remove it)
   {
	   if(isEmpty()) throw new java.util.NoSuchElementException();

	   int index = GetRandomIndex();
	   
	   return (Item)value[index];
   }

   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
	   return new RandomizedQueueIterator(value);
   }
   
   public class RandomizedQueueIterator implements Iterator<Item>
   {
	   private Item[] current;
	   private Integer index;
	   
	   public RandomizedQueueIterator(Item[] head)
	   {		   
		   current = head;
		   index = 0;
	   }
	   
	   public boolean hasNext() { return current != null; }
	   
	   public Item next()
	   {
		   if(!hasNext()) throw new java.util.NoSuchElementException();
		   
		   int index = GetRandomIndex();
		   
		   Item next = (Item)value[index];
		   
		   return next;
	   }
	   
	   public void remove() { throw new java.lang.UnsupportedOperationException(); } 
   }

   public static void main(String[] args)   // unit testing (optional)
   {
	   StdOut.println("RandomizedQueue...Done.");
   }
}