/*Darshan Patel*/	


import java.io.*;
	public class SelectionSort{ 
	    public static int CompareCountQSortSel=0;
	    public static int CompareCountQSel=0;
	    public static int CompareCountLSel=0;
	    public static void main(String args[])throws IOException
	   	    {
	        int len=1000000;
	        //Uncomment value of N for other values 
	        //int len=10000;
	        //int len=100000;
	        int k=len/2;
	        int ArrayCom[]=new int[len];
	        for(int i=0;i<len;++i)
	        {
	            int t=(int)(Math.random()*len);
	            ArrayCom[i]=t;
	        }
	        select(ArrayCom,len,k);
	    }
	    public static void select(int a[],int len,int k)
	    {
	        double StartTime,EndTime,totalTime;
	        int i,kth_smallest;
	        int ArrQuickSort[]=new int[len]; 
	        int ArrQuickSelect[]=new int[len];  
	        int ArrLinearSelect[]=new int[len];  
	        for(i=0;i<len;++i) 
	        {
	            ArrQuickSort[i]=a[i];
	            ArrQuickSelect[i]=a[i];
	            ArrLinearSelect[i]=a[i];
	        }
	        System.out.println(" The Size of Input Data, N = "+ArrQuickSort.length);
	        //QUICK SORT
	        System.out.println("\n***QUICK SORT***\n");
	        StartTime=System.nanoTime();
	        select1(ArrQuickSort,0,len-1);
	        kth_smallest=ArrQuickSort[k];
	        EndTime=System.nanoTime();
	        totalTime=(EndTime-StartTime)/1000000.0;
	        System.out.println("ALGORITHM (QUICK SORT) : N = "+len+"    K = "+k+"    A["+k+"] = "+kth_smallest+"    # Key Comparisons = "+CompareCountQSortSel);
	        System.out.println("TIME TAKEN BY QUICK SORT = "+totalTime+" Milliseconds");
	        
	        //QUICK SELECT
	        System.out.println("\n***QUICK SELECT ***");
	        StartTime=System.nanoTime();
	        kth_smallest=select2(ArrQuickSelect,0,len-1,k);
	        EndTime=System.nanoTime();
	        totalTime=(EndTime-StartTime)/1000000.0;
	        System.out.println("\nALGORITHM (QUICK SELECT) : N = "+len+"    K = "+k+"    A["+k+"] = "+kth_smallest+"    # Key Comparisons = "+CompareCountQSel);
	        System.out.println("TIME TAKEN BY QUICK SELECT = "+totalTime+" Milliseconds");
	        
	        //LINEAR SELECT
	        System.out.println("\n***LINEAR SELECT***");
	        StartTime=System.nanoTime();
	        kth_smallest=select3(ArrLinearSelect,0,len-1,k);
	        EndTime=System.nanoTime();
	        totalTime=(EndTime-StartTime)/1000000.0;
	        System.out.println("\nALGORITHM (LINEAR SELECT) : N = "+len+"    K = "+k+"    A["+k+"] = "+kth_smallest+"    # Key Comparisons = "+CompareCountLSel);
	        System.out.println("TIME TAKEN BY LINEAR SELECT = "+totalTime+" Milliseconds");
	    }
	    
	    public static void select1(int Array1[],int start,int end)
	    {
	        int i,j,temp;
	        if(start>=end)
	        {
	            return;
	        }
	        else
	        {
	            int pp=(int)(Math.random()*(end-start))+start;
	            int pivot=Array1[pp];
	            temp=Array1[start];
	            Array1[start]=Array1[pp];
	            Array1[pp]=temp;
	            i=start+1;
	            j=end;
	            while(i<=j)
	            {
	                if(compareSelect1(Array1[i],pivot))
	                {
	                    i++;
	                }
	                else if(Array1[j]>pivot)
	                {
	                    j--;
	                }
	                else
	                {
	                    temp=Array1[i];
	                    Array1[i]=Array1[j];
	                    Array1[j]=temp;
	                    i++;
	                    j--;
	                }
	            }
	            temp=Array1[j];
	            Array1[j]=Array1[start];
	            Array1[start]=temp;
	            select1(Array1,start,j);
	            select1(Array1,j+1,end);
	        }
	    }
	    public static int select2(int Array2[],int start,int end,int k)
	    {
	        if(Array2.length<25)
	        {
	            int i,j,temp;
	            for(i=1;i<=end;++i)
	            {
	                for(j=i;j>0;--j)
	                {
	                    if(compareSelect2(Array2[j],Array2[j-1]))
	                    {
	                        temp=Array2[j]; 
	                        Array2[j]=Array2[j-1];
	                        Array2[j-1]=temp;
	                    }
	                    else
	                    {
	                        break;
	                    }
	                }
	            }
	            return(Array2[k]);
	        }
	        else
	        {
	            return(quickSelect(Array2,start,end,k));
	        }
	    }
	    public static int quickSelect(int Array2[],int start,int end,int k)
	    {
	        int i,j,temp;
	        int pp=(int)(Math.random()*(end-start))+start;
	        int pivot=Array2[pp];
	        temp=Array2[start];
	        Array2[start]=Array2[pp];
	        Array2[pp]=temp;
	        i=start+1;
	        j=end;
	        while(i<=j)
	        {
	            if(compareSelect2(Array2[i],pivot))
	            {
	                i++;
	            }
	            else if(Array2[j]>pivot)
	            {
	                j--;
	            }
	            else
	            {
	                temp=Array2[i];
	                Array2[i]=Array2[j];
	                Array2[j]=temp;
	                i++;
	                j--;
	            }
	        }
	        temp=Array2[j];
	        Array2[j]=Array2[start];
	        Array2[start]=temp;
	        if(k<j)
	        {
	            return(quickSelect(Array2,start,j,k));
	        }
	        else if(k>j)
	        {
	            return(quickSelect(Array2,j+1,end,k));
	        }
	        else
	        {
	            return(Array2[k]);
	        }
	    }
	    public static int select3(int Array3[],int start,int end,int k)
	    {
	        int i,j,temp;
	        if(Array3.length<25)
	        {
	            for(i=1;i<=end;++i)
	            {
	                for(j=i;j>0;--j)
	                {
	                    if(compareSelect3(Array3[j],Array3[j-1]))
	                    {
	                        temp=Array3[j]; 
	                        Array3[j]=Array3[j-1];
	                        Array3[j-1]=temp;
	                    }
	                    else
	                    {
	                        break;
	                    }
	                }
	            }
	            return(Array3[k]);
	        }
	        else
	        {
	            int pivot=linearSelect(Array3,start,end+1);
	            i=start+1;
	            j=end;
	            while(i<=j)
	            {
	                if(compareSelect3(Array3[i],pivot))
	                {
	                    i++;
	                }
	                else if(Array3[j]>pivot)
	                {
	                    j--;
	                }
	                else
	                {
	                    temp=Array3[i];
	                    Array3[i]=Array3[j];
	                    Array3[j]=temp;
	                    i++;
	                    j--;
	                }
	            }
	            temp=Array3[j];
	            Array3[j]=Array3[start];
	            Array3[start]=temp;
	            if(k<j)
	            {
	                return(LinearSelect1(Array3,start,j,k));
	            }
	            else if(k>j)
	            {
	                return(LinearSelect1(Array3,j+1,end,k));
	            }
	            else
	            {
	                return(Array3[k]);
	            }
	        }
	    }
	    public static int linearSelect(int Array3[],int start,int end)
	    {
	        if(end!=1)
	        {
	            int i,t,mod,f=end/5;
	            if((mod=end%5)!=0)
	            {
	                f=f+1;
	            }
	            for(i=0;i<f;++i)
	            {
	                if(i==f-1 && mod!=0)
	                {
	                    BubbleSort(Array3,i*5,i*5+mod);
	                    t=Array3[i];
	                    Array3[i]=Array3[((5*i)+(i*5+mod))/2];
	                    Array3[((5*i)+(i*5+mod))/2]=t;
	                }
	                else
	                {
	                    BubbleSort(Array3,i*5,i*5+5);
	                    t=Array3[i];
	                    Array3[i]=Array3[((5*i)+(i*5+5))/2];
	                    Array3[((5*i)+(i*5+5))/2]=t;
	                }
	            }
	            return(linearSelect(Array3,start,f));
	        }
	        else
	        {
	            return(Array3[start]);
	        }
	    }
	    public static void BubbleSort(int a[],int start,int end)
	    {
	        int i,j,t,len=end;
	        for(i=start;i<len;++i)
	        {
	            for(j=start;j<(len-i-1)+i;++j)
	            {
	                if(compareSelect3(a[j+1],a[j]))
	                {
	                    t=a[j]; 
	                    a[j]=a[j+1];
	                    a[j+1]=t;
	                }
	            }
	        }
	    }
	    public static int LinearSelect1(int Array2[],int start,int end,int k)
	    {
	        int i,j,temp;
	        int pp=(int)(Math.random()*(end-start))+start;
	        int pivot=Array2[pp];
	        temp=Array2[start];
	        Array2[start]=Array2[pp];
	        Array2[pp]=temp;
	        i=start+1;
	        j=end;
	        while(i<=j)
	        {
	            if(compareSelect3(Array2[i],pivot))
	            {
	                i++;
	            }
	            else if(Array2[j]>pivot)
	            {
	                j--;
	            }
	            else
	            {
	                temp=Array2[i];
	                Array2[i]=Array2[j];
	                Array2[j]=temp;
	                i++;
	                j--;
	            }
	        }
	        temp=Array2[j];
	        Array2[j]=Array2[start];
	        Array2[start]=temp;
	        if(k<j)
	        {
	            return(LinearSelect1(Array2,start,j,k));
	        }
	        else if(k>j)
	        {
	            return(LinearSelect1(Array2,j+1,end,k));
	        }
	        else
	        {
	            return(Array2[k]);
	        }
	    }
	    public static boolean compareSelect1(int x,int y)
	    {
	        CompareCountQSortSel=CompareCountQSortSel+1;
	        if(x<y)
	        {
	           return(true); 
	        }
	        else
	        {
	            return(false);
	        }
	    }
	    public static boolean compareSelect2(int x,int y)
	    {
	        CompareCountQSel=CompareCountQSel+1;
	        if(x<y)
	        {
	           return(true); 
	        }
	        else
	        {
	            return(false);
	        }
	    }
	    public static boolean compareSelect3(int x,int y)
	    {
	        CompareCountLSel=CompareCountLSel+1;
	        if(x<y)
	        {
	           return(true); 
	        }
	        else
	        {
	            return(false);
	        }
	    }
	}


