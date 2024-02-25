import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());

		int nowTX = t - (w - p);
		// 튕기고 몇번 남는지
		int xSum = nowTX % w;
		// 한번도 튕기지 않는 경우
		if (nowTX < 0) {
			// x좌표값 설정하기
			xSum = p + t;
		} else {
			// 현재 진행방향 체크하기.
			// 0일 경우는 오른쪽에서 왼쪽으로 진행
			if (nowTX / w % 2 == 0) {
				xSum = w - xSum;
			}
		}

		int nowTY = t - (h - q);
		int ySum = nowTY % h;
		if (nowTY < 0) {
			ySum = q + t;
		} else {
			if (nowTY / h % 2 == 0) {
				ySum = h - ySum;
			}
		}
		sb.append(xSum);
		sb.append(" ");
		sb.append(ySum);
		System.out.println(sb);
	}
}
