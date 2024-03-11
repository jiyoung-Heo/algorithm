import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		String target = br.readLine();
		char[] bArr = target.toCharArray();

		for (int j = bArr.length - 1; j >= 0; j--) {
			System.out.println((bArr[j] - '0') * number);
		}
		System.out.println(number * Integer.parseInt(target));
	}
}
