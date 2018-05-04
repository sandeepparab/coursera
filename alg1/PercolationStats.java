//import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats 
{
   private double Run_Percolation(int size)
   {
       int grid_size = size;
       Percolation percltn = new Percolation(grid_size);             
       
       // percltn.Debug_Dump_Grid_State();
       
       int x,y;
       while (!percltn.percolates())
       {
           x = StdRandom.uniform(1000) % (grid_size);
           y = StdRandom.uniform(2000) % (grid_size);
           percltn.open(x+1,y+1);
       }   
       int open_sites = percltn.numberOfOpenSites();
       double pVal = ((double) open_sites / (double)(grid_size*grid_size) );
       
       
       // percltn.Debug_Dump_Grid_State();
       return pVal;
   }
   
   private double x[];
   private double T;
   private double mean_;
   private double stddev_;
   private double sqrt_T_;
   private double cLo_;
   private double cHi_;
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {   
       if(n <= 0 || trials <= 0)
           throw new IllegalArgumentException("Invalid params: n=" + n + ", T=" + trials);
       
       T = (double)trials;
       
       x = new double[trials];       
       for(int i=0; i<T; ++i)
       {
           x[i] = Run_Percolation(n);
       }
       
       mean_=0;
       stddev_=0;
       sqrt_T_= Math.sqrt(T);
       cLo_=0;
       cHi_=0;
   }
   
   private void do_calculations()
   {
       mean_ = StdStats.mean(x);
       stddev_ = StdStats.stddev(x);
       cLo_ = (mean_ - ( (1.96*stddev_) / sqrt_T_ ) );
       cHi_ = (mean_ + ( (1.96*stddev_) / sqrt_T_ ));
   }
   
   public double mean()                          // sample mean of percolation threshold
   {
     if(mean_ == 0)  
         do_calculations();
     
     return mean_;
   }
   
   public double stddev()                        // sample standard deviation of percolation threshold
   { 
       if(stddev_ == 0)
           do_calculations();  
       
       return stddev_;
   }
   
   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {
       if(cLo_==0)
           do_calculations();
                     
       return cLo_;
   }
   
   public double confidenceHi()                  // high endpoint of 95% confidence interval
   {
       if(cHi_==0)
           do_calculations();
                     
       return cHi_;
   }

   public static void main(String[] args)        // test client (described below)
   {
       if(args.length != 2)
       {
           StdOut.println("Usage: percolation grid_size trials");
           return;
       }
       int grid_size = Integer.parseInt(args[0]);
       int trials = Integer.parseInt(args[1]);

       //int grid_size = 10;
       //int trials = 10;
       
       if(grid_size > 0 && trials > 0)
       {       
           PercolationStats ps = new PercolationStats(grid_size, trials);
           StdOut.println("mean                    = " + ps.mean());
           StdOut.println("stddev                  = " + ps.stddev());
       
           double cLo = ps.confidenceLo();
           double cHi = ps.confidenceHi();
           StdOut.println("95% confidence interval = [" + cLo + ", " + cHi + "]");
       }
   }
}
