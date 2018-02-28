// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067
//Lab 6(Saturday group)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack {
	// Stack implementation using array
	
	public char[] stack;
	int end_pointer;
	public int max;
	
	public Stack(int Max) {
		// Constructor with a parameter for MaxSize
		stack=new char[Max];
		end_pointer=-1;
		max=Max;
	}
	
	//pushes a on stack
	public void push(char a)
	{
		if (end_pointer == max - 1) {
            return;
        } 
		else {
            stack[++end_pointer] = a;
            return;
        }
	}
	
	//pop from stack and return's the value, returns e if underflow
	public char pop()
	{
		if (end_pointer < 0) {
            //Stack Underflow
            return 'e';
        } else {
        	char pop_item=stack[end_pointer--];
            return pop_item;
        }
	}
	
	//Returns the top element. returns e if empty
	public char peek()
	{
		if (end_pointer < 0) {
            //Stack Underflow
            return 'e';
		}
        else {
		char t=stack[end_pointer];
		return t; }
		
	}
	
	//Returns size of current stack
	public int size()
	{
		return stack.length;
	}
	
	//Returns true if stack is empty
	public boolean isempty()
	{
		if(end_pointer < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
 }
 
public class Lab6 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n=Reader.nextInt();
		Stack s=new Stack(n);
		for(int i=0; i<n; i++)
		{
			char ch=(Reader.next()).charAt(0);
			if(Character.isDigit(ch)) //checks if character is a digit
			{
				System.out.print(ch+" ");
			}
			else
			{
				if(ch=='(')  //open bracket in an expression has highest precedence and is simply pushed onto the stack
					s.push(ch);
				else if(ch==')' && (!s.isempty()))
				{   //if you find a closing bracket pop till you see an opening bracket
					while(s.peek()!='(')
					{
						System.out.print(s.pop()+" ");
					}
					
					char waste=s.pop();
				}
				else
				{
					if(ch=='+' || ch=='-')
					{	//if you find a + or -, check to see if no higher precedence char is before it in stack
						
						if(s.peek()!='*' && s.peek()!='/')
						{
							s.push(ch);
						}
						else
						{   // if it is, pop till there are no chars with higher precedence before it
							while(!(s.isempty()) && s.peek()=='*' || s.peek()=='/')
							{
								System.out.print(s.pop()+" ");
							}
							s.push(ch);
						}
					}
					else   //all other characters must be pushed onto the stack
						s.push(ch);
				}
			}
				
		}
		// till the stack is empty, pop everything
		while(!(s.isempty()))
		{
			System.out.print(s.pop()+" ");
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
