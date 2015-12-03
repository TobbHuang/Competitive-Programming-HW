import java.util.Scanner;

public class Main {

	static int[][] map;
	static int m, n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();

			if (m == 0 && n == 0) {
				break;
			}
			sc.nextLine();

			int count = 0;

			map = new int[m][n];
			for (int i = 0; i < m; i++) {
				String tmp = sc.nextLine();
				for (int j = 0; j < n; j++) {
					if (tmp.charAt(j) == '*') {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						count++;
						find(i, j);
					}
				}
			}

			System.out.println(count);

		}

		sc.close();

	}

	static void find(int i, int j) {
		map[i][j] = 0;

		if (j != 0) {
			if (map[i][j - 1] == 1) {
				find(i, j - 1);
			}
			if (i != 0) {
				if (map[i - 1][j - 1] == 1) {
					find(i - 1, j - 1);
				}
			}
			if (i != m - 1) {
				if (map[i + 1][j - 1] == 1) {
					find(i + 1, j - 1);
				}
			}
		}

		if (j != n - 1) {
			if (map[i][j + 1] == 1) {
				find(i, j + 1);
			}
			if (i != 0) {
				if (map[i - 1][j + 1] == 1) {
					find(i - 1, j + 1);
				}
			}
			if (i != m - 1) {
				if (map[i + 1][j + 1] == 1) {
					find(i + 1, j + 1);
				}
			}
		}

		if (i != 0) {
			if (map[i - 1][j] == 1) {
				find(i - 1, j);
			}
		}

		if (i != m - 1) {
			if (map[i + 1][j] == 1) {
				find(i + 1, j);
			}
		}

	}

}
