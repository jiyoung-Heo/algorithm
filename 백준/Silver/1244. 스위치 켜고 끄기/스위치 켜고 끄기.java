
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] switchArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		switchArr = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int k = 1; k <= n; k++) {
			switchArr[k] = (Integer.parseInt(st.nextToken())) == 1 ? true : false;
		}

		int studentNumber = Integer.parseInt(br.readLine());
		Person[] personArr = new Person[studentNumber];

		for (int i = 0; i < studentNumber; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			personArr[i] = new Person(gender, number);
		}

		for (int i = 0; i < personArr.length; i++) {
			int number = personArr[i].number;
			int gender = personArr[i].gender;
			// 남자일경우
			if (gender == 1) {
				int count = 1;
				int calcNumber = number;
				// 배수가 있을경우 해당 스위치 상태 바꾸기
				while (count <= n / number) {
					count++;
					switchArr[calcNumber] = !switchArr[calcNumber];
					calcNumber = number * count;
				}
			} else if (gender == 2) {
				switchArr[number] = !switchArr[number];
				// 대칭수의 스위치가 다를 경우 전까지 모두 상태 바꾸기
				for (int j = 1; j < number; j++) {
					if (number - j <= 0 || number + j > n) {
						break;
					}
					// 두 상태가 다를경우
					if (switchArr[number + j] != switchArr[number - j]) {
						break;
					}
					switchArr[number + j] = !switchArr[number + j];
					switchArr[number - j] = !switchArr[number - j];
				}
			}
		}

		for (int k = 0; k < switchArr.length / 20 + 1; k++) {
			for (int i = 1; i <= 20; i++) {
				if (k * 20 + i >= n + 1) {
					System.exit(0);
				}
				if (switchArr[k * 20 + i]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

	static class Person {
		int gender;
		int number;

		public Person(int gender, int number) {
			super();
			this.gender = gender;
			this.number = number;
		}
	}
}
