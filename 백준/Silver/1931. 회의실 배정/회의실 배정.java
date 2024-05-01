import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Use> que = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = end - start;
			que.add(new Use(start, end, length));
		}
		int sum =0 ;
		int currStart = 0;
		int currEnd = 0;
		while(!que.isEmpty()) {
			Use use = que.poll();
			if(currEnd <= use.start) {
				sum ++;
				currStart = use.start;
				currEnd = use.end;
//				System.out.println(currStart+" "+currEnd);
			}else {
				if(currEnd>= use.end) {
					currStart = use.start;
					currEnd = use.end;
//					System.out.println(currStart+" "+currEnd);
				}
			}
		}
		System.out.println(sum);

	}

	static class Use implements Comparable<Use>{
		int start, end, length;

		public Use(int start, int end, int length) {
			super();
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Use o) {
			if(this.start == o.start) {
				return this.length-o.length;
			}
			return this.start -o.start;
		}
		
		

	}
}
