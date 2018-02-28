import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedList {
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

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int M=Reader.nextInt(); //The no. of values already in the linked list
		
		//For creating the linked list of all values entered by user
		Node Head=new Node();
		/*int prev=Reader.nextInt();
		Node x=new Node(prev);
		for(int i=1; i<M; i++)
		{
			Node cur=new Node(Reader.nextInt());
			x.setLink(cur);
			if(i==1)
				Head=x;
			x=cur;
		}*/
		LinkedList l=new LinkedList(Head,M);
		for(int i=1; i<M; i++) {
			l.InsertatBeginPos(Reader.nextInt());
		}
		l.Display();

	}

}
