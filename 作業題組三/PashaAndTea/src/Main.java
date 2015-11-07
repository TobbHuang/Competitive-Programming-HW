import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, w;
		int[] ai = null;

		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		n = Integer.parseInt(str[0]);
		w = Integer.parseInt(str[1]);

		str = sc.nextLine().split(" ");
		ai = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			ai[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(ai);

		double min1 = ai[0];
		double min2 = ai[n];

		if (min2 > 2 * min1)
			min2 = min1 * 2;
		else
			min1 = min2 / 2;

		if ((min1 * n + min2 * n) > w) {
			min1 = (double) w / 3 / n;
			min2 = (double) w / 3 / n * 2;
		}

		System.out.println(min1 * n + min2 * n);

		sc.close();

	}

}
