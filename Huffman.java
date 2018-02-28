// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067
// SECTION_GROUP : A-3
// Lab 9(Saturday group)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class PNode {
	
	public int data;
	public int freq;
	public PNode left;
	public PNode right;
	public PNode link;
	
	public PNode(int value,int f, PNode ptr) {
		//a PNode with given value and reference
		data=value;
		freq=f;
		link=ptr; 
		left = null;
    	right = null;
	}
	
	public PNode getLink() {
		return this.link;
	}
	
	public int getFreq() {
		return this.freq;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setLink(PNode n) {
		this.link=n;
	}
	
	public void setData(int n) {
		this.data=n;
	}
}
	

class Pqueue    {
	
    protected PNode front ;
    protected PNode rear;
    public int size ;
    
    public Pqueue() {    
    	rear = null;  
    	front = null;     
    	size = 0;
    	
    }
    
    public boolean isEmpty() {   
    	return rear == null;       	
    }
    
    public int getSize() { 
    	return size;    
    }
    
    public void Penqueue ( PNode nptr )  {
        //PNode nptr = new PNode(val, weight, null);
        if (rear == null) 
        {
              front = nptr;
              rear = nptr;
        }
        	
        else
        {
        	if(rear.getFreq() <= nptr.getFreq())
        	{
        		rear.setLink(nptr);
        		rear = nptr;
        	}
        
        	else
        	{
        		PNode prev=front;
        		PNode cur=prev.getLink();
        		if(cur==null)
        		{
        			nptr.setLink(prev);
        			front=nptr;
        		}
        		else{
        		while(cur!=null)
        		{
        			if(cur.getFreq() < nptr.getFreq())
        				{prev=prev.getLink();
        				cur=cur.getLink();}
        			else
        			{
        				if(prev.getFreq() < nptr.getFreq()) {
        					nptr.setLink(prev.getLink());
        					prev.setLink(nptr);
        					break; 
        				}
        				else
        				{
        					nptr.setLink(prev);
        					front=nptr;
        					break;
        				}
        			}
        		}
        		
        		}
        	}
        } 
        size++;
   }
    
    public PNode Pdequeue ()  {
        PNode d = front;
        front = front.getLink();
        if (front == null)
              rear = null;
        size--;
        return d;
       
   }
    
    public int peek ()  {
        int d = front.getData();
        return d;             
   }

    public void display(){
    	PNode ptr=front;
    	while(ptr!=null)
    	{
    		System.out.println(ptr.getData()+" "+ptr.getFreq());
    		ptr=ptr.getLink();
    	}
    }
    
}



class HuffmanTree {
	
	public double countbits=0;
	PNode root;
	
	public HuffmanTree(PNode n) {
		root=n;
	}
	
	public static void printLeafNodes(PNode t)
	{
	      if(t == null)       
	        return;
	       if(t.left == null && t.right == null)      
	          {System.out.println(t.data + " " + t.freq);} 
	       else {
	    	   	printLeafNodes(t.left);
	       		printLeafNodes(t.right);}     
	}
	
	public int getNodeHeight(PNode root, int x, int height){
		if(root==null) return 0;
		if(root.data==x) return height;
		
		//check if the node is present in the left sub tree
		int level = getNodeHeight(root.left,x,height+1);
		//System.out.println(level);
		if(level!=0) return level;
		
		//check if the node is present in the right sub tree
		return getNodeHeight(root.right,x,height+1);
	
}
	
	public void countBits(PNode root, int count)
	{
		if(root.left==null && root.right==null)
		{
			countbits+=count*root.getFreq();
		}
		else
		{
			count++;
			countBits(root.left,count);
			countBits(root.right,count);
		}
	}
}

public class Huffman {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int cols=Reader.nextInt();
		int rows=Reader.nextInt();
		//the priority queue
		Pqueue q=new Pqueue();
		int[] values=new int[cols*rows];
		int[] copyvalues=new int[cols*rows];
		//store all the values in an array
		
		
		for(int i=0; i<cols*rows; i++)
		{
			
			values[i]=Reader.nextInt();
			copyvalues[i]=values[i];
			
		}
		
