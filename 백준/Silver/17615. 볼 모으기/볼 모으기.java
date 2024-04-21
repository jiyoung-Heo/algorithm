import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		char[] arr2 = Arrays.copyOf(arr, arr.length);
		char[] arr3 = Arrays.copyOf(arr, arr.length);
		char[] arr4 = Arrays.copyOf(arr, arr.length);

		int redCount = 0;
		int blueCount = 0;
		// 빨간색 공 개수와 index 체크
		// 파란색 공 개수와 index 체크
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'R') {
				redCount++;
			} else {
				blueCount++;
			}
		}
		// 하나의 색만 있다면 0 리턴
		if (redCount == arr.length || blueCount == arr.length) {
			System.out.println(0);
			return;
		}
		int rightCount = 0;
		int currAmount = 0;
		// 빨간색 오른쪽 끝으로 이동시킨 경우
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i == arr.length - 1) {
				if (arr[i] == 'R') {
					currAmount++;
					continue;
				}
			}
			if (redCount < currAmount) {
				break;
			}
			if (arr[i] == 'R') {
				if (i == arr.length - 1 - currAmount) {
					currAmount++;
					continue;
				}
				rightCount++;
				arr[i] = 'B';
				arr[arr.length - 1 - currAmount] = 'R';
				currAmount++;
			}
		}

		int leftCount = 0;
		currAmount = 0;
		// 빨간색 왼쪽 끝으로 이동시킨 경우
		for (int i = 0; i < arr2.length; i++) {
			if (i == 0) {
				if (arr2[i] == 'R') {
					currAmount++;
					continue;
				}
			}
			if (redCount < currAmount) {
				break;
			}
			if (arr2[i] == 'R') {
				if (i == currAmount) {
					currAmount++;
					continue;
				}
				leftCount++;
				arr2[i] = 'B';
				arr2[currAmount] = 'R';
				currAmount++;
			}
		}

		int blueRightCount = 0;
		currAmount = 0;
		// 빨간색 오른쪽 끝으로 이동시킨 경우
		for (int i = arr3.length - 1; i >= 0; i--) {
			if (redCount < currAmount) {
				break;
			}
			if (arr3[i] == 'B') {
				if (i == arr3.length - 1 - currAmount) {
					currAmount++;
					continue;
				}
				blueRightCount++;
				arr3[i] = 'R';
				arr3[arr.length - 1 - currAmount] = 'B';
				currAmount++;
			}
		}

		int blueLeftCount = 0;
		currAmount = 0;
		// 빨간색 왼쪽 끝으로 이동시킨 경우
		for (int i = 0; i < arr4.length; i++) {
			if (i == 0) {
				if (arr4[i] == 'B') {
					currAmount++;
					continue;
				}
			}
			if (redCount < currAmount) {
				break;
			}
			if (arr4[i] == 'B') {
				if (i == currAmount) {
					currAmount++;
					continue;
				}
				blueLeftCount++;
				arr4[i] = 'R';
				arr4[currAmount] = 'B';
				currAmount++;
			}
		}

		System.out.println(Math.min(Math.min(blueLeftCount, leftCount), Math.min(blueRightCount, rightCount)));
	}
}
