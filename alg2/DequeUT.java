import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class DequeUT
{
	private static void trace(String msg)
	{
		StdOut.println(msg);		
	}
	
   public static void utCheckCornerCases()
   {
	   trace("calling utCheckCornerCases...");
	   trace("{");
	   Deque<Integer> d = new Deque<>();
	   for (int i = 0; i < 2; ++i)
	   {
		   try {
			   if(i==0) d.addFirst(null);
			   if(i==1) d.addLast(null);			   
		   } catch (java.lang.IllegalArgumentException ia) {
			   
			   trace("PASS calling addFirst/addLast(null) - caught IllegalArgumentException");
		   } catch (java.lang.Exception e) {
			   
			   trace("FAIL calling addFirst/addLast(null) - " + e.getMessage());
		   }
		   
		   try {
			   if(i==0) d.removeFirst();
			   if(i==1) d.removeLast();
		   } catch (java.util.NoSuchElementException nse) {
			   
			   trace("PASS calling removeFirst/removeLast - caught NoSuchElementException");
		   } catch (java.lang.Exception e) {
			   
			   trace("FAIL calling removeFirst/removeLast - " + e.getMessage());
		   }
		   
		   try {
			  
			   Iterator<Integer> itor = d.iterator();
			   if(i==0) itor.next();
			   if(i==1) itor.remove();
			   
		   } catch (java.util.NoSuchElementException nse) {
			   
			   trace("PASS calling next() - caught NoSuchElementException");
		   } catch (java.lang.UnsupportedOperationException  e) {
			   
			   trace("PASS calling remove() - caught UnsupportedOperationException");
		   } catch (java.lang.Exception e) {
			   
			   trace("FAIL calling next/remove() - " + e.getMessage());
		   }
	   }

	   trace("}");	   
	   trace("calling utCheckCornerCases...Done.");
   }
   
   public static void utCheckOneItem()
   {
	   trace("calling utCheckOneItem...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   
	   trace("Default size: " + dq.size());
	   trace("Default IsEmpty: " + dq.isEmpty());
	   
	   Integer i = 1;
	   Integer ri = 0;
	   
	   dq.addFirst(i);
	   trace("Expected size: 1, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   ri = dq.removeLast();
	   trace("addFirst(): " + i + ", removeLast(): " + ri);

	   dq.addLast(2);
	   trace("addLast(): " + i + ", removeFirst(): " + ri);

	   ri = dq.removeFirst();
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   trace("Iterate through list: ");
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   trace(""+dqIter1.next());
	   }
	   
	   trace("}");
	   trace("calling utCheckOneItem...Done.");	   
   }
   
   
   public static void utAddRemoveFirsts()
   {
	   trace("calling utAddRemoveFirsts...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   trace("Iterate through list: ");
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   trace(""+dqIter1.next());
	   }
	   
	   trace("}");
	   trace("calling utAddRemoveFirsts...Done.");
   }

   public static void utAddRemoveLasts()
   {
	   trace("calling utAddRemoveLasts...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   trace("Iterate through list: ");	   
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   trace(""+dqIter1.next());
	   }
	   
	   trace("}");
	   trace("calling utAddRemoveLasts...Done.");
   }

   public static void utAddRemoveMixedup()
   {
	   trace("calling utAddRemoveMixedup...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   
	   
	   trace("Iterate through list: ");	   

	   trace("}");	   
	   trace("calling utAddRemoveMixedup...Done.");
   }

   public static void utAddRemoveMixedup2()
   {
	   trace("calling utAddRemoveMixedup2...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   	   
	   // remove first few
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("Expected size: 5, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   // add last few again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());

	   // remove first all
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   /////////////////////////////////////
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeLast();
	   }
	   trace("Expected size: 5, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   

	   // add first again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first again
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }

	   trace("Iterate through list: ");

	   trace("}");	   
	   trace("calling utAddRemoveMixedup2...Done.");
   }

   public static void utAddRemoveMixedup3_Iterator1()
   {
	   trace("calling utAddRemoveMixedup3_Iterator1...");
	   trace("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   trace("1 Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("2 Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   // remove first few
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("3 Expected size: 5, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   // add last few again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addLast(i);
	   }
	   trace("4 Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   // remove first all
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   trace("5 Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   /////////////////////////////////////
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("6 Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   	   
	   // remove first
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeLast();
	   }
	   trace("7 Expected size: 5, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   
	   
	   // add first again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addFirst(i);
	   }
	   trace("8 Expected size: 10, Actual size: " + dq.size());
	   trace("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   // remove first again
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   trace("9 Expected size: 0, Actual size: " + dq.size());
	   trace("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   trace("Iterate through list: ");
	   
	   trace("}");	   
	   trace("calling utAddRemoveMixedup3_Iterator...Done.");
	   
   }
   
   public static void main(String[] args)   // unit testing (optional)
   {
	   utCheckCornerCases();
	   
	   utCheckOneItem();
	   
	   utAddRemoveFirsts();
	   
	   utAddRemoveLasts();
	   
	   utAddRemoveMixedup();
	   
	   utAddRemoveMixedup2();
	   
	   utAddRemoveMixedup3_Iterator1();

   }
}