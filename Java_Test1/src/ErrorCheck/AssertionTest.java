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
		assert nums != null : "array is null";    // nums °¡ ºñ¾îÀÖ´Ù¸é ­ˆ·Â
		assert nums.length>0 : "No element in Array"; // nums.length°¡ 0ÀÌÇÏ¶ó¸é Ãâ·Â
		assert nums[0] > 1 : "The First element must be larger than 1"; // nums[0]Àº 1º¸´ÙÄ¿¾ßÇÑ´Ù		
		int total =0;
		for(int i =0 ;i < nums.length ; i++)
		{
			total += nums[i];
		}
		return total;
	}
	
}
