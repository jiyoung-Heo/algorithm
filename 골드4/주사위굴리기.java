package ���4;

import java.util.Scanner;

public class �ֻ��������� {
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
		int curr��Num = 0;
		int curr��Num = 0;
		int curr��Num = 0;
		int curr��Num = 0;
		int currBottomNum = 0;

		int pastTopNum = 0;
		int past��Num = 0;
		int past��Num = 0;
		int past��Num = 0;
		int past��Num = 0;
		int pastBottomNum = 0;

		int currX = startx;
		int currY = starty;

		for (int i = 0; i < moveArr.length; i++) {
			pastTopNum = currTopNum;
			past��Num = curr��Num;
			past��Num = curr��Num;
			past��Num = curr��Num;
			past��Num = curr��Num;
			pastBottomNum = currBottomNum;
			if (moveArr[i] == 1) {
				if (currX + 1 >= m)
					continue;
				currX += 1;
				currBottomNum = past��Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past��Num;
				curr��Num = pastTopNum;
				curr��Num = pastBottomNum;
				System.out.println(currTopNum);
				// �� [][+1]
			} else if (moveArr[i] == 2) {
				if (currX - 1 < 0)
					continue;
				currX -= 1;
				currBottomNum = past��Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past��Num;
				curr��Num = pastBottomNum;
				curr��Num = pastTopNum;
				System.out.println(currTopNum);
				// �� [][-1]
			} else if (moveArr[i] == 3) {
				if (currY - 1 < 0)
					continue;
				currY -= 1;
				currBottomNum = past��Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past��Num;
				curr��Num = pastTopNum;
				curr��Num = pastBottomNum;
				System.out.println(currTopNum);
				// �� [-1][]
			} else if (moveArr[i] == 4) {
				if (currY + 1 >= n)
					continue;
				currY += 1;
				currBottomNum = past��Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past��Num;
				curr��Num = pastBottomNum;
				curr��Num = pastTopNum;
				System.out.println(currTopNum);
				// �� [+1][]
			}
		}
		// ���� 12��°

	}
}
