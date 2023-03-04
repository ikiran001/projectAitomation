package Intervw;

public class Bac {

	public static void main(String[] args) {
		System.out.println(ShootRangeByKiran(7));

	}
	public static int ShootRangeByKiran(int N) {
		int [] arr=new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}

		return hepler(N, arr);
	}

	public static int hepler(int N, int[] arr) {
		int sum=0;
		if(N==1) {
			return sum;
		}

		int [] newArray=new int [arr.length/2];
		int j=0;
		for (int i = 0; i < arr.length; i+=2) {
			if(i<arr.length-1) {
				newArray[j]=arr[i+1];
				sum+=arr[i];
				j++;}
			else{sum+=arr[i];}
			N--;
		}

		return sum+hepler(N, newArray);
	}

}
