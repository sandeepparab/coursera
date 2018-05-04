import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class DequeUT
{
   public static void utCheckCornerCases()
   {
	   Deque<Integer> d = new Deque<Integer>();
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
   }
   
   public static void main(String[] args)   // unit testing (optional)
   {
	   utCheckCornerCases();
   }
}