package Assignment;
import java.util.HashMap;

public class Triangle {
	
	HashMap<TreeNode, Double> memoizationHash;
	TreeNode root;
	
	// default constructor
	public Triangle() {}
	
	public Triangle(TreeNode root) {
		memoizationHash = new HashMap<>();
		this.root = root;
		
	}
	
	public double findMaxSum() {
		return findMaxSum(root);
		
	}
	
	private double findMaxSum(TreeNode currentNode) {
		
		if(currentNode==null) {
			return 0.0;
		}
		
		if(currentNode.left == null && currentNode.right == null) {
			return currentNode.value;
		}
		
		if(!memoizationHash.containsKey(currentNode)) {
			double maxSum = Math.max(findMaxSum(currentNode.left) , findMaxSum(currentNode.right));
			memoizationHash.put(currentNode, currentNode.value + maxSum);
		}
		
		return memoizationHash.get(currentNode);
		
	}
}
