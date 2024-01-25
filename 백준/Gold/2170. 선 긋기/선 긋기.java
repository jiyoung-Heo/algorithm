import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(Math.min(x, y), Math.max(x, y)));
		}
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x > o2.x) {
					return 1;
				} else if (o1.x == o2.x && o1.y > o2.y) {
					return 1;
				}
				return -1;
			}
		});

		int currX = list.get(0).x;
		int currY = list.get(0).y;
		sum += currY - currX;

		for (int i = 1; i < list.size(); i++) {
			int nextX = list.get(i).x;
			int nextY = list.get(i).y;
			//x와 y 사이에 nextY
			if (currX < nextX && currY > nextX && nextY > currY) {
				sum += nextY - currY;
				currY = nextY;
			//y와 nextX 같음
			} else if (currY < nextX || nextX == currY) {
				sum += nextY - nextX;
				currY = nextY;
			//x, y ... nextX, nextY
			} else if (currY < nextX) {
				sum += nextY - nextX;
				currX = nextX;
			}
		}

		System.out.println(sum);
	}
}

