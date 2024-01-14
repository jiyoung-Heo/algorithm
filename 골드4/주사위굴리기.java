package 골드4;

import java.util.Scanner;

public class 주사위굴리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int startx = sc.nextInt();
		int starty = sc.nextInt();
		int count = sc.nextInt();

		int[][] floorArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				floorArr[i][j] = sc.nextInt();
			}
		}
		int[] moveArr = new int[count];
		for (int i = 0; i < count; i++) {
			moveArr[i] = sc.nextInt();
		}
		
		int currTopNum = 0;
		int curr북Num = 0;
		int curr남Num = 0;
		int curr동Num = 0;
		int curr서Num = 0;
		int currBottomNum = 0;

		int pastTopNum = 0;
		int past북Num = 0;
		int past남Num = 0;
		int past동Num = 0;
		int past서Num = 0;
		int pastBottomNum = 0;

		int currX = startx;
		int currY = starty;

		for (int i = 0; i < moveArr.length; i++) {
			pastTopNum = currTopNum;
			past북Num = curr북Num;
			past남Num = curr남Num;
			past동Num = curr동Num;
			past서Num = curr서Num;
			pastBottomNum = currBottomNum;
			if (moveArr[i] == 1) {
				if (currX + 1 >= m)
					continue;
				currX += 1;
				currBottomNum = past동Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past서Num;
				curr동Num = pastTopNum;
				curr서Num = pastBottomNum;
				System.out.println(currTopNum);
				// 동 [][+1]
			} else if (moveArr[i] == 2) {
				if (currX - 1 < 0)
					continue;
				currX -= 1;
				currBottomNum = past서Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past동Num;
				curr동Num = pastBottomNum;
				curr서Num = pastTopNum;
				System.out.println(currTopNum);
				// 서 [][-1]
			} else if (moveArr[i] == 3) {
				if (currY - 1 < 0)
					continue;
				currY -= 1;
				currBottomNum = past북Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past남Num;
				curr북Num = pastTopNum;
				curr남Num = pastBottomNum;
				System.out.println(currTopNum);
				// 북 [-1][]
			} else if (moveArr[i] == 4) {
				if (currY + 1 >= n)
					continue;
				currY += 1;
				currBottomNum = past남Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past북Num;
				curr북Num = pastBottomNum;
				curr남Num = pastTopNum;
				System.out.println(currTopNum);
				// 남 [+1][]
			}
		}
		// 오답 12번째

	}
}
