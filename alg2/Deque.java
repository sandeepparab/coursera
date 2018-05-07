import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> 
{     
   private class node
   {
	   Item value;
	   node next;
	   node prev;
	   
	   public node(Item i)
	   {
		   value = i;
		   
		   next = null;
		   prev = null;
	   }	   
   }   
   private node head = null;		
   private node tail = head;				// always point to last node, so tail->next == null
   
   private Integer size = 0;   
   
   public Deque()                           // construct an empty deque
   {
	   // nothing to do here
   }
   
   public boolean isEmpty()                 // is the deque empty?
   {
	   return size == 0;
   } 
   
   public int size()                        // return the number of items on the deque
   {
       return size;       
   }
   
   public void addFirst(Item item)          // add the item to the front
   {
	   throwIfNull(item);
	   
	   node tmp = new node(item);
	   if(size == 0)
	   {
		   head = tmp;
		   tail = head;
		   
	   } else {
		
		   tmp.next = head;
		   head.prev = tmp;
		   
		   head = tmp;		   
	   }
	   
	   size++;
   }
   
   
   public void addLast(Item item)           // add the item to the end
   {
	   throwIfNull(item);
	   
	   if(size == 0)
	   {
		   addFirst(item);
		   
	   } else {

		   node tmp = new node(item);
		   
		   tmp.next = tail.next;	// i.e. null
		   tmp.prev = tail;			// point to current tail
		   tail.next = tmp;			// point old tail to new tail
		   
		   tail = tmp;				// new tail
		   
		   size++;
	   }	   
   }
       
   public Item removeFirst()                // remove and return the item from the front
   {
	   throwIfEmpty();

	   Item ret = head.value;

	   head = head.next;
	   if(head != null)
		   head.prev = null;
	   else
		   tail = head;
	   
	   --size;
	   
       return ret;
   }
       
   public Item removeLast()                 // remove and return the item from the end
   {
	   throwIfEmpty();
	   
	   Item ret = tail.value;
	   	   
	   tail = tail.prev;    
	   if(tail != null )
		   tail.next = null;
	   else
		   head = tail;
	   
	   --size;
	   
       return ret;
   }
       
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
       return new DequeIterator(head);   
   }

   private class DequeIterator implements Iterator<Item>
   {
	   private node current;
	   
	   public DequeIterator(node head)
	   {		   
		   current = head;
	   }
	   
	   public boolean hasNext() { return current != null; }
	   
	   public Item next()
	   {
		   if(!hasNext()) throw new java.util.NoSuchElementException();
		   
		   Item next = current.value;
		   current = current.next;
		   
		   return next;
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