import java.util.Scanner;

public class Main {
	public static int[][][] set = new int[11][27][27];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			for (int j = 4; j < 23; j++) {
				for (int k = 4; k < 23; k++) {
					set[i][j][k] = sc.nextInt();
				}
			}
		}
		sc.close();

		for (int i = 0; i < m; i++) {
			find(i);
		}

	}

	static void find(int j) {
		int m, n;
		for (m = 4; m < 23; m++) {
			for (n = 4; n < 23; n++) {
				if (set[j][m][n] == 1) {
					if ((set[j][m + 1][n] == 1 && set[j][m + 2][n] == 1
							&& set[j][m + 3][n] == 1 && set[j][m + 4][n] == 1
							&& set[j][m + 5][n] != 1 && set[j][m - 1][n] != 1)
							|| (set[j][m][n + 1] == 1 && set[j][m][n + 2] == 1
									&& set[j][m][n + 3] == 1
									&& set[j][m][n + 4] == 1
									&& set[j][m][n + 5] != 1 && set[j][m][n - 1] != 1)
							|| (set[j][m + 1][n + 1] == 1
									&& set[j][m + 2][n + 2] == 1
									&& set[j][m + 3][n + 3] == 1
									&& set[j][m + 4][n + 4] == 1
									&& set[j][m + 5][n + 5] != 1 && set[j][m - 1][n - 1] != 1)
							|| (set[j][m - 1][n + 1] == 1
									&& set[j][m - 2][n + 2] == 1
									&& set[j][m - 3][n + 3] == 1
									&& set[j][m - 4][n + 4] == 1
									&& set[j][m - 5][n + 5] != 1 && set[j][m + 1][n - 1] != 1)) {
						System.out
								.print("1\n" + (m - 3) + " " + (n - 3) + "\n");
						return;
					}

				} else if (set[j][m][n] == 2) {
					if ((set[j][m + 1][n] == 2 && set[j][m + 2][n] == 2
							&& set[j][m + 3][n] == 2 && set[j][m + 4][n] == 2
							&& set[j][m + 5][n] != 2 && set[j][m - 1][n] != 2)
							|| (set[j][m][n + 1] == 2 && set[j][m][n + 2] == 2
									&& set[j][m][n + 3] == 2
									&& set[j][m][n + 4] == 2
									&& set[j][m][n + 5] != 2 && set[j][m][n - 1] != 2)
							|| (set[j][m + 1][n + 1] == 2
									&& set[j][m + 2][n + 2] == 2
									&& set[j][m + 3][n + 3] == 2
									&& set[j][m + 4][n + 4] == 2
									&& set[j][m + 5][n + 5] != 2 && set[j][m - 1][n - 1] != 2)
							|| (set[j][m - 1][n + 1] == 2
									&& set[j][m - 2][n + 2] == 2
									&& set[j][m - 3][n + 3] == 2
									&& set[j][m - 4][n + 4] == 2
									&& set[j][m - 5][n + 5] != 2 && set[j][m + 1][n - 1] != 2)) {
						System.out
								.print("2\n" + (m - 3) + " " + (n - 3) + "\n");
						return;
					}

				}
			}
		}

		System.out.print("0\n");

	}
}
