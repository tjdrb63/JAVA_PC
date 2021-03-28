package ErrorCheck;

import java.io.IOException;
/*	
 * 		java -source 1.5
 * 		java -ea/da
 * 
 * */

public class AssertionTest {

	public static void main(String[] args) {
		int nums[] = {0,3,4,6};
		System.out.println(sumArray(nums));
	}
	public static int sumArray(int[] nums)
	{
		assert nums != null : "array is null";    // nums 가 비어있다면 춫력
		assert nums.length>0 : "No element in Array"; // nums.length가 0이하라면 출력
		assert nums[0] > 1 : "The First element must be larger than 1"; // nums[0]은 1보다커야한다		
		int total =0;
		for(int i =0 ;i < nums.length ; i++)
		{
			total += nums[i];
		}
		return total;
	}
	
}
