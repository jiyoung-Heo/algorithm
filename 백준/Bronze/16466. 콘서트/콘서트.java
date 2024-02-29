import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
		set.add(Integer.parseInt(st.nextToken()));
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if(!set.contains(i)) {
				result = i;
				break;
			}
		}
		if(result == 0) {
			result = N+1;
		}
		System.out.println(result);
		
	}
}