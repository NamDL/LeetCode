
/*Assume you have an array of length n initialized with all 0's and are given k update operations. 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of 
 * subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc. Return the modified 
 * array after all k operations were executed.*/

public class Range_Addition_370 {

	public static void main(String[] args) {
		int n=5;
		int[][] updated= {{1,  3,  2},{2,  4,  3},{0,  2, -2}};
		int[] sol= new int[n+1];
		for(int i=0;i<updated.length;i++){
			sol[updated[i][0]]+=updated[i][2];
			sol[(updated[i][1])+1]-=updated[i][2];
		}
		for(int i=1;i<n;i++){
			sol[i]+=sol[i-1];
		}
		for(int i=0;i<n;i++){
			System.out.println(sol[i]);
		}
	}

}
