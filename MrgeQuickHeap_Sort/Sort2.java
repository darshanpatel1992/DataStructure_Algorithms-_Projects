/* Name: Darshan Patel 
 * Njit id: dap83
 * Program 2 for Large size array*/

import java.io.IOException;
	//import java.util.Arrays;
	import java.util.Random;

public class Sort2 {

		public static int CompCountMerge=0;
	    public static int CompCountQuick=0;
	    public static int CompCountHeap=0;


	public static void main(String args[])throws IOException
	{
	int i;
	 int len=1024;
	// int len=32768;
	// int len=1048576;

	double Stime,Etime,Ttime;
	int[] arrMerge=new int[len];
	int[] arrQuick=new int[len];
	int[] arrHeap=new int[len];
	System.out.println("Before sorting numer");	
	System.out.println("Where N=1024");
	//System.out.println("Where N=32768");
	//System.out.println("Where N=1048576");
	for (i=0;i<len;++i)
	{
			Random rand =new Random();
          
		int y=rand.nextInt(len);
			arrMerge[i]=y;
			arrQuick[i]=y;
			arrHeap[i]=y;
			//Uncomment below statement for show input unsorted array list 
			
			//System.out.print(" "+ y);		
	}
   
System.out.println();
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//MERGE SORT
	System.out.println("\n***MERGE SORT***");
	System.out.println("After sorting numer");
	Stime=System.nanoTime();
		 MSort(arrMerge, 0, len-1);
	 Etime=System.nanoTime();
	//Uncomment below loop for show Output sorted array list of Merge Sort
//	for(int j=0;j<len;++j)
//
//	{    
//		System.out.print(" "+arrMerge[j]);
//
//	}
	Ttime=(Etime-Stime)/1000000.0;
	System.out.println();
	System.out.println("\n# of Key Comparisons Using Merge Sort = "+CompCountMerge);
	System.out.println("Time Taken by Merge Sort = "+Ttime+" Milliseconds");

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Quick Sort
	System.out.println("\n***Quick SORT***");
	System.out.println("After sorting numer");
	Stime=System.nanoTime();
	quickSort(arrQuick,0,arrQuick.length-1);
	Etime=System.nanoTime();
	Ttime=(Etime-Stime)/1000000.0;
	//Uncomment below loop for show Output sorted array list of Quick Sort
//	for(int j=0;j<len;++j)
//
//	{    System.out.print(" "+arrQuick[j]);
//
//	}

	
	System.out.println();
	System.out.println("\n# of Key Comparisons Using Quick Sort = "+CompCountQuick);
	System.out.println("Time Taken by Quick Sort = "+Ttime+" Milliseconds");

	


//	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Heap Sort
	System.out.println("\n***Heap SORT***");
	System.out.println("After sorting numer");
	Stime=System.nanoTime();
	arrHeap=heapSort(arrHeap);
	Etime=System.nanoTime();
	//Uncomment below loop for show Output sorted array list of Heap Sort
//	for(int j=0;j<len;++j)
//
//	{    System.out.print(" "+arrHeap[j]);
//
//	}

	
	Ttime=(Etime-Stime)/1000000.0;
	System.out.println();
	System.out.println("\n# of Key Comparisons Using Heap Sort = "+CompCountHeap);
	System.out.println("Time Taken by Quick Sort = "+Ttime+" Milliseconds");

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void MSort(int Marr[],int s,int e)//Merge Sort Recursion
    {
        if(s>=e)
        {
            return;
        }
        else
        {
            int mid=(s+e)/2;
            MSort(Marr,s,mid);
           MSort(Marr,mid+1,e);
            merge(Marr,s,mid,e);
        }
    }
    public static void merge(int Marr[],int s,int mid,int e)
    {
        int i,j,k;
        int res[]=new int[Marr.length];
        for(i=0;i<Marr.length;++i)
        {
            res[i]=Marr[i];
        }
        i=s;
        j=mid+1;
        k=s;
        while(i<=mid && j<=e)
        {
            if(compareMerge(res[i],res[j]))
            {
                Marr[k]=res[i];
                i++;
            }
            else
            {
                Marr[k]=res[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            Marr[k]=res[i];
            i++;
            k++;
        }
        while(j<=e)
        {
            Marr[k]=res[j];
            j++;
            k++;
        }
    }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   
	   public static void quickSort(int Qarr[],int s,int e)//Quick Sort Recursion
	   {
	       int i,j,temp;
	       if(s>=e)
	       {
	           return;
	       }
	       else
	       {
	           int pp=(int)(Math.random()*(e-s))+s;
	           int pivot=Qarr[pp];
	           temp=Qarr[s];
	           Qarr[s]=Qarr[pp];
	           Qarr[pp]=temp;
	           i=s+1;
	           j=e;
	           while(i<=j)
	           {
	               if(compareQuick(Qarr[i],pivot))
	               {
	                   i++;
	               }
	               else if(Qarr[j]>pivot)
	               {
	                   j--;
	               }
	               else
	               {
	                   temp=Qarr[i];
	                   Qarr[i]=Qarr[j];
	                   Qarr[j]=temp;
	                   i++;
	                   j--;
	               }
	           }
	           temp=Qarr[j];
	           Qarr[j]=Qarr[s];
	           Qarr[s]=temp;
	           quickSort(Qarr,s,j);
	           quickSort(Qarr,j+1,e);
	       }
	   }

	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   public static int[] heapSort(int Harr[])
	       {
	           buildHeap(Harr,1,Harr.length-1);
	           Harr=deleteHeap(Harr,Harr.length-1);
	           return(Harr);
	       }

	       public static void buildHeap(int Harr[],int r,int len)//Build Heap Recursion
	       {
	           if(2*r>len)
	           {
	               return;
	           }
	           else
	           {
	               buildHeap(Harr,2*r,len);
	               buildHeap(Harr,2*r+1,len);
	               pushDownHeap(Harr,r,len);
	           }
	       }
	       public static void buildHeap1(int Harr[],int r,int len)//Build Heap Iteration
	       {
	           int i;
	           for(i=len/2+1;i>=1;--i)
	           {
	               pushDownHeap(Harr,i,len);
	           }
	       }
	       public static int[] deleteHeap(int Harr[],int len)
	       {
	           int i,t;
	           int res[]=new int[Harr.length];
	           for(i=1;i<=Harr.length-1;++i)
	           {
	               t=Harr[1];
	               Harr[1]=Harr[len];
	               len=len-1;
	               pushDownHeap(Harr,1,len);
	               res[i]=t;
	           }
	           return(res);
	       }
	       public static void pushDownHeap(int Harr[],int r,int len)//Push Down Recursion
	       {
	           int s=0;
	           if(2*r>len)
	           {
	               return;
	           }
	           else
	           {
	               if(2*r==len || Harr[2*r]<=Harr[2*r+1])
	               {
	                   s=2*r;
	               }
	               else
	               {
	                   s=2*r+1;
	               }
	               if(compareHeap(Harr[r],Harr[s]))
	               {
	                   int temp=Harr[r];
	                   Harr[r]=Harr[s];
	                   Harr[s]=temp;
	                   pushDownHeap(Harr,s,len);
	               }
	           }
	       }
	   public static boolean compareMerge(int x,int y)
	       {
	           CompCountMerge=CompCountMerge+1;
	           if(x<=y)
	           {
	              return(true); 
	           }
	           else
	           {
	               return(false);
	           }
	       }
	       
	       public static boolean compareQuick(int x,int y)
	       {
	           CompCountQuick=CompCountQuick+1;
	           if(x<y)
	           {
	              return(true); 
	           }
	           else
	           {
	               return(false);
	           }
	       }
	       public static boolean compareHeap(int x,int y)
	       {
	           CompCountHeap=CompCountHeap+1;
	           if(x>y)
	           {
	              return(true); 
	           }
	           else
	           {
	               return(false);
	           }
	       }
	   
	       }
