import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> resultList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			resultList.add(Integer.parseInt(br.readLine()));
		}
		int allSum = 0;
		for (int data : resultList) {
			allSum += data;
		}
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (!flag) {
					int a = resultList.get(i);
					int b = resultList.get(j);
					int result = allSum - a - b;
					if (result == 100) {
						resultList.remove((Object) a);
						resultList.remove((Object) b);
						flag = true;
					}
				}
			}
		}
		Collections.sort(resultList);
		for (int data : resultList) {
			System.out.println(data);
		}

	}
}
