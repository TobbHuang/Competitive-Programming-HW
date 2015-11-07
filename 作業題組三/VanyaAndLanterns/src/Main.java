import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, l;
		int[] ai;

		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		n = Integer.parseInt(str[0]);
		l = Integer.parseInt(str[1]);

		str = sc.nextLine().split(" ");
		sc.close();
		ai = new int[n];
		for (int i = 0; i < str.length; i++) {
			ai[i] = Integer.parseInt(str[i]);
		}

		Arrays.sort(ai);
		double maxLength = ai[0];
		for (int i = 1; i < n; i++) {
			double tmp = (double) (ai[i] - ai[i - 1]) / 2;
			if (tmp > maxLength) {
				maxLength = tmp;
			}
		}
		int tmp = l - ai[n - 1];
		if (tmp > maxLength) {
			maxLength = tmp;
		}

		System.out.println(maxLength);

	}

}
