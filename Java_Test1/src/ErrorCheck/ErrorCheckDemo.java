package ErrorCheck;
/*
 * 	에러 체크 
 * 	
 * 
 * */

public class ErrorCheckDemo {
	public static void main(String[] args)
	{
		String a="1200";
		String b="20d0";   //숫자 이외 입력시 오류발생
		try {
			Sum num = new Sum(a,b);
		}catch(NumberFormatException e) {
			System.out.println("입력한 값이 숫자가 아님");
		}
	}
	
	
}
class Sum
{
	public Sum(String a, String b) throws NumberFormatException   //문자로 받으면 형변환 과정에서  NumberFormatException 발생
	{
		try {
			int sum = Integer.parseInt(a)+Integer.parseInt(b);
			System.out.printf("두 숫자의 합 : %d",sum);	
		}catch(NumberFormatException e) {
			System.out.println("숫자형이 아닙니다 형변환 불가");
			throw e;			// 위에도 에러 전달해줌
		}
	}
}