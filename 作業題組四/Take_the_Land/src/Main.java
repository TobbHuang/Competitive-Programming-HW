import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {

			int m = sc.nextInt();
			int n = sc.nextInt();

			if (m == 0)
				break;

			int[][] data = new int[m][n];

			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					data[i][j] = sc.nextInt();

			int max = 0;
			for (int i = 0; i < m; i++) {
				// 矩形从第i行开始
				for (int j = 0; j < n; j++) {
					for (int k = j; k < n; k++) {
						// j为左端点，k为右端点
						boolean tmp = sum(data, i, j, k);
						if (tmp) {
							int i2;
							// max = Math.max(k - j + 1, max);

							for (i2 = i + 1; i2 < m; i2++) {
								// 从i+1行开始试矩阵
								tmp = sum(data, i2, j, k);
								if (!tmp) {
									break;
								}
							}
							max = Math.max((k - j + 1) * (i2 - i), max);
						}

					}
				}

			}

			System.out.println(max);

		}

		sc.close();
	}

	static boolean sum(int[][] data, int i, int j, int k) {
		// i为行index，j为左端点，k为右端点
		int sum = 0;
		for (int tmp = j; tmp <= k; tmp++) {
			sum += data[i][tmp];
		}

		if (sum == 0)
			return true;

		return false;

	}

}
