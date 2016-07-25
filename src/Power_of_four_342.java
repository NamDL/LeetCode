
public class Power_of_four_342 {

	public static void main(String[] args) {
		int num=16;
		int val=num | (num-1);
       System.out.println((num & ~(num))==0);
	}

}
