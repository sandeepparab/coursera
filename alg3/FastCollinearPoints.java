
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
		
	private static class MergeBU
	{
		private static Comparable<PointInfo>[] aux;
		
		@SuppressWarnings("unchecked")		
		public static void sort(Comparable<PointInfo>[] arr)
		{
			int n = arr.length;
		
			aux = (Comparable<PointInfo>[])new Comparable[n];
			
			for(int sz=1; sz<n; sz+=sz)
			{
				for(int lo=0; lo<n-sz; lo=sz+sz)
				{
					merge(arr, lo, lo-sz+1, Math.min(lo+sz+sz-1, n-1));					
				}				
			}		
		}
		private static boolean less(Comparable<PointInfo> a, Comparable<PointInfo> b )
		{
			return (a.compareTo((PointInfo)b) == -1);
		}
		
		private static void merge(Comparable<PointInfo>[] arr, int lo, int mid, int hi)
		{
			// copy
			for(int k=lo; k<= hi; k++)
				aux[k] = arr[k];
			
			// merge
			int i=lo, j=mid+1;
			for(int k=lo; k<=hi; k++)
			{
				if(i > mid) 				  arr[k] = aux[j++];
				else if(k > hi)  			  arr[k] = aux[i++];
				else if(less(aux[j], aux[i])) arr[k] = aux[j++];
				else						  arr[k] = aux[i++];
			}
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
