import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DSA17_2 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			String s1=Reader.next();
			String s2=Reader.next();
			char[] ch1=s1.toCharArray();
			Arrays.sort(ch1);
			char[] ch2=s2.toCharArray();
			Arrays.sort(ch2);
			int l=ch1.length;
			int flag=0;
			
			if(ch1.length!=ch2.length)
			{
				//System.out.println("Yes");
				flag=1;
			}
			else
			{
				if(Arrays.equals(ch1,ch2))
					//System.out.println("No");
					flag=0;
				else
				{
					//System.out.println("Yes");
					flag=1;
				}
			}
			if(flag==0)
				System.out.println("No");
			else
				System.out.println("Yes");
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



