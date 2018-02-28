import java.io.*;

public class Lab3 {
	
	static long m=2014;

	public static long Rfib(long n,long m) {
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
		{
			return (Rfib(n-1,m) + Rfib(n-2,m)) % m;
		}
	}
	
	public static long Ifib(long n,long m) {
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
		{
			long a=1;
			long b=1;
			for(long i=2; i<=n; i++)
			{
				long temp=b;
				b=(b+a);
				a=temp;
			}
			return b%m;
		}
		
	}
	
	public static long[][] mult(long[][] a,long[][] b) {
		long[][] matrix=new long[2][2];
		matrix[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0];
		matrix[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1];
		matrix[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0];
		matrix[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1];
		return matrix;
	}
	
	public static long[][] Mpow(long[][] a, long p) {
		long[][] pow=new long[2][2];
		if(p==-1)
		{
			pow[0][0]=0;
			pow[1][0]=0;
			pow[0][1]=0;
			pow[1][1]=0;
			return pow;
		}
		else if(p==0)
		{
			pow[0][0]=1;
			pow[1][0]=0;
			pow[0][1]=0;
			pow[1][1]=1;
			return pow;
		}
		
		else
		{
			if(p%2==0)
			{
				long[][] temp=Mpow(a,p/2);
				return (mult(temp,temp));
			}
			else
			{
				long[][] temp=Mpow(a,p/2);
				long[][] temp2=mult(temp,temp);
				return (mult(temp2,a));
			}
				
		}
	}
	
	public static long Cleverfib(long n) {
		long[][] A={{1,1},{1,0}};
		long[][] B=Mpow(A,n-1);
		long C=B[0][0];
		return C;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(s.readLine());
		
		//To measure the time taken by clever-algo
		long startTime_x = System.currentTimeMillis();
		long x=Cleverfib(n) % 2014;
		System.out.println(x);
		long endTime_x = System.currentTimeMillis();
		double TimeElapsed_x= (endTime_x-startTime_x)/1000.0; //finds time in seconds
		System.out.println(TimeElapsed_x);
		
		//To measure the time taken by Recursive algorithm
		long startTime_y = System.currentTimeMillis();
		long y=Rfib(n,2014);
		System.out.println(y);
		long endTime_y = System.currentTimeMillis();
		double TimeElapsed_y= (endTime_y-startTime_y)/1000.0; //finds time in seconds
		System.out.println(TimeElapsed_y);
		
		//To measure the time taken by Iterative algorithm
		long startTime_z = System.currentTimeMillis();
		long z=Ifib(n,2014);
		System.out.println(z);
		long endTime_z = System.currentTimeMillis();
		double TimeElapsed_z= (endTime_z-startTime_z)/1000.0; //finds time in seconds
		System.out.println(TimeElapsed_z);
				

	}

}
