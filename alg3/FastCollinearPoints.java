
public class FastCollinearPoints 
{
	private Point[] points;
	private LineSegment[] segments;
	private PointInfo[] pi; 

	private class PointInfo implements Comparable<PointInfo>
	{
		public double slope;
		public Point point;
		
		public PointInfo(Point p, double s) 
		{
			point = p;
			slope = s;
		}

		@Override
		public int compareTo(PointInfo that)
		{
			if(this.slope < that.slope) return -1;
			else if (this.slope > that.slope) return +1;
			
			return 0;
		}
	}
		
	
	private void doWork()
	{
		int k=0;
		for (int i=0; i<points.length; ++i)
		{
			// calculate slope of each point to rest of the points
			for (int j=0; j<points.length; ++j)
			{				
				if(i==j) continue;

				pi[k].slope = points[i].slopeTo(points[j]); 
				pi[k].point = points[j];				
			}
		
			// sort slopes
			MergeBU.sort(pi);
			
			// check points with same slopes to segments list
			
			
			// repeat for all points			
		}

	}
	
	public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
	{
		this.points = points;
		this.pi = new PointInfo[points.length-1];
		
		doWork();
	}
	
	public int numberOfSegments()        // the number of line segments
	{
		
		return segments.length;
	}
	
	public LineSegment[] segments()                // the line segments
	{
		return segments;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
