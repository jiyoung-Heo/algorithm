import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> priority = new HashMap<>();

		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);

		String calc = "(" + br.readLine() + ")";

		String calcString = "";
		Stack<Character> calcStack = new Stack<>();
		for (int j = 0; j < calc.length(); j++) {
			char c = calc.charAt(j);
			if (c >= '0' || c >= '9') {
				calcString += c;
			} else if (c == '(') {
				calcStack.push(c);
			} else if (c == ')') {
				while (!calcStack.isEmpty() && calcStack.peek() != '(') {
					calcString += calcStack.pop();
				}
				if (!calcStack.isEmpty() && calcStack.peek() == '(') {
					calcStack.pop();
				}
			} else if (c == '*' || c == '/') {
				while (!calcStack.isEmpty() && priority.get(calcStack.peek()) >= priority.get(c)) {
					calcString += calcStack.pop();
				}
				calcStack.push(c);
			} else if (c == '+' || c == '-') {
				while (!calcStack.isEmpty() && priority.get(calcStack.peek()) >= priority.get(c)) {
					calcString += calcStack.pop();
				}
				calcStack.push(c);
			}
		}

		System.out.println(calcString);

	}
}
