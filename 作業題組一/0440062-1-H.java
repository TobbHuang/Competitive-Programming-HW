import java.util.Scanner;

public class Main {

	static int a[][], x[][], y[][], b[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean isFirst = true;
		while (sc.hasNextInt()) {

			if (isFirst)
				isFirst = false;
			else
				System.out.println();

			int m = sc.nextInt();

			a = new int[m * m][m * m];
			x = new int[m * m][m * m];// 行
			y = new int[m * m][m * m];// 列
			b = new int[m * m][m * m];// 3*3box

			for (int i = 0; i < m * m; i++) {
				for (int j = 0; j < m * m; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] != 0) {
						x[i][a[i][j] - 1] = 1;
						y[j][a[i][j] - 1] = 1;
						b[(i / m) * m + j / m][a[i][j] - 1] = 1;
					}
				}
			}

			if (find(m, 0) == 0) {
				System.out.println("NO SOLUTION");
			}

		}

		sc.close();
	}

	static int find(int m, int index) {

		if (index == m * m * m * m) {
			for (int i = 0; i < m * m; i++) {
				for (int j = 0; j < m * m; j++) {
					System.out.print(a[i][j]);
					if (j != m * m - 1)
						System.out.print(" ");
				}
				System.out.println();
			}
			return 1;
		}

		int i = index / (m * m);
		int j = index % (m * m);

		if (a[i][j] != 0)
			return find(m, index + 1);

		for (int k = 0; k < m * m; k++) {
			if (x[i][k] == 0 && y[j][k] == 0 && b[(i / m) * m + j / m][k] == 0) {
				x[i][k] = 1;
				y[j][k] = 1;
				b[(i / m) * m + j / m][k] = 1;
				a[i][j] = k + 1;
				if (find(m, index + 1) == 1)
					return 1;
				x[i][k] = 0;
				y[j][k] = 0;
				b[(i / m) * m + j / m][k] = 0;
				a[i][j] = 0;
			}
		}

		return 0;
	}
}