		long startTime_x = System.currentTimeMillis();
		
		
		// PART I
		
		//get a priority queue of nos. with their frequencies;
		
		Arrays.sort(values);
		int freq;
		
		for(int i=0; i<cols*rows; i++)
		{
			
			if(values[i]!=-1)
			{ freq=1;
			for(int k=i+1;k<cols*rows;k++)
			{
				if(values[i]==values[k])
				{
					values[k]=-1;
					freq++;
				}	
			}
			
			//System.out.println(values[i]+" "+freq);
			PNode ptr=new PNode( values[i], freq, null);
			q.Penqueue(ptr);
					
			
			}
		//Now all values have been stored in a priority queue with Frequencies as a weight	
		}
		//q.display();
		
		
		
		/*int[] freq1=new int[rows*cols];
		int compareval = values[0];
		int freq=0;
		for(int j=0; j < freq1.length; j++)
		{
			if(values[j]!=compareval)
			{
				compareval=values[j];
				freq++;
				freq1[freq]=1;
			}
			else
			{
				freq1[freq]++;
			}
		}*/
		
		
		
		while(q.getSize() != 1)
		{
			PNode n1=q.Pdequeue();
			PNode n2=q.Pdequeue();
			PNode x=new PNode(-1, (n1.getFreq()+n2.getFreq()), null);
			x.left=n1;
			x.right=n2;
			q.Penqueue(x);
		}
		
		PNode root=q.Pdequeue();
		HuffmanTree h=new HuffmanTree(root);
		
		//If the tree has only 1 node
		if(root.left==null & root.right==null)
		{
			System.out.println(8.0);
		}
		
		
		else
		{
		/*double count=0;
		int noOfBits=0;
		for(int i=0; i<cols*rows; i++)
		{
			noOfBits = h.getNodeHeight(root, copyvalues[i], 1) - 1;
			//System.out.println(copyvalues[i]+ " " +noOfBits);
			count=count + noOfBits;
		}
		//System.out.println(count);
		
		double finaloutput1 = rows*cols*8/count;*/
			
		h.countBits(root,0);
		//System.out.println(h.countbits);
			
		double finaloutput1 = rows*cols*8/h.countbits;
		System.out.printf("%.1f",finaloutput1);
		System.out.println();
		}
		
		// PART II
		
		//Now to calculate the frequencies for the second part
		Pqueue q2=new Pqueue();
		Arrays.sort(copyvalues);
		int[] freq2=new int[26];
		for(int j=0; j < rows*cols; j++)
		{
			int m = copyvalues[j]/10;
			if(m==25)
			{
				freq2[24]++;
			}
			else
			{
				freq2[m]++;
			}
		}
		
		for(int j=0; j < 26; j++)
		{
			if(freq2[j]!=0)
			{
				PNode ptr=new PNode( 10*j, freq2[j], null);
				q2.Penqueue(ptr);
			}
		}
		//q2.display();
		
		while(q2.getSize() > 1)
		{
			PNode n1=q2.Pdequeue();
			PNode n2=q2.Pdequeue();
			PNode x=new PNode(-1, (n1.getFreq()+n2.getFreq()), null);
			x.left=n1;
			x.right=n2;
			q2.Penqueue(x);
		}
		
		PNode root2=q2.Pdequeue();
		HuffmanTree h2=new HuffmanTree(root2);
		
		if(root2.left==null & root2.right==null)
		{
			System.out.println(8.0);
		}
		else
		{
		h2.countBits(root2,0);
		//System.out.println(h2.countbits);
		
		double finaloutput2 = rows*cols*8/h2.countbits;
		System.out.printf("%.1f",finaloutput2);
		//System.out.println();
		

		long endTime_x = System.currentTimeMillis();
		double TimeElapsed_x= (endTime_x-startTime_x)/1000.0; //finds time in seconds
		//System.out.println(TimeElapsed_x);
		}
	}
}



/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static long nextLong() throws IOException {
    	return Long.parseLong( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
