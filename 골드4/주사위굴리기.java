package °ñµå4;

import java.util.Scanner;

public class ÁÖ»çÀ§±¼¸®±â {
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
		int currºÏNum = 0;
		int curr³²Num = 0;
		int currµ¿Num = 0;
		int curr¼­Num = 0;
		int currBottomNum = 0;

		int pastTopNum = 0;
		int pastºÏNum = 0;
		int past³²Num = 0;
		int pastµ¿Num = 0;
		int past¼­Num = 0;
		int pastBottomNum = 0;

		int currX = startx;
		int currY = starty;

		for (int i = 0; i < moveArr.length; i++) {
			pastTopNum = currTopNum;
			pastºÏNum = currºÏNum;
			past³²Num = curr³²Num;
			pastµ¿Num = currµ¿Num;
			past¼­Num = curr¼­Num;
			pastBottomNum = currBottomNum;
			if (moveArr[i] == 1) {
				if (currX + 1 >= m)
					continue;
				currX += 1;
				currBottomNum = pastµ¿Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past¼­Num;
				currµ¿Num = pastTopNum;
				curr¼­Num = pastBottomNum;
				System.out.println(currTopNum);
				// µ¿ [][+1]
			} else if (moveArr[i] == 2) {
				if (currX - 1 < 0)
					continue;
				currX -= 1;
				currBottomNum = past¼­Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = pastµ¿Num;
				currµ¿Num = pastBottomNum;
				curr¼­Num = pastTopNum;
				System.out.println(currTopNum);
				// ¼­ [][-1]
			} else if (moveArr[i] == 3) {
				if (currY - 1 < 0)
					continue;
				currY -= 1;
				currBottomNum = pastºÏNum;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = past³²Num;
				currºÏNum = pastTopNum;
				curr³²Num = pastBottomNum;
				System.out.println(currTopNum);
				// ºÏ [-1][]
			} else if (moveArr[i] == 4) {
				if (currY + 1 >= n)
					continue;
				currY += 1;
				currBottomNum = past³²Num;
				if (floorArr[currY][currX] == 0) {
					floorArr[currY][currX] = currBottomNum;
				} else {
					currBottomNum = floorArr[currY][currX];
				}
				currTopNum = pastºÏNum;
				currºÏNum = pastBottomNum;
				curr³²Num = pastTopNum;
				System.out.println(currTopNum);
				// ³² [+1][]
			}
		}
		// ¿À´ä 12¹øÂ°

	}
}
