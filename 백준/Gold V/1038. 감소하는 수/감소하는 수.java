
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n;
	static Set<Long> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<Long>();
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 10; i++) {
			addSet(10, String.valueOf(i));
		}
		
		Object[] sorting = set.toArray();
		Arrays.sort(sorting);

		try {
			System.out.println(sorting[n]);
		}catch(Exception e) {
			System.out.println(-1);
		}
	}

	private static void addSet(long count, String nowNumber) {
		if (count < nowNumber.length()) {
			return;
		}
		for (int i = Integer.parseInt(nowNumber.charAt(nowNumber.length() - 1) + "") - 1; i >= 0; i--) {
			addSet(count, nowNumber + "" + i);
		}
		set.add(Long.parseLong(nowNumber));
	}
}