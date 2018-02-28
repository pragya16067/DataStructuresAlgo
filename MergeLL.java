// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067
//Lab 5(Saturday group)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	
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
}


public class MergeLL {
	Node Head1=new Node();
	Node Head2=new Node();
	Node Head3=new Node();
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		MergeLL obj=new MergeLL();
		int size1=Reader.nextInt(); //The no. of values already in the linked list A
		int size2=Reader.nextInt(); //The no. of values already in the linked list B
		int count=0; //To count the no. of comparisons
		
		//For creating the linked list A of all values entered by user
		for(int l =0;l<size1;l++)
		{
			int val = Reader.nextInt();
			obj.Insert(val,obj.Head1);
		}
		
		//For creating the linked list B of all values entered by user
		for(int l =0;l<size2;l++)
		{
			int val1 = Reader.nextInt();
			obj.Insert(val1,obj.Head2);
		}
		
		Node ptr1=obj.Head1.getLink();
		Node ptr2=obj.Head2.getLink();
		
		while(ptr1!=null || ptr2!=null)
		{
		if(ptr1!=null && ptr2!=null)
		{
			if(ptr1.getData()<ptr2.getData())
			{
				obj.Insert(ptr1.getData(), obj.Head3);
				ptr1=ptr1.getLink();
				count++;
			}
			
			else 
			{
				obj.Insert(ptr2.getData(), obj.Head3);
				ptr2=ptr2.getLink();
				count++;
			}
				
		}
		
		
		if(ptr2 == null)
		{
			obj.Insert(ptr1.getData(), obj.Head3);
			ptr1=ptr1.getLink();
		}
		
		else if(ptr1==null)
		{
			obj.Insert(ptr2.getData(), obj.Head3);
			ptr2=ptr2.getLink();
		
		}
		
		}
		obj.Display(obj.Head3);
		System.out.println(count);
		
		

	}
	
	//Method to insert an element at the end of a list
	public void Insert(int v,Node head) {
		Node ptr=new Node(v);
		Node p=head;
		if(head==null)
		{
			head=ptr;
		}
		else
		{
			while(p.getLink()!=null)
			{
				p=p.getLink();
			}
			p.setLink(ptr);
		}
	}
	
	//Method to display Linked list
	public void Display(Node head) {
		//For displaying the linked list
		Node ptr = head.getLink();
		while (ptr!=null)
		{
			System.out.print(ptr.getData()+ " ");
		    ptr = ptr.getLink();
		}
		System.out.println();
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

