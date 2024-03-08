import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static int n ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		arr = new ArrayList[n]; 
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
			arr[a].add(b);
			arr[b].add(a);
		}
		
		//1번과 연결연결된 컴퓨터의 수 출력
		int number = connectedCount();
		System.out.println(number);
	}
	private static int connectedCount() {
		Queue<Integer> que = new ArrayDeque<>();
		boolean visited[] = new boolean[n];
		que.add(0);
		int count = 0;
		
		while(!que.isEmpty()) {
			int pollInteger = que.poll();
			visited[pollInteger] = true;
			for (int i = 0; i < arr[pollInteger].size(); i++) {
				if(!visited[arr[pollInteger].get(i)]) {
					visited[arr[pollInteger].get(i)] = true;
					que.add(arr[pollInteger].get(i));
					count++;
				}
			}
		}
		
		return count;
	}
}
