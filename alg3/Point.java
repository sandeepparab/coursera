import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Date;

public class Point  implements Comparable<Point> 
{
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	    	
    	if ( this.y == that.y ) return 0;	// horizontal line    	
    	if ( this.x == that.x ) return Double.POSITIVE_INFINITY;  // vertical line    	
    	if ( (this.x == that.x) && (this.y == that.y) ) return Double.NEGATIVE_INFINITY;
    	
    	double slope = (that.y - this.y) / (that.x - this.x);    	
    	return slope;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) 
    {   
    	/* YOUR CODE HERE */
    	
    	if(this.y < that.y || ( this.y == that.y && this.x < that.x)) 
    	{
    	
    		// point0 < point1
    		return -1;
    	} else if (this.y > that.y || (this.y == that.y && this.x > that.y)) {
    	
    		// point0 > point1
    		return 1;
    	} 
    	
    	// point0 == point1
    	return 0;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
    	
    	return new SlopeOrder(this);
    }

    private class SlopeOrder implements Comparator<Point>
    {
    	private Point p0;
    	public SlopeOrder(Point p)
    	{
    		p0 = p;
    	}
    	
    	public int compare (Point p1, Point p2)
    	{
    		double slope_p0_2_p1 = p0.slopeTo(p1);
    		double slope_p0_2_p2 = p0.slopeTo(p2);    		
    		
    		if(slope_p0_2_p1 < slope_p0_2_p2) return -1;
    		if(slope_p0_2_p1 > slope_p0_2_p2) return 1;
    		return 0;
    	}
    }
    

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
	
    private static void trace(String msg)
    {
    	String now = new Date().toString();
    	
    	StdOut.println(now + " : " + msg);
    }
    
    private static void utCompareTo()
    {
    	trace("calling utCompareTo...");
    	
    	trace("Check < ...");
    	Point p0 = new Point(1,1);
    	Point p1 = new Point(2,2);
    	int result = p0.compareTo(p1);
    	if( result == -1) { trace ("p0 < p1");}
    	if( result == 1) { trace ("p0 > p1");}
    	if( result == 0) { trace ("p0 == p1");}
    	
    	trace("Check > ...");
    	result = p1.compareTo(p0);
    	if( result == -1) { trace ("p0 < p1");}
    	if( result == 1) { trace ("p0 > p1");}
    	if( result == 0) { trace ("p0 == p1");}
    	
    	trace("Check == ...");
    	Point p2 = new Point(1,1);
    	result = p2.compareTo(p0);
    	if( result == -1) { trace ("p0 < p1");}
    	if( result == 1) { trace ("p0 > p1");}
    	if( result == 0) { trace ("p0 == p1");}

    	/*
    	trace("check draw capability...");
    	p0.draw();
    	p1.draw();
    	p0.drawTo(p1);
    	*/    	
    	trace("calling utCompareTo...Done.");
    	
    }
    
	public static void main(String[] args) 
	{
		utCompareTo();
	
		
	}
}
