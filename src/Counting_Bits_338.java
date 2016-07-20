
/*Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate 
 * the number of 1's in their binary representation and return them as an array.*/


public class Counting_Bits_338 {

	public static void main(String[] args) {
		int num=5;
		int[] sol= new int[num+1];
        sol[0]=0;
        for(int i=1;i<=num;i++){
            if((i & (i-1))==0) sol[i]=1;
            else if(i%2==0) sol[i]=sol[i-1];
            else sol[i]=sol[i-1]+1;
        }
        for(int i=0;i<sol.length;i++)
        	System.out.print(sol[i]);
	}

}
