import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class DSA17_1 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T=Reader.nextInt();
		while(T-- > 0)
		{
			String s1=Reader.reader.readLine();
			String s2=Reader.reader.readLine();
			char[] ch1=s1.toCharArray();
			Arrays.sort(ch1);
			char[] ch2=s2.toCharArray();
			Arrays.sort(ch2);
			int l=ch1.length;
			
			int i=0;
			while(i < l)
			{
				int ctr1=0;
				int ctr2=0;
				for(int j=0; j < l ; j++)
				{
					if(ch1[j]==ch1[i])
						ctr1++;
					if(ch2[j]==ch1[i])
						ctr2++;
				}
				int min=0;
				if(ctr1<ctr2)
					min=ctr1;
				else
					min=ctr2;
				for(int c=0; c < min ; c++)
					System.out.println(ch1[i]);
				i=i+ctr1;
			}
			
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

