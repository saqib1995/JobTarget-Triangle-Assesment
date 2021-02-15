# JobTarget-Triangle-Assesment

### Logic for my solution

- *My main idea is to create a modified binary tree for a triangle provided, where the tree can have two parent nodes linked to a same child node. Only the first and the last child node at a particular level have a single parent.*

- *After the tree is created I use a Top Down recursive approach to find Max sum for Root by adding value of Root with the Max of it's Left or Right Child Sum*



### My code has four java files and a triangle.txt file 

***1. Main.java***
<br/>Main class calls the createTriangle function from the TriangleUtility class passing the triangle.txt file.
Prints the Max sum for the Triangle.

***2. TriangleUtility.java***
<br/>This class contains all the utility functions each used for a particular purpose

- createTriangle(triangleFile) --> This function calls the createTree() function and returns a Triangle object with the root provided by createTree()
- createTree() --> Creates a binary tree from the values provided in the fileToCreateTriangle.Returns the root node of the tree after it is created. 
- buildSubTreeUsingQueue(parentQueue, childQueue) --> Links parent nodes in parentQueue with child nodes in childQueue.

***3. Triangle.java***
 <br/>This class has a parameterized constructor that takes a root.
 
 - findMaxSum() --> Begins to find the max sum starting from the root and moving down to the leaves.
 - findMaxSum(currentNode) --> Overloaded findMaxSum() to find max sum when a node is provided.
 
 ***4. TreeNode.java***
 <br/> This class provides a structure for my tree nodes with value provided to constructor and left and right tree nodes initialized null at creation of an object.
