import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int[] calc;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	// 2:00
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[n];
		calc = new int[4];
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}

		dfs(nums[0], 0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int sum, int index) {
		if (index == nums.length - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < calc.length; i++) {
			if(calc[i] == 0) continue;
			calc[i] --;
			if(i == 0) {
				dfs(sum + nums[index + 1], index + 1);
			}else if (i == 1) {
				dfs(sum - nums[index + 1], index + 1);
			}else if(i == 2) {
				dfs(sum * nums[index + 1], index + 1);
			}else if(i==3) {
				dfs(sum / nums[index + 1], index + 1);
			}
			calc[i] ++;
//			if (calc[0] != 0) {
//				calc[0]--;
//				dfs(sum + nums[index + 1], index + 1);
//				calc[0]++;
//			}
//			if (calc[1] != 0) {
//				calc[1]--;
//				dfs(sum - nums[index + 1], index + 1);
//				calc[1]++;
//			}
//			if (calc[2] != 0) {
//				calc[2]--;
//				dfs(sum * nums[index + 1], index + 1);
//				calc[2]++;
//			}
//			if (calc[3] != 0) {
//				calc[3]--;
//				dfs(sum / nums[index + 1], index + 1);
//				calc[3]++;
//			}
		}
	}
}
