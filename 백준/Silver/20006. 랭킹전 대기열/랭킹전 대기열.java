import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			map.put(n, l);
			
			boolean flag = false;
			int count = 0;
			if(list.isEmpty()) {
				flag = true;
			}
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).size() == m) {
					count++;
				}else
				if (list.get(j).size() < m) {
					if(map.get(list.get(j).get(0))+10 >= l
						&& map.get(list.get(j).get(0)) - 10 <= l) {
						list.get(j).add(n);
						break;
					}else {
						count++;
					}
				}
			}
			if(count == list.size()) {
				flag = true;
			}
			if (flag) {
				ArrayList<String> listIn = new ArrayList<>();
				listIn.add(n);
				list.add(listIn);
			}
		}
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).size() == m) {
				System.out.println("Started!");
			}else {
				System.out.println("Waiting!");
			}
			Collections.sort(list.get(j));
			for (int i = 0; i < list.get(j).size(); i++) {
				System.out.println(map.get(list.get(j).get(i)) + " " + list.get(j).get(i));
			}
		}
	}
}
