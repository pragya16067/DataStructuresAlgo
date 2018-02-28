// NAME : PRAGYA PRAKASH
// ROLL NO. : 2016067
// SECTION_GROUP : A-3
// Lab 8(Saturday group)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public int data;
	
	public TreeNode(TreeNode leftnode, TreeNode rightnode, int x) {
		this.left = leftnode;
		this.right = rightnode;
		this.data = x;
	}
	
	public TreeNode(int x) {
		this.left = null;
		this.right = null;
		this.data = x;
	}
	
	
}

public class Lab8 {

	 
	public static TreeNode ConstructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
	    if(preStart>preEnd||inStart>inEnd){
	        return null;
	    }
	 
	    int val_root = preorder[preStart];
	    TreeNode parent = new TreeNode(val_root);
	 
	    //find parent element index from inorder
	    int k=0;
	    for(int i=0; i<inorder.length; i++){
	        if(val_root == inorder[i]){
	            k=i;
	            break;
	        }
	    }
	 
	    parent.left = ConstructTree(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
	    parent.right= ConstructTree(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
	 
	    return parent;
	}
	
	public static void DisplayPostorder(TreeNode root) {
		if(root==null)
			return;
		else
		{
			DisplayPostorder(root.left);
			DisplayPostorder(root.right);
			System.out.print(root.data+" ");	
		}
	}
	
	public static boolean isBST(int[] inorder) {
		for(int i=0;i<inorder.length-1;i++)
		{
			if(inorder[i+1] < inorder[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int N=Reader.nextInt();
		int[] preorder=new int[N];
		int[] inorder=new int[N];
		
		for(int i=0;i<N;i++)
		{
			preorder[i]=Reader.nextInt();
		}
		
		for(int i=0;i<N;i++)
		{
			inorder[i]=Reader.nextInt();
		}
		
		
		long Start_time=System.currentTimeMillis();
		
		int preStart = 0;
	    int preEnd = N-1;
	    int inStart = 0;
	    int inEnd = N-1;
	 
	    TreeNode root=ConstructTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
		
		DisplayPostorder(root);
		System.out.println();
		
		if(isBST(inorder))
			{System.out.println("YES");}
		else
			{System.out.println("NO");}
		
		long End_time=System.currentTimeMillis();
		double time=(End_time-Start_time)/1000.0;
		//System.out.println(""+time);
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

