package Intervw;

public class FibonaciSeriews {

	public static void main(String[] args) {
		int n=6;
		for (int i = 1; i <=6; i++) {
			System.out.println(fibo(i));
		}


	}
	
	public static int fibo(int n) {
		
		if(n<=1 ) {
			return 1;
		}
		return fibo(n-1)+fibo(n-2);
	}

	

}
 