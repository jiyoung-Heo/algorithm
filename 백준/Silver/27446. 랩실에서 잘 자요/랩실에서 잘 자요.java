import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		List<Integer> total = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			set.add(sc.nextInt());
		}

		for (int i = 1; i <= N; i++) {
			if (!(set.contains(i))) {
				total.add(i);
			}
		}
		Collections.sort(total);

		int sum = 0;
		int startIdx = 0;
		for (int i = 0; i < total.size() - 1; i++) {
			if (total.get(i + 1) - total.get(i) > 3) {
				int cnt = total.get(i) - total.get(startIdx) + 1;
				sum += 5 + 2 * cnt;
				startIdx = i + 1;
			}
		}
		
		if (startIdx != total.size()) {
			int cnt = total.get(total.size() - 1) - total.get(startIdx) + 1;
			sum += 5 + 2 * cnt;
		}

		System.out.println(sum);
	}
}