import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] countArr = new int[n];

		int resultThrowCount = 0;
		// 먼저 1번사람이 공을 받음
		countArr[0]++;
		// 1번이 공을 받은 횟수는 홀수번
		int currMove = l;
		while (l > n) {
			currMove = l - n;
		}
		resultThrowCount++;
		countArr[currMove]++;

		// 처음 던진 공을 받았고, m이 1이라면 종료
		if (countArr[l] == m) {
			System.out.println(0);
			return;
		}

		int nextMove = 0;
		while (true) {
			// m이 될때까지 반복
			// 짝수번이면 반시계, 홀수번이면 시계
			// 던질좌표 찾기
			if (countArr[currMove] % 2 == 0) {
				nextMove = currMove - l;
				while (nextMove < 0) {
					nextMove = n + nextMove;
				}
			} else {
				nextMove = currMove + l;
				while (nextMove >= n) {
					nextMove = nextMove - n;
				}
			}
			// 던지고 받아주기
			countArr[nextMove]++;
			resultThrowCount++;
			if (countArr[nextMove] == m) {
				System.out.println(resultThrowCount);
				break;
			}
			// 다음루프 세팅
			currMove = nextMove;
		}
	}
}
