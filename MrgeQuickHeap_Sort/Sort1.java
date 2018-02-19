/* Name: Darshan Patel 
 * Njit id: dap83
 * Program 1 for Small size array*/


import java.io.IOException;
import java.util.Random;


public class Sort1 {
	public static int CompCountMerge=0;
    public static int CompCountQuick=0;
    public static int CompCountHeap=0;


public static void main(String args[])throws IOException
{
int i,len=32;
double Stime,Etime,Ttime;
int[] arrMerge=new int[len];
int[] arrQuick=new int[len];
int[] arrHeap=new int[len+1];
System.out.println("Where N=32");	
System.out.println("Before sorting numer");		
//Below loop is for Avg. Case Analysis
// make sure that comment below loop for finding best case and worst case 
for (i=0;i<len;++i)

{
		Random rand =new Random();
		int J=rand.nextInt(len);
		arrMerge[i]=J;
		arrQuick[i]=J;
		arrHeap[i+1]=J;
		System.out.print(" "+J);		
}
//Uncomment Below Loop For Best Case Analysis
//for (i=0;i<32;++i)
//Uncomment Below Loop For Worst Case Analysis
//for (i=31;i>=0;--i)
//{
//	arrMerge[i]=i;
//	arrQuick[i]=i;
//	arrHeap[i]=i;
//			System.out.print(" " +i);		
//	
//}
System.out.println();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//MERGE SORT

System.out.println("\n***MERGE SORT***");
System.out.println("After sorting numer");
Stime=System.nanoTime();
 Msort(arrMerge,0,len-1);
 Etime=System.nanoTime();
for(int j=0;j<len;++j)

{    System.out.print(" "+arrMerge[j]);

}


Ttime=(Etime-Stime)/1000000.0;
System.out.println();
System.out.println("\n# of Key Comparisons Using Merge Sort = "+CompCountMerge);
System.out.println("Time Taken by Merge Sort = "+Ttime+" Milliseconds");


////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Quick Sort
System.out.println("\n***Quick SORT***");
System.out.println("After sorting numer");
Stime=System.nanoTime();
quickSort(arrQuick,0,len-1);
Etime=System.nanoTime();
for(int j=0;j<len;++j)
{    
	System.out.print(" "+arrQuick[j]);

}
Ttime=(Etime-Stime)/1000000.0;
System.out.println();
System.out.println("\n# of Key Comparisons Using Quick Sort = "+CompCountQuick);
System.out.println("Time Taken by Quick Sort = "+Ttime+" Milliseconds");

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//Heap Sort
System.out.println("\n***Heap SORT***");
System.out.println("After sorting numer");
Stime=System.nanoTime();
arrHeap=heapSort(arrHeap);
Etime=System.nanoTime();
for(int j=1;j<=len;j++)
{    
		System.out.print(" "+arrHeap[j]);
}
Ttime=(Etime-Stime)/1000000.0;
System.out.println();
System.out.println("\n# of Key Comparisons Using Heap Sort = "+CompCountHeap);
System.out.println("Time Taken by Quick Sort = "+Ttime+" Milliseconds");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public static void merge(int Marr[], int l, int m, int r)
    {
       
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = Marr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = Marr[m + 1+ j];
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {

				if(compareMerge(L[i],R[j]))
            {
                Marr[k] = L[i];
                i++;
            }
            else
            {
                Marr[k] = R[j];
                j++;
            }
            k++;
        } 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            Marr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2)
       {
          Marr[k] = R[j];
          j++;
            k++;
        }
    }
    
     public static void Msort(int Marr[], int l, int r)
    {
       if (l < r)
        {
            // Find the middle point
           int m = (l+r)/2;
 
            // Sort first and second halves
            Msort(Marr, l, m);
            Msort(Marr , m+1, r);
 
            // Merge the sorted halves
            merge(Marr, l, m, r);
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
       
