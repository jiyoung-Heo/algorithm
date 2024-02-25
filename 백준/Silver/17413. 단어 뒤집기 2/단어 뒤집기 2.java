import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String Start = br.readLine();

		boolean flag = true;
		char[] arr = Start.toCharArray();

		StringBuilder sb2 = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			String a = String.valueOf(arr[i]);
			if (a.equals("<")) {
				sb.append(sb2);
				sb2 = new StringBuilder();
				sb2.append("<");
				flag = false;
				continue;
			}
			if (!flag) {
				if (!a.equals(">")) {
					sb2.append(a);
				} else {
					sb2.append(">");
					sb.append(sb2);
					sb2 = new StringBuilder();
					flag = true;
				}
			} else {
				if(a.equals(" ")) {
					sb2.append(" ");
					sb.append(sb2);
					sb2 = new StringBuilder();
				}else {
					sb2.insert(0, a);
				}
			}
		}
		sb.append(sb2);
		
		System.out.println(sb);
		
	}
}
