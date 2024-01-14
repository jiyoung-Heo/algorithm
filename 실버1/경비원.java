package 실버1;

import java.util.*;

//10:11
public class 경비원 {
	public static void main(String[] args) {
//		첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다. 
//		둘째 줄에 상점의 개수가 주어진다. 
//		블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다. 
//		이어 한 줄에 하나씩 상점의 위치가 주어진다. 
//		상점의 위치는 두 개의 자연수로 표시된다. 
//		첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 
//		둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다. 
//		마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 
//		상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
		Scanner sc = new Scanner(System.in);
		// 가로
		int width = sc.nextInt();
		// 세로
		int height = sc.nextInt();
		// 상점개수
		int count = sc.nextInt();

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			// 각 상점의 위치 좌표로 저장
			int 방향 = sc.nextInt();
			int 왼쪽_가로12or위쪽_세로34으로부터의거리 = sc.nextInt();

			list.add(xy(width,height,방향, 왼쪽_가로12or위쪽_세로34으로부터의거리));
		}

		// 동근위치
		int dong방향 = sc.nextInt();
		int dong거리 = sc.nextInt();
		
		// 동근좌표
		int[] 동arr = xy(width,height,dong방향, dong거리);
		
		for (int i = 0; i < count; i++) {
			int[] arr = list.get(i);
			
		}

//		첫째 줄에 동근이의 위치와 각 상점 사이의 최단 거리의 합을 출력한다.
	}
	
	public static int[] xy(int width, int height, int 방향, int 왼쪽_가로12or위쪽_세로34으로부터의거리) {
		int[] arr = new int[2];
		
		if (방향 == 1) {
			// x좌표
			arr[0] = 왼쪽_가로12or위쪽_세로34으로부터의거리;
			// y좌표
			arr[1] = height;
		} else if (방향 == 2) {
			arr[0] = 왼쪽_가로12or위쪽_세로34으로부터의거리;
			arr[1] = 0;
		} else if (방향 == 3) {
			arr[0] = 0;
			arr[1] = height - 왼쪽_가로12or위쪽_세로34으로부터의거리;
		} else if (방향 == 4) {
			arr[0] = width;
			arr[1] = height - 왼쪽_가로12or위쪽_세로34으로부터의거리;
		}
		
		return arr;
	}
}
//10 5
//3
//1 4
//3 2
//2 8
//2 3

//23