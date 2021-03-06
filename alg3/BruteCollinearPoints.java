//import java.util.Date;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;

//import java.util.*;

public class BruteCollinearPoints 
{
	private Point[] plist;
	private LineSegment[] segments;
	private int count;
	
	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
	{
		thowifnull(points);
		
		if(points.length < 4) throw new java.lang.IllegalArgumentException();
		
		plist = points;
		
		doWork();
	}
	   
	public int numberOfSegments()        // the number of line segments
	{		   
		return count;
	}
	
	private static void thowifnull(Object o)
	{
		if(o == null) 
			throw new java.lang.IllegalArgumentException();
	}
	
	private static void thowifsame(Point p0, Point p1)	
	{
		if(p0.compareTo(p1) == 0) 
			throw new java.lang.IllegalArgumentException();
	}
	
	private void doWork()
	{
		if(segments == null)
		{
			int count = plist.length;
			int scount = 0;
			
			// process points
			for(int p=0; p < count-3; p++)
			{
				for(int q=0; q < count-2; q++)
				{					
					for(int r=0; r < count-1; r++)
					{
						for(int s=0; s < count; s++)
						{
							thowifnull(plist[p]);
							thowifnull(plist[q]);
							thowifnull(plist[r]);
							thowifnull(plist[s]);
							
							thowifsame(plist[p], plist[q]); 
							thowifsame(plist[p], plist[r]);
							thowifsame(plist[p], plist[s]);
							
							//check whether the three slopes between 
							// p and q, between p and r, 
							// and between p and s are all equal.	
							double slope_p2q = plist[p].slopeTo(plist[q]);
							double slope_p2r = plist[p].slopeTo(plist[r]);
							double slope_p2s = plist[p].slopeTo(plist[s]);
							
							if ( slope_p2q == slope_p2r && slope_p2r == slope_p2s)
							{
								LineSegment ls = new LineSegment(plist[p], plist[s]);
	
								LineSegment[] tmp = new LineSegment[++scount];
								if(scount > 0)
								{
									for(int i=0; i<segments.length; i++)
									{
										tmp[i] = segments[i];
									}
								}
								segments = tmp;
								
								segments[scount-1] = ls;
							}							
						}												
					}	
				}				
			}
		}		
	}
	
	public LineSegment[] segments()                // the line segments
	{		
		return segments;
	}
	
	public static void main(String[] args) {

	    // read the n points from a file
	    In in = new In(args[0]);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}		
}
