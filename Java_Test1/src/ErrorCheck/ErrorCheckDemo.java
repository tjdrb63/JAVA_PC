package ErrorCheck;
/*
 * 	���� üũ 
 * 	
 * 
 * */

public class ErrorCheckDemo {
	public static void main(String[] args)
	{
		String a="1200";
		String b="20d0";   //���� �̿� �Է½� �����߻�
		try {
			Sum num = new Sum(a,b);
		}catch(NumberFormatException e) {
			System.out.println("�Է��� ���� ���ڰ� �ƴ�");
		}
	}
	
	
}
class Sum
{
	public Sum(String a, String b) throws NumberFormatException   //���ڷ� ������ ����ȯ ��������  NumberFormatException �߻�
	{
		try {
			int sum = Integer.parseInt(a)+Integer.parseInt(b);
			System.out.printf("�� ������ �� : %d",sum);	
		}catch(NumberFormatException e) {
			System.out.println("�������� �ƴմϴ� ����ȯ �Ұ�");
			throw e;			// ������ ���� ��������
		}
	}
}