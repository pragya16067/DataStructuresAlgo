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


class LinkedList {
	public Node Head;
	public int size;

	public LinkedList(Node head,int m) {
		Head=head;
		size=m;
	}
	
	public void InsertatBeginPos(int v) {
		//For inserting a value v at the start of the linked list
		Node nptr = new Node (v, null);
		if (Head == null)//if list is empty
		       Head = nptr;
		else
		       nptr.setLink(Head);
		Head = nptr;
		size=size+1;
	}
	
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
	
	public void DeleteatBeginPos() {
		//For deleting the first node of the linked list
		if(size==0)//if list is empty
			return;
		Node ptr = Head.getLink();
		Head = ptr;	
		size=size-1;
	}
	
	public void Display() {
		//For displaying the linked list
		Node ptr = Head;
		while (ptr!=null)
		{
			System.out.print(ptr.getData()+ " ");
		    ptr = ptr.getLink();
		}
		System.out.println();
	}
}


public class Lab5 {


	public static void main(String[] args) throws IOException{
		
		Reader.init(System.in);
		int size1=Reader.nextInt(); //The no. of values already in the linked list A
		int size2=Reader.nextInt(); //The no. of values already in the linked list B
		int count=0; //To count the no. of comparisons
		
		//For creating the linked list A of all values entered by user
		Node Head1=new Node();
		LinkedList A=new LinkedList(Head1,size1);
		
		for(int i=1; i<=size1; i++)
		{
			int v=(Reader.nextInt());
			A.Insert(v, Head1);
			
		}
		
		A.Display();
		
		//For creating the linked list B of all values entered by user
		Node Head2=new Node();
		int prev2=Reader.nextInt();
		Node x2=new Node(prev2);
		for(int i=1; i<=size2; i++)
		{
			Node cur=new Node(Reader.nextInt());
			x2.setLink(cur);
			if(i==1)
				Head2=x2;
			x2=cur;
		}
		LinkedList B=new LinkedList(Head2,size2);
		//B.Display();
		
		
		Node Head3=new Node();
		LinkedList C=new LinkedList(Head3,size1+size2+1);
		
		Node p=Head3;
		Node ptr1=Head1;
		Node ptr2=Head2;
		
		while(ptr1!=null || ptr2!=null)
		{
			if(ptr1!=null && ptr2!=null)
			{
			if(ptr1.getData()<ptr2.getData())
			{
				Node y=new Node(ptr1.getData());
				p.setLink(y);
				ptr1=ptr1.getLink();
				p=p.getLink();
				count++;
			}
			
			else if(ptr1.getData()>ptr2.getData())
			{
				Node y=new Node(ptr2.getData());
				p.setLink(y);
				ptr2=ptr2.getLink();
				p=p.getLink();
				count++;
			}
			/*else
			{
				Node y=new Node(ptr2.getData());
				p.setLink(y);
				ptr2=ptr2.getLink();
				ptr1=ptr1.getLink();
				p=p.getLink();
				count++; //is equals a comparison???
			}*/
				
		}
		
		
		if(ptr2 == null)
		{
			Node y=new Node(ptr1.getData());
			p.setLink(y);
			ptr1=ptr1.getLink();
			p=p.getLink();
		}
		
		else if(ptr1==null)
		{
			Node y=new Node(ptr2.getData());
			p.setLink(y);
			ptr2=ptr2.getLink();
			p=p.getLink();
		}
		
		}
		

		//Delete the 0 node at head
		C.DeleteatBeginPos();
		
		C.Display();
		System.out.println(count);

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

