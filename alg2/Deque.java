import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> 
{
   private Item[] items;
   
   public Deque()                           // construct an empty deque
   {
	   // items = (Item[])new Object[1];
   }
   
   public boolean isEmpty()                 // is the deque empty?
   {
	   int itemLength = 0;
	   if(items != null)
		   itemLength = items.length;
	   
	   return itemLength == 0;
   }
   
   public int size()                        // return the number of items on the deque
   {
       return items.length;
       
   }
   
   public void addFirst(Item item)          // add the item to the front
   {
	   throwIfNull(item);
   }
   
   
   public void addLast(Item item)           // add the item to the end
   {
	   throwIfNull(item);
	   
   }
       
   public Item removeFirst()                // remove and return the item from the front
   {
	   throwIfEmpty();
	   
       return null;
   }
       
   public Item removeLast()                 // remove and return the item from the end
   {
	   throwIfEmpty();
	   
       return null;
   }
       
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
       return new DequeIterator();   
   }

   public class DequeIterator implements Iterator<Item>
   {
	   private Item current;
	   
	   public boolean hasNext() { return current != null; }
	   
	   public Item next()
	   {
		   if(!hasNext()) throw new java.util.NoSuchElementException();
		   
		   return current;
	   }
	   
	   public void remove() { throw new java.lang.UnsupportedOperationException(); } 
   }
   
   // Private methods ======================================================
   
   static private void trace(String msg)
   {
       StdOut.println(msg);
   }
   
   private void throwIfNull(Item item)
   {
	   // Throw a java.lang.IllegalArgumentException if 
	   // the client calls either addFirst() or addLast() with a null argument.
	   if(item == null)
		   throw new java.lang.IllegalArgumentException();
   }

   private void throwIfEmpty()
   {
	   if (isEmpty())
		   throw new java.util.NoSuchElementException();	   
   }
   

   // Test Client ===========================================================
   public static void main(String[] args)   // unit testing (optional)
   {
       trace("Deque:main()");
   }
   
}