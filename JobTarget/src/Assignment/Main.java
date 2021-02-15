package Assignment;

public class Main {

	public static void main(String[] args) {
		
		String triangleFile = "src/triangle.txt";
		Triangle triangle = TriangleUtility.createTriangle(triangleFile);
		System.out.println("The Max Sum for the Triangle is: " + triangle.findMaxSum());
		
	}
	
	
}
