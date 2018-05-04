
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
    
public class Percolation 
{   
   final private WeightedQuickUnionUF wqu_uf_;      

   final private int grid_size_;
   final private int vsite_top_index_;
   final private int vsite_bottom_index_;
   private int open_sites;
   
   // site can be closed(default) or open, 
   private enum state { close, open };
   
   // NxN grid of sites 
   private state grid_[][];
 
   //
   //  Public ===================================================================
   //
   
   // create n-by-n grid, with all sites blocked
   public Percolation(int n)                
   {
       if(n <= 0)
           throw new IllegalArgumentException("Percolation(n)=" + n);

       // init site grid as closed
       grid_ = new state [n] [n];
       grid_size_ = n;
       open_sites = 0;
              
       int virtual_site_count = 2;       
       
       // setup weighted union find array
       wqu_uf_ = new WeightedQuickUnionUF( grid_size_ * grid_size_ + virtual_site_count );
              
       for(int i=0; i < grid_size_; ++i)
       {
           for(int j=0; j < grid_size_; ++j)
           {
               grid_[i][j] = state.close;
           }
       }
       
       // last node of grid
       int last_node = (grid_size_ * grid_size_);
       vsite_top_index_ = last_node;
       vsite_bottom_index_ = vsite_top_index_ + 1;       
   }
   
   public void open(int row, int col)    // open site (row, col) if it is not open already
   {
       row -=1;
       col -=1;
       validate_and_throw(row, col);
       
       // if site not already open site
       if(grid_[row][col] != state.open)
       {
           grid_[row][col] = state.open;
           open_sites++;
       
           int site_index = get_site_index(row, col);
           
           // connect sites in top row to top virtual site
           if(row==0)
           {
               wqu_uf_.union(site_index, vsite_top_index_); 
           }
           
           // connect sites in bottom row to botoom virtual site
           if(row==grid_size_-1)
           {
               wqu_uf_.union(site_index, vsite_bottom_index_); 
           }
                      
           update_uf_internal_state(row, col);
       }
   }
   
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       row -=1;
       col -=1;
       validate_and_throw(row, col);

