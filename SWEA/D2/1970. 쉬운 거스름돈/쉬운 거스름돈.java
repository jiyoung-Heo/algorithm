
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[8];
			if (n >= 50000) {
				arr[0] = n / 50000;
				n = n % 50000;
			}
			if (n >= 10000) {
				arr[1] = n / 10000;
				n = n % 10000;
			}
			if (n >= 5000) {
				arr[2] = n / 5000;
				n = n % 5000;
			}
			if (n >= 1000) {
				arr[3] = n / 1000;
				n = n % 1000;
			}
			if (n >= 500) {
				arr[4] = n / 500;
				n = n % 500;
			}
			if (n >= 100) {
				arr[5] = n / 100;
				n = n % 100;
			}
			if (n >= 50) {
				arr[6] = n / 50;
				n = n % 50;
			}
			if (n >= 10) {
				arr[7] = n / 10;
				n = n % 10;
			}
			System.out.println("#" + i + " " );
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}

}