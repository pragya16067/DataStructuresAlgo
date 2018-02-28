// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067
//Lab 4(Sunday group)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Node {
	
	public int data;
	public Node link;
	
	public Node() { 		
		// a simple node
		data = 0; 
		link = null;
	}
	
	public Node(int n) {
		// a node with a given value
		data = n; 
		link = null; 
	}

	public Node(int value, Node ptr) {
		//a node with given value and reference
		data=value;
		link=ptr; 
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getLink() {
		return this.link;
	}
	
	public void setLink(Node n) {
		this.link=n;
	}
	
	public void setData(int n) {
		this.data=n;
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int M=Reader.nextInt(); //The no. of values already in the linked list
		int Q=Reader.nextInt(); //The no. of queries
		
		//Storing all values in an array
		/*int[] A=new int[M];
		for(int i=0; i<M; i++)
		{
			int x=Reader.nextInt();
			A[i]=x;
		}*/
		
		//For creating the linked list of all values entered by user
		Node Head=new Node();
		int prev=Reader.nextInt();
		Head=new Node(prev);
		Node x=new Node(prev);
		for(int i=1; i<M; i++)
		{
			Node cur=new Node(Reader.nextInt());
			x.setLink(cur);
			if(i==1)
				Head=x;
			prev=cur.getData();
			x=cur;
		}
		
		
		while (Q-- > 0)
		{
			int choice=Reader.nextInt();
			if(choice==1)
			{
				int v=Reader.nextInt();
				//For inserting a value v at the start of the linked list
				Node nptr = new Node (v, null);
				if (Head == null)//if list is empty
				       Head = nptr;
				else
				       nptr.setLink(Head);
				Head = nptr;
				M=M+1;
			}
			else if(choice==2)
			{
				//For deleting the first node of the linked list
				if(M==0)//if list is empty
					continue;
				Node ptr = Head.getLink();
				Head = ptr;	
				M=M-1;
			}
			else if(choice==3)
			{
				//For displaying the linked list
				Node ptr = Head;
				while (ptr!=null)
				{
					System.out.print(ptr.getData()+ " ");
				    ptr = ptr.getLink();
				}
				System.out.println();
			}
			else
			{
				//To check for sub list
				//Prints 1 if original list is indeed a sublist, else prints 0
				int k=Reader.nextInt(); //no. of elements in the sublist
				
				//Storing all values of superlist in an array
				/*int[] S=new int[k];
				for(int i=0; i<k; i++)
				{
					int y=Reader.nextInt();
					S[i]=y;
				}*/
				
				//For creating the linked list of all values entered by user
				Node Head1=new Node();
				int prev1=Reader.nextInt();
				Node x1=new Node(prev1);
				for(int i=1; i<k; i++)
				{
					Node cur1=new Node(Reader.nextInt());
					x1.setLink(cur1);
					if(i==1)
						Head1=x1;
					prev1=cur1.getData();
					x1=cur1;
				}
				
				//For displaying the linked superlist
				/*Node ptr = Head1;
				while (ptr!=null)
				{
					System.out.print(ptr.getData()+ " ");
				    ptr = ptr.getLink();
				}
				System.out.println();*/
				
				//now to check for sublist
				int y=k;
				int count=0;//maintaining a counter to keep track of all corresponding elements which have matched
				if(k<M)
				{
					System.out.println(0);
				}
				else if(M==0)
				{
					System.out.println(1);
				}
				
				else
				{
					Node p2=Head1;
					while(y-->=M)
					{
						//Head1=Head1.getLink();
						count=0;
						Node p1=Head;
						
						while(p1.getLink()!=null && p2.getLink()!=null)
						{
							if(p1.getData()==p2.getData())
								{
								count++;
								p1=p1.getLink();

								}
							//p1=p1.getLink();
							p2=p2.getLink();
						}
						//System.out.println(count);
						//this if condition is added as the above while does not check the last element
						if(p1.getLink()==null)
						{
							if(p1.getData()==p2.getData())
							count++;
						}
						//if the no. of same corresponding elements is same as M, we can break out of the loop
						if(count==M)
							break;
					}
					
				if(count==M)
					System.out.println(1);
				else
					System.out.println(0);
						
					
					
				}
				
			}
		}
				
	}

}

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
