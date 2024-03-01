import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 바닥, 오,왼,위,아래,top

	static int[] diceX = { 0, 0, 0 };// 가로
	static int[] diceY = { 0, 0, 0, 0 };// 세로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		// 세로 크기 N, 가로 크기 M
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 주사위를 놓은 곳의 좌표
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 명령의 개수
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int currX = x;
		int currY = y;
		// 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			// 해당 방향으로 주사위 굴리기
			int moveDir = Integer.parseInt(st.nextToken());
			switch (moveDir) {
			case 1:
				if (currY + 1 >= m) {
					continue;
				}
				currY += 1;
				diceX = new int[] { diceX[2], diceX[0], diceX[1] };
				int tempR = diceY[3];
				diceY[3] = diceX[0];
				diceX[0] = tempR;
				diceY[1] = diceX[1];
				break;
			case 2:
				if (currY - 1 < 0) {
					continue;
				}
				currY -= 1;
				diceX = new int[] { diceX[1], diceX[2], diceX[0] };
				int tempL = diceY[3];
				diceY[3] = diceX[2];
				diceX[2] = tempL;
				diceY[1] = diceX[1];
				break;
			case 3:
				if (currX - 1 < 0) {
					continue;
				}
				currX -= 1;
				// 북
				diceY = new int[] { diceY[1], diceY[2], diceY[3], diceY[0] };
				diceX[1] = diceY[1];
				break;
			case 4:
				if (currX + 1 >= n) {
					continue;
				}
				currX += 1;
				diceY = new int[] { diceY[3], diceY[0], diceY[1], diceY[2] };
				diceX[1] = diceY[1];
				break;
			}

			// 이동한 칸에 쓰여있는 수가 0이면 주사위의 바닥에 있는 수가 칸에 복사된다.
			if (arr[currX][currY] == 0) {
				arr[currX][currY] = diceY[3];
			}
			// else 0이 아니면 칸에 쓰여 있는 수가 주사위 바닥에 복사된 후 칸은 0이 된다.
			else {
				diceY[3] = arr[currX][currY];
				arr[currX][currY] = 0;
			}

			// 주사위 상단에 쓰여 있는 값은?
			System.out.println(diceY[1]);
		}
	}
}
