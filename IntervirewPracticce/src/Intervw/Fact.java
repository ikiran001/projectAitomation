package Intervw;

public class Fact {

	public static void main(String[] args) {
		System.out.println(fact(6));
		System.out.println(fact2(6));

	}

	public static int fact(int n) {
		if(n<=1) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static int fact2(int n) {
		int fact=1;
		for (int i =1 ; i <=n; i++) {
			fact*=i;
		}
		return fact;
	}



}
