import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int number = Integer.parseInt(n);

		String grade = sc.nextLine();
		String[] grades = grade.split(" ");

		double highGrade = 0;
		double recentGrade =0;
		for (int i = 0; i < number; i++) {
			recentGrade = Integer.parseInt(grades[i]);
			if (highGrade < recentGrade) {
				highGrade = recentGrade;
			}
		}
		double sum = 0;
		for (int i = 0; i < number; i++) {
			recentGrade = Integer.parseInt(grades[i]);
			sum += recentGrade/highGrade*100;
		}
		System.out.println(sum/number);
	}
}