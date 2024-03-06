
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		char[] arr2 = Arrays.copyOf(arr, arr.length);
		char[] resultArr = br.readLine().toCharArray();

		if(Arrays.toString(arr).equals(Arrays.toString(resultArr))) {
			System.out.println(0);
			return;
		}
		
		int count = 0;
		// 0번째를 누른 경우
		arr[0] = (char) ((arr[0] == '0') ? '1' : '0');
		arr[1] = (char) ((arr[1] == '0') ? '1' : '0');
		count++;
		for (int i = 1; i < arr.length; i++) {
			// 같지 않으면 눌러서 같게 만들어 줘야 함
			if (arr[i - 1] != resultArr[i - 1]) {
				count++;
				arr[i - 1] = (char) ((arr[i - 1] == '0') ? '1' : '0');
				arr[i] = (char) ((arr[i] == '0') ? '1' : '0');
				if (i == arr.length - 1) {
					if (arr[i] != resultArr[i]) {
						count = -1;
					}
					continue;
				}
				arr[i + 1] = (char) ((arr[i + 1] == '0') ? '1' : '0');
			}else {
				if (i == arr.length - 1) {
					if (arr[i] != resultArr[i]) {
						count = -1;
					}
					continue;
				}
			}
		}
		int count2 = 0;
		for (int i = 1; i < arr2.length; i++) {
			// 같지 않으면 눌러서 같게 만들어 줘야 함
			if (arr2[i - 1] != resultArr[i - 1]) {
				count2++;
				arr2[i - 1] = (char) ((arr2[i - 1] == '0') ? '1' : '0');
				arr2[i] = (char) ((arr2[i] == '0') ? '1' : '0');
				if (i == arr2.length - 1) {
					if(arr2[i] != resultArr[i]) {
						count2 = -1;
					}
					continue;
				}
				arr2[i + 1] = (char) ((arr2[i + 1] == '0') ? '1' : '0');
			}else {
				if (i == arr2.length - 1) {
					if (arr2[i] != resultArr[i]) {
						count2 = -1;
					}
					continue;
				}
			}
		}
		if (count == -1 && count2 == -1) {
			System.out.println(-1);
			return;
		}
		if(count == -1) {
			System.out.println(count2);
			return;
		}
		if(count2 == -1) {
			System.out.println(count);
			return;
		}
		int min = Math.min(count, count2);
		System.out.println(min);

	}
}
