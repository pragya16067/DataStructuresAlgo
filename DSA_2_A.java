import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class DSA_2_A {
	
	int[] arr;
	int capacity;
	int end_pointer;
	
	public DSA_2_A(int[] a,int max,int end) {
		capacity=max;
		arr=new int[capacity];
		arr=a;
		end_pointer=end-1;
	}
	
	public void insert(int n) {
		int shift=0;
		int size=this.end_pointer+1;
		if(size==capacity)
		{
			System.out.println(size+" "+shift);
		}
		else
		{
			arr[end_pointer+1]=n;
			int j=end_pointer+1;
			while(arr[j]<=arr[j-1])
			{
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
				shift++;
				j--;
			}
			end_pointer++;
			size++;
			System.out.println(size+" "+shift);
			
		}
	}
	
	public void Delete(int n) {
		int size=end_pointer+1;
		int shift=0;
		
		if(this.end_pointer==-1)
		{
			System.out.println(size+" "+shift);
		}
		else
		{
			int index=0;
			for(int j=0; j<=this.end_pointer; j++)
			{
				if(arr[j]==n)
					index=j;
			}
			int i=index;
			while(i <= this.end_pointer)
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				if(arr[i]!=0)
					{shift++;}
				i++;
			}
			arr[arr.length-1]=0;
			end_pointer--;
			size--;
			System.out.println(size+" "+shift);
		}
	}
	
	public void Display() {
		for(int i=0; i<=end_pointer; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int cap=Reader.nextInt();  //max capacity of the array
		int n=Reader.nextInt();  //The no. of values already in the array
		int q=Reader.nextInt(); //the no. of queries
		int[] A=new int[cap];
		for(int i=0; i<n; i++)
		{
			int x=Reader.nextInt();
			A[i]=x;
		}
		DSA_2_A a=new DSA_2_A(A,cap,n);
		while(q-- > 0)
		{
			int choice=Reader.nextInt();
			if(choice==1)
			{
				int v=Reader.nextInt();
				a.insert(v);
			}
			else if(choice==2)
			{
				int v=Reader.nextInt();
				a.Delete(v);
			}
			else
				a.Display();
				
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