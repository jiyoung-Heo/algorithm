import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String calc = br.readLine();
		Map<Character, Double> engMap = new HashMap<Character, Double>();
		for (int i = 0; i < n; i++) {
			engMap.put((char) ((char) i + 'A'), Double.parseDouble(br.readLine()));
		}

		String[] splitArr = calc.split("");

		Stack<Double> numStack = new Stack<>();

		for (int j = 0; j < splitArr.length; j++) {
			if (!splitArr[j].equals("*") && !splitArr[j].equals("/") && !splitArr[j].equals("+")
					&& !splitArr[j].equals("-")) {
				numStack.push(engMap.get(splitArr[j].charAt(0)));
			} else {
				double num1 = numStack.pop();
				double num2 = numStack.pop();

				if (splitArr[j].equals("*")) {
					numStack.push(num2 * num1);
				}
				if (splitArr[j].equals("/")) {
					numStack.push(num2 / num1);
				}
				if (splitArr[j].equals("+")) {
					numStack.push(num2 + num1);
				}
				if (splitArr[j].equals("-")) {
					numStack.push(num2 - num1);
				}
			}
		}
		System.out.printf("%.2f", new Object[] { numStack.pop() });
	}
}