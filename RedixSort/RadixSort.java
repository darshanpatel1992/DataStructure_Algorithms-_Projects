/* Name: Patel Darshan A
 * Njit Id: Dap83@njit.edu
 * Program Name: RadixSort
 * 
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
public class RadixSort {

    public static void main(String args[])throws IOException
    {   //file read and write Operation
        File f;
        FileReader Freader;
        FileWriter Fwriter;
        //Buffer read and write operation
        BufferedReader Breader;
        BufferedWriter Bwriter;
        try 
        {
        	//Create new input and output file
            int i,flag,len=1000;
            String Str=new String();
            String InputFile=new String("f.txt");
            String OutputFile=new String("g.txt");
            char[][] c=new char[len][21];
            Breader=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("***RADIX SORT***");
            
           // press 1 for user define file name and 0 for default 
            System.out.println("\nPRESS 1 TO ENTER THE FILENAME OR PRESS 0 TO GENERATE FILE WITH RANDOM STRINGS HAVING DEAFULT FILENAME(f.txt) :");
            flag=Integer.parseInt(Breader.readLine());
            if(flag==0)
            {
                f=new File(InputFile);
                Fwriter=new FileWriter(f);
                Bwriter=new BufferedWriter(Fwriter);
                if(f.exists())
                {
                    f.delete();
                }
                f.createNewFile();
                for(i=0;i<len;++i)
                {
                    Bwriter.write(randomStringGenerator());
                    if(i!=len-1)
                    {
                        Bwriter.newLine();
                    }
                }
                //buffer and file close
                Bwriter.close();
                Fwriter.close();
                System.out.println("***RANDOM STRING FILE IS GENERATED***");
                System.out.println("\nTHE DEFAULT INPUT FILENAME :"+InputFile);
                System.out.println("\nTHE DEFAULT OUTPUT FILENAME :"+OutputFile);
            }
            else
            {
                System.out.println("\n***ENTER THE INPUT FILENAME ALONG WITH THE FILE EXTENSION(.txt) :");
                InputFile=Breader.readLine();
                System.out.println("\n***ENTER THE OUTPUT FILENAME ALONG WITH THE FILE EXTENSION(.txt) :");
                OutputFile=Breader.readLine();
            }
            
            int k=0;
            f=new File(InputFile);
            Freader=new FileReader(f);
            Breader=new BufferedReader(Freader);
            while((Str=Breader.readLine())!=null)
            {
                Str = String.format("%-21s", Str);
                c[k]=Str.toCharArray();
                k++;
            }
            Breader.close();
            Freader.close();
            System.out.println("*THE FILE ("+InputFile+") HAS BEEN READ!!!");
            c=radixSort(c,len,c[0].length);
            f=new File(OutputFile);
            Fwriter=new FileWriter(f);
            Bwriter=new BufferedWriter(Fwriter);
            if(f.exists())
            {
                f.delete();
            }
            f.createNewFile();
            for(i=0;i<len;++i)
            {
                	Bwriter.write(String.valueOf(c[i]));
                    if(i!=len-1)
                	{
                    		Bwriter.newLine();
                	}
            }
            Bwriter.close();
            Fwriter.close();
            System.out.println("\n*THE TOTAL NUMBER OF STRINGS IN THE INPUT FILE = "+len);
            System.out.println("\n*THE LENGTH OF EACH STRING AFTER APPENDING WHITESPACE CHARACTERS = "+c[0].length);
            System.out.println("\n*THE FILE ("+OutputFile+") HAS BEEN WRITTEN!!!");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR OCCURED, PLEASE ENTER THE CORRECT FILE NAME OR CHECK THE FILE PATH");
        }
    }
    // Random String Generate
    public static String randomStringGenerator()
    {
        char ch[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String s=new String();
        int i,j,l=(int)(Math.random()*21)+1;
        for(i=0;i<l;++i)
        {
            j=(int)(Math.random()*26);
            s=s+ch[j];
        }
        return(s);
    }
    //RadixSort Function
    public static char[][] radixSort(char a[][],int n,int k)
    {
        int i,j,m;
        int pointer[]=IntStream.range(0,n).toArray();
        char ArrayCpy[][]=new char[n][k]; 
        for(i=k-1;i>=0;--i)
        { 
            TreeMap<Character,LinkedList<Integer>> hm=new TreeMap<Character,LinkedList<Integer>>();
            LinkedList<Integer> Llist;
            for(j=0;j<n;++j)
            {
                Llist = new LinkedList<Integer>();
                if(hm.containsKey(a[pointer[j]][i]))
                {
                    Llist=hm.get(a[pointer[j]][i]);
                }
                Llist.addLast(pointer[j]);
                hm.put(a[pointer[j]][i],Llist);
            }
            Llist = new LinkedList<Integer>();
            for(LinkedList<Integer> Llist1:hm.values())
            {
                Llist.addAll(Llist1);
            }
            Iterator<Integer> itr=Llist.iterator();  
            m=0;
            while(itr.hasNext())
            {    
                pointer[m++]=itr.next().intValue();
            }
        }
        for(m=0;m<n;++m)
        {    
            ArrayCpy[m]=a[pointer[m]];
        }
        return(ArrayCpy);
    }
}

