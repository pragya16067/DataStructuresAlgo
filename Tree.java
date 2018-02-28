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

public class Tree {
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    int preStart = 0;
	    int preEnd = preorder.length-1;
	    int inStart = 0;
	    int inEnd = inorder.length-1;
	 
	    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}
	 
	public static TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
	    if(preStart>preEnd||inStart>inEnd){
	        return null;
	    }
	 
	    int val = preorder[preStart];
	    TreeNode p = new TreeNode(val);
	 
	    //find parent element index from inorder
	    int k=0;
	    for(int i=0; i<inorder.length; i++){
	        if(val == inorder[i]){
	            k=i;
	            break;
	        }
	    }
	 
	    p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
	    p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
	 
	    return p;
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
	
	public static boolean BST(int[] inorder) {
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
		TreeNode root=buildTree(preorder,inorder);
		DisplayPostorder(root);
		System.out.println();
		if(BST(inorder))
			{System.out.println("YES");}
		else
			{System.out.println("NO");}
	}

}


class Reader1 {
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