       return grid_[row][col] == state.open;
   }
     
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       row -=1;
       col -=1;
       validate_and_throw(row, col);       
       
       if(isOpen(row+1,col+1)) 
           return wqu_uf_.connected(vsite_top_index_, get_site_index(row,col));
       
       return false;
   }
     
   public int numberOfOpenSites()       // number of open sites
   {
       return open_sites;
   }
   
   public boolean percolates()              // does the system percolate?
   {
       // special case 1
       if(grid_size_==1)
           return numberOfOpenSites() == 1;
       
       // special case 2
       if(grid_size_==2)
           return (grid_[0][0]==state.open && grid_[1][0]==state.open)||
                  (grid_[0][1]==state.open && grid_[1][1]==state.open);
       
       
       // check if virtual nodes are connected
       return wqu_uf_.connected(vsite_top_index_, vsite_bottom_index_);
   }
   
   //
   //  Internal ===================================================================
   //
      
   private boolean validate_input(int row, int col)
   {
      if ((row < 0) || (row >= grid_size_) || (col < 0) || (col >= grid_size_) )
      {
          return false;
      }
      return true;
   }
   
   private void validate_and_throw(int row, int col)
   {
       if( !validate_input( row,  col) )
          throw new IllegalArgumentException("Index is not between 0 and " + (grid_size_ - 1));
       
   }

   private int get_site_index(int row, int col)
   {
       return row*grid_size_+col;
   }
   
   /*
   private void debug_log(String msg)
   {
       // StdOut.println(msg);
   }
   */
   
   private void update_uf_internal_state(int row, int col)
   {
       int site0 = get_site_index(row, col);
       
       // up
       int site1 = get_site_index(row-1, col);
       if(validate_input(row-1, col) && grid_[row-1][col] == state.open)
       {           
           //debug_log("calling wqu_uf_.union(" + site0 + "," + site1 + ")");
           wqu_uf_.union(site0, site1);
       }
              
       // down
       site1 = get_site_index(row+1, col);
       if(validate_input(row+1, col) && grid_[row+1][col] == state.open)
       {
           //debug_log("calling wqu_uf_.union(" + site0 + "," + site1 + ")");
           wqu_uf_.union(site0, site1);
       }
       
       // left
       site1 = get_site_index(row, col-1);
       if(validate_input(row, col-1) && grid_[row][col-1] == state.open)
       {
           //debug_log("calling wqu_uf_.union(" + site0 + "," + site1 + ")");
           wqu_uf_.union(site0, site1);
       }
       
       // right
       site1 = get_site_index(row, col+1);
       if(validate_input(row, col+1) && grid_[row][col+1] == state.open)
       {
           //debug_log("calling wqu_uf_.union(" + site0 + "," + site1 + ")");
           wqu_uf_.union(site0, site1);
       }   
   }
   
   //
   //  Unit Tests ===================================================================
   //
   /*
   public WeightedQuickUnionUF Debug_Get_WQU_UF()
   {
       return wqu_uf_;
   }
   
   public void Debug_Dump_Grid_State()
   {       
       for(int i=0; i < grid_size_; ++i)
       {
           for(int j=0; j < grid_size_; ++j)
           {               
               StdOut.print( grid_[i][j] == state.open ? "(V)" : "(~)" );   
           }
           StdOut.println("");
       }   
   }   
   public static void UT_Test1()
   {
       WeightedQuickUnionUF wqu_uf = new WeightedQuickUnionUF(5);       
       StdOut.println("TEST(WeightedQuickUnionUF): Is connected(expected: false), actual: "+wqu_uf.connected(0,4));
       wqu_uf.union(0,1);
       wqu_uf.union(1,2);
       wqu_uf.union(2,3);
       wqu_uf.union(3,4);
       StdOut.println("TEST(WeightedQuickUnionUF): Is connected(expected: true), actual: "+wqu_uf.connected(0,4));          
   }
   
   public static void UT_Test2()
   {
       int grid_size = 3;
       Percolation percltn = new Percolation(grid_size);       
       int last_node = grid_size*grid_size-1;
       
       WeightedQuickUnionUF wqu_uf = percltn.Debug_Get_WQU_UF();
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(0,last_node+1));       
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(1,last_node+1)); 
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(2,last_node+1)); 

       int last_row = last_node-grid_size;
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(last_row,last_node+2));       
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(last_row+1,last_node+2)); 
       StdOut.println("TEST -2: Is connected(expected: true), actual: " + wqu_uf.connected(last_row+2,last_node+2));       
   }
   
   public static void UT_Test3()
   {
       int grid_size = 3;
       Percolation percltn = new Percolation(grid_size);              
       
       StdOut.println("TEST -3: Current state of percolation(PRE): " + percltn.numberOfOpenSites());       
       
       boolean test_3_result = false;

       test_3_result = percltn.percolates();
       StdOut.println("TEST -3: Current state of percolation(PRE): " + test_3_result);       
       
       for(int i = 0; i < grid_size; ++i)
       {
           StdOut.println("TEST -3: Is Open), actual(" + i + "," + 0 +"):"  + percltn.isOpen(i,0));
           percltn.open(i,0);       
           StdOut.println("TEST -3: Is Open), actual(" + i + "," + 0 +"):"  + percltn.isOpen(i,0));
       }

       test_3_result = percltn.percolates();
       StdOut.println("TEST -3: Current state of percolation(POST): " + test_3_result);       
   }

   public static void UT_Test4()
   {
       int grid_size = 3;
       Percolation percltn = new Percolation(grid_size);       

       StdOut.println("Test0: No default open sites:" + 
                      (percltn.numberOfOpenSites()==0? "PASS" : "FAIL"));
   
   }

   public static void  UT_Test5(int size, int row, int col)
   {
       int grid_size = size;
       Percolation percltn = new Percolation(grid_size);       

       try 
       {
           percltn.open(row,col);
           percltn.isOpen(row,col);
           percltn.isFull(row,col);
       }
       catch(java.lang.IllegalArgumentException e)
       {
           StdOut.println("Test1: Input params validation: PASS");
       }
       catch(java.lang.Exception e)
       {
           StdOut.println("Test1: Input param validation: FAIL");
       }   
   }
   
   public static void UT_Test6()
   {
       int grid_size = 3;
       Percolation percltn = new Percolation(grid_size);       
       
       //
       // Test2 - Check number of default open sites 
       //        
       boolean test2_result = percltn.numberOfOpenSites() == 0;   
       StdOut.println("Test2: Default number of open sites: " + 
                      (test2_result ? "PASS" : "FAIL"));
       
                      
       //
       // Test3 - Default and updated site state
       //
       boolean test3_result = percltn.isOpen(0,0);
       StdOut.println("Test3a: Default site state(0,0), closed: " + 
                      (!test3_result ? "PASS" : "FAIL"));

       percltn.open(0,0);
                      
       test3_result = percltn.isOpen(0,0);
       StdOut.println("Test3b: Updated site state(0,0), open: " + 
                      (test3_result ? "PASS" : "FAIL"));
    
    
       //
       // Test4 - Default state of percolation in grid
       //
       boolean test4_result = percltn.percolates();
       StdOut.println("Test4: Default state of percolation: " + 
                      (!test4_result ? "PASS" : "FAIL"));              
   }
   
   public static void Run_Percolation(int size)
   {
       int grid_size = size;
       Percolation percltn = new Percolation(grid_size);             
       
       //percltn.Debug_Dump_Grid_State();
       
       int x,y;
       while (!percltn.percolates())
       {
           x = StdRandom.uniform(1000) % (grid_size);
           y = StdRandom.uniform(1000) % (grid_size);
           percltn.open(x,y);
       }   
       int open_sites = percltn.numberOfOpenSites();
       float pVal = ((float) open_sites / (float)(grid_size*grid_size) );
       
       StdOut.println("Grid size: " + grid_size + " X " + grid_size  + 
                      ", Percolation size: " + open_sites + ", Threshold: " + pVal);              
       
       //percltn.Debug_Dump_Grid_State();
   }

   public static void UT_Test8()
   {
       int grid_size = 2;
       boolean numbers[] = new boolean[grid_size];
       for(int i=0; i<grid_size; i++)
           numbers[i]=false;
       
       for(int i=0; i<100; i++)
       {
           int x = StdRandom.uniform(1000) % (grid_size);
           numbers[x]=true;
       }

       for(int i=0; i<grid_size; i++)
       {
           if(!numbers[i])
           StdOut.println("Random  failed at:" + i);              
       }
   }   
   */
   
   public static void main(String[] args)   // test client (optional)
   {
       /*
       UT_Test1();
       UT_Test2();
       UT_Test3();
       UT_Test4();
       UT_Test5(3, -1,-1);
       UT_Test5(3, 3, 3);
       UT_Test5(3, 3, 0);
       UT_Test5(3, 0, 3);
       UT_Test6();
       UT_Test7();
       UT_Test8();
       */
       long t1 = System.currentTimeMillis();
       {
           int grid_size = 3;
           Percolation percltn = new Percolation(grid_size); 
           /*
           for(int i=1; i<grid_size; i++)
           {
               for(int j=1; j<=grid_size; j++)
               {
                   percltn.open(i,j);
               }
           }
           */
           percltn.open(1,1);
           percltn.open(2,1);
           percltn.open(2,2);
           percltn.open(3,3);
           
           StdOut.println("isFull(3,1):" + percltn.isFull(3,1));
           StdOut.println("isOpen(3,1):" + percltn.isOpen(3,1));
           StdOut.println("percolates:" + percltn.percolates());
           
           /*
           //percltn.Debug_Dump_Grid_State();
           StdOut.println("isFull(1,1):" + percltn.isFull(1,1));
           StdOut.println("isOpen(1,1):" + percltn.isOpen(1,1));
           StdOut.println("percolates:" + percltn.percolates());
           int x,y;
           while (!percltn.percolates())
           {
               x = StdRandom.uniform(1000) % (grid_size);
               y = StdRandom.uniform(1000) % (grid_size);
               percltn.open(x+1,y+1);
           }   
           int open_sites = percltn.numberOfOpenSites();
           float pVal = ((float) open_sites / (float)(grid_size*grid_size) );
           
           StdOut.println("Grid size: " + grid_size + " X " + grid_size  + 
                          ", Percolation size: " + open_sites + ", Threshold: " + pVal);       
           */
       }
       t1 = System.currentTimeMillis()-t1;
       StdOut.println("Time taken(ms):" + t1);       
   }
}