import java.util.ArrayList;
import java.util.List;

/*366. Given a binary tree, find all leaves and then remove those leaves. 
 * Then repeat the previous steps until the tree is empty. Print the removed leaves as Lists for each level. */
/*https://discuss.leetcode.com/topic/49194/10-lines-simple-java-solution-using-recursion-with-explanation*/



public class Find_Leaves_Binary_Tree_366 {
	public class Node{
		int data;
		Node left;
		Node ryt;		
		Node(int data){
			Node left=null;
			Node ryt=null;
			this.data=data;
		}		
	}
	private List<List<Integer>> sol = new ArrayList<>();
	public List<List<Integer>> findLeaves(Node root) {
		helper(root);
	    return sol;
	}
	private int helper(Node node){
		if(null==node)  return -1;
		int height= 1 + Math.max(helper(node.left), helper(node.ryt));
		if(sol.size()<height+1)  sol.add(new ArrayList<Integer>());
		sol.get(height).add(node.data);
		// if need to actually remove the leaves, uncomment next line
		// node.left = node.right = null;
		return height;
	}
	
}

