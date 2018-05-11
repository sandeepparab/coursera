import edu.princeton.cs.algs4.StdOut;

public class MergeBU <T extends Comparable<T>> 
{
	public static class PointInfo implements Comparable<PointInfo>
	{
		public double slope;
		
		public PointInfo(double s)
		{
			slope = s;
		}
		
		@Override
		public int compareTo(PointInfo that)
		{
			int ret = 0;
			if(this.slope < that.slope) ret= -1;
			else if (this.slope > that.slope) ret= +1;
			
			trace("PointInfo: compareTo: [" + that.slope + ", " + this.slope + "]" );
			return ret;
		}
	}
	
	private T[] aux;

	private static void trace(String msg)
	{
		StdOut.println("MergeBU>" + msg);
	}
		
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> boolean less(T a, T b)
	{		
		boolean ret = (a.compareTo(b) < 0);
		trace ("less: return:" + ret );
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public void sort(T[] arr)
	{
		int n = arr.length;
	
		aux = (T[])new Comparable[n];
		
		for(int sz=1; sz<n; sz+=sz)
		{
			//trace("sort: sz=" +sz);
			for(int lo=0; lo<n-sz; lo+=sz+sz)
			{
				//trace("sort: lo=" +lo + ", sz=" +sz +", n="+n);
				merge(arr, lo, lo-sz+1, Math.min(lo+sz+sz-1, n-1));
			}				
		}		
	}

	private void merge(T[] arr, int lo, int mid, int hi)
	{
		trace("merge: lo=" +lo + ", mid=" +mid +", hi=" +hi);
		
		// copy
		for(int k=lo; k<= hi; k++)
			aux[k] = arr[k];

		for(int i=0; i <= hi; ++i)
		{
			trace("[aux]>" + ((PointInfo)aux[i]).slope + ", [arr]>" + ((PointInfo)arr[i]).slope);
		}

		
		// merge
		int i=lo, j=mid+1;
		for(int k=lo; k<hi; k++)
		{
			if(i > mid) 				  arr[k] = aux[j++];
			else if(k > hi)  			  arr[k] = aux[i++];
			else if(less(aux[j], aux[i])) arr[k] = aux[j++];
			else						  arr[k] = aux[i++];
		}
	}
	
	
	private static void utBasic1()
	{
		PointInfo[] arr1 = new PointInfo[5];
		
		arr1[0] = new PointInfo(20.0);
		arr1[1] = new PointInfo(19.0);
		arr1[2] = new PointInfo(55.0);
		arr1[3] = new PointInfo(99.0);
		arr1[4] = new PointInfo(1.0);
		
		for(int i=0; i < arr1.length; ++i)
		{
			trace(">" + arr1[i].slope);
		}
		
		new MergeBU<PointInfo>().sort(arr1);

		for(int i=0; i < arr1.length; ++i)
		{
			trace(">" + arr1[i].slope);
		}
		
	}
	
	public static void main(String[] args) 
	{
		utBasic1();		
	}
}
