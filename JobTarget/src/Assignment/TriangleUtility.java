package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public final class TriangleUtility {
	
	private static String fileToCreateTriangle;
	
	private TriangleUtility() {	
		throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
	public static Triangle createTriangle(String triangleFile) {
		fileToCreateTriangle = triangleFile;
		TreeNode root = createTree();
		return new Triangle(root);
	}
	
	private static TreeNode createTree() {
		
		// parentQueue is used to store parent nodes on each iteration
		Queue<TreeNode> parentQueue = new LinkedList<>();
		// childQueue is used to store child nodes for parent nodes in parentQueue
		Queue<TreeNode> childQueue = new LinkedList<>();
		// triangleRoot stores the root node of the Triangle Tree
		TreeNode triangleRoot = null;
		
		File fileHandle = new File(fileToCreateTriangle);
	    
		try {
			
			Scanner readLine = new Scanner(fileHandle);
			
			while (readLine.hasNextLine()) {
				
		        String currentLine = readLine.nextLine();
		        
		        // when file is empty
		        if(currentLine == null) {
		        	break;
		        }
		        
		        // Using regex to remove split around white spaces
		        String[] stringArray = currentLine.split("\\s");
		        
		        
		        
		        if(stringArray.length == 0) {
		        	break;
		        }
		        
		        boolean isRoot = (stringArray.length == 1) && parentQueue.isEmpty();
		        
		        if(isRoot) {
		        	
		        	triangleRoot = new TreeNode(Double.parseDouble(stringArray[0]));
			        parentQueue.add(triangleRoot);
		        
		        } else {
		        	
		        		for(String value : stringArray) {
		        			TreeNode newNode = new TreeNode(Double.parseDouble(value));
		        			childQueue.add(newNode);
		        		}
		        		
				        Queue<TreeNode> backUpChildQueue = new LinkedList<>(childQueue);  
				        buildSubTreeUsingQueue(parentQueue, childQueue);
				        parentQueue = backUpChildQueue;
		        }
			}
			readLine.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
		}
		return triangleRoot;
		
	}
	
	private static void buildSubTreeUsingQueue(Queue<TreeNode> parentQueue, Queue<TreeNode> childQueue) {
		
		TreeNode child2 = null;
        
		while(!parentQueue.isEmpty() && !childQueue.isEmpty()) {
        	
        	TreeNode parentNode = parentQueue.poll();
        	// child2 is shared between sibling parents
        	TreeNode child1 = (child2 == null) ? childQueue.poll() : child2;
        	child2 = childQueue.poll();
        	parentNode.left = child1;
        	parentNode.right = child2;
        	
        }
	}
	

}
