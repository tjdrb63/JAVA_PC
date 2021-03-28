package Generic;
/*
 * 	¹Ì¿Ï¼º
 * 
 * 
 * 
 * */

public class GenericTest <T> implements Comparable<GenericTest>{
	private T value;	
	public void set(T value)
	{
		this.value = value;
	}
	public void print()
	{
		System.out.println(this.value);
	}	
	public T get() {
		return value;
	}
	
	@Override
	public int compareTo(GenericTest o) {
		return 1;
	}
	
	public static void main(String[] args)
	{
		GenericTest A = new GenericTest();
		GenericTest B = new GenericTest();
		
		A.set(100);
		B.set(150);
		
		System.out.println(A.compareTo(B));
		
	}
}
