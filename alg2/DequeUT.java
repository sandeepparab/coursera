import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class DequeUT
{
   public static void utCheckCornerCases()
   {
	   StdOut.println("calling utCheckCornerCases...");
	   StdOut.println("{");
	   Deque<Integer> d = new Deque<>();
	   for (int i = 0; i < 2; ++i)
	   {
		   try {
			   if(i==0) d.addFirst(null);
			   if(i==1) d.addLast(null);			   
		   } catch (java.lang.IllegalArgumentException ia) {
			   
			   StdOut.println("PASS calling addFirst/addLast(null) - caught IllegalArgumentException");
		   } catch (java.lang.Exception e) {
			   
			   StdOut.println("FAIL calling addFirst/addLast(null) - " + e.getMessage());
		   }
		   
		   try {
			   if(i==0) d.removeFirst();
			   if(i==1) d.removeLast();
		   } catch (java.util.NoSuchElementException nse) {
			   
			   StdOut.println("PASS calling removeFirst/removeLast - caught NoSuchElementException");
		   } catch (java.lang.Exception e) {
			   
			   StdOut.println("FAIL calling removeFirst/removeLast - " + e.getMessage());
		   }
		   
		   try {
			  
			   Iterator<Integer> itor = d.iterator();
			   if(i==0) itor.next();
			   if(i==1) itor.remove();
			   
		   } catch (java.util.NoSuchElementException nse) {
			   
			   StdOut.println("PASS calling next() - caught NoSuchElementException");
		   } catch (java.lang.UnsupportedOperationException  e) {
			   
			   StdOut.println("PASS calling remove() - caught UnsupportedOperationException");
		   } catch (java.lang.Exception e) {
			   
			   StdOut.println("FAIL calling next/remove() - " + e.getMessage());
		   }
	   }

	   StdOut.println("}");	   
	   StdOut.println("calling utCheckCornerCases...Done.");
   }
   
   public static void utCheckOneItem()
   {
	   StdOut.println("calling utCheckOneItem...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   
	   StdOut.println("Default size: " + dq.size());
	   StdOut.println("Default IsEmpty: " + dq.isEmpty());
	   
	   Integer i = 1;
	   Integer ri = 0;
	   
	   dq.addFirst(i);
	   StdOut.println("Expected size: 1, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   ri = dq.removeLast();
	   StdOut.println("addFirst(): " + i + ", removeLast(): " + ri);

	   dq.addLast(2);
	   StdOut.println("addLast(): " + i + ", removeFirst(): " + ri);

	   ri = dq.removeFirst();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   StdOut.println("Iterate through list: ");
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   StdOut.println("}");
	   StdOut.println("calling utCheckOneItem...Done.");	   
   }
   
   
   public static void utAddRemoveFirsts()
   {
	   StdOut.println("calling utAddRemoveFirsts...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   StdOut.println("Iterate through list: ");
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   StdOut.println("}");
	   StdOut.println("calling utAddRemoveFirsts...Done.");
   }

   public static void utAddRemoveLasts()
   {
	   StdOut.println("calling utAddRemoveLasts...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   StdOut.println("Iterate through list: ");	   
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   StdOut.println("}");
	   StdOut.println("calling utAddRemoveLasts...Done.");
   }

   public static void utAddRemoveMixedup()
   {
	   StdOut.println("calling utAddRemoveMixedup...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   
	   
	   StdOut.println("Iterate through list: ");	   
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }

	   StdOut.println("}");	   
	   StdOut.println("calling utAddRemoveMixedup...Done.");
   }

   public static void utAddRemoveMixedup2()
   {
	   StdOut.println("calling utAddRemoveMixedup2...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   	   
	   // remove first few
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   // add last few again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());

	   // remove first all
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   /////////////////////////////////////
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeLast();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   

	   // add first again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   
	   // remove first again
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }

	   StdOut.println("Iterate through list: ");
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }

	   StdOut.println("}");	   
	   StdOut.println("calling utAddRemoveMixedup2...Done.");
   }

   public static void utAddRemoveMixedup3_Iterator1()
   {
	   StdOut.println("calling utAddRemoveMixedup3_Iterator1...");
	   StdOut.println("{");
	   
	   Deque<Integer> dq = new Deque<>();
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   // add last
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   Iterator<Integer> dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // remove first few
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // add last few again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addLast(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());

	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // remove first all
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeFirst();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());
	   
	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   /////////////////////////////////////
	   
	   // add first
	   for(int i=0; i < 10; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // remove first
	   for(int i=0; i < 5; ++i)
	   {
		   dq.removeLast();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());	   
	   
	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // add first again
	   for(int i=0; i < 5; ++i)
	   {
		   dq.addFirst(i);
	   }
	   StdOut.println("Expected size: 10, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: false, Actual isEmpty: " + dq.isEmpty());
	   
	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   // remove first again
	   for(int i=0; i < 10; ++i)
	   {
		   dq.removeLast();
	   }
	   StdOut.println("Expected size: 0, Actual size: " + dq.size());
	   StdOut.println("Expected isEmpty: true, Actual isEmpty: " + dq.isEmpty());

	   StdOut.println("Iterate through list: ");
	   dqIter1 = dq.iterator();
	   while(dqIter1.hasNext())
	   {
		   StdOut.println(dqIter1.next());
	   }
	   
	   StdOut.println("}");	   
	   StdOut.println("calling utAddRemoveMixedup3_Iterator...Done.");
	   
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