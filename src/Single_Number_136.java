
/*Given an array of integers, every element appears twice except for one. Find that single one.*/

public class Single_Number_136 {

	public static void main(String[] args) {
		int[] arr={5,5,2,2,3,6,6,8,3};
		int x=0;
		for (int i : arr) {
			x=x^i;
		}
		System.out.println(x);
	}

}
