
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class TSPNearestNeighbor {
	protected static int numPoints;
	protected static ArrayList<Point> pointList = new ArrayList<>();
	protected static ArrayList<Boolean> pointsVisited = new ArrayList<>();
	
	
	public static int indexOfSmallest(double[] array, int currNode){
	    int index = 0;
	    double min = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < array.length; i++){
	        if ((array[i] < min) & (array[i] != 0.0) & pointsVisited.get(i) == false){
	        	min = array[i];
	        	index = i;
	        }
	    }
	    return index;
	}
	
	
	
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        numPoints = sc.nextInt();
        for(int i = 0; i<numPoints;i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        Point temp = new Point(x,y);
        pointList.add(temp);
        pointsVisited.add(false);
        }
        
        double[][] adjacencyMatrix = new double[pointList.size()][pointList.size()];
        
        for(int i =0; i<pointList.size();i++) {
        	for(int j=0;j<pointList.size();j++) {
        		adjacencyMatrix[i][j] = Math.sqrt(Math.pow(pointList.get(i).x-pointList.get(j).x,2)  +  Math.pow(pointList.get(i).y-pointList.get(j).y,2));
        		
        	}
        }
        
        /**
        System.out.println(numPoints);
        for(int i =0;i<pointList.size();i++) {
        	System.out.print(pointList.get(i).x + " ");
        	System.out.println(pointList.get(i).y);
        }
        
        for(int i =0; i<pointList.size();i++) {
        	System.out.println("");
        	for(int j=0;j<pointList.size();j++) {
        		System.out.print(adjacencyMatrix[i][j] + " "); 
        	}
        }
        */
        
        double distance = 0.0;
        
        int currNode = 0;
        int nextNode;
        pointsVisited.set(currNode, true);
        
       // System.out.println("\n");
        
        while (pointsVisited.contains(false)) {
        	nextNode = indexOfSmallest(adjacencyMatrix[currNode],currNode);
        	// System.out.println(nextNode);
        	pointsVisited.set(nextNode,true);
        	distance += adjacencyMatrix[currNode][nextNode];
        	currNode = nextNode;
        }
        
        distance += adjacencyMatrix[currNode][0];
        
        
        
        System.out.printf("%.3f %n", distance);
        
	}
	
	
}
