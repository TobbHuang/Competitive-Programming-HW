import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] vec = new int[8][4];
		vec[0][0] = 1;
		vec[0][1] = 2;
		vec[0][2] = 0;
		vec[0][3] = 1;

		vec[1][0] = 2;
		vec[1][1] = 1;
		vec[1][2] = 1;
		vec[1][3] = 1;

		vec[2][0] = 2;
		vec[2][1] = -1;
		vec[2][2] = 1;
		vec[2][3] = 0;

		vec[3][0] = 1;
		vec[3][1] = -2;
		vec[3][2] = 1;
		vec[3][3] = -1;

		vec[4][0] = -1;
		vec[4][1] = -2;
		vec[4][2] = 0;
		vec[4][3] = -1;

		vec[5][0] = -2;
		vec[5][1] = -1;
		vec[5][2] = -1;
		vec[5][3] = -1;

		vec[6][0] = -2;
		vec[6][1] = 1;
		vec[6][2] = -1;
		vec[6][3] = 0;

		vec[7][0] = -1;
		vec[7][1] = 2;
		vec[7][2] = -1;
		vec[7][3] = 1;

		Scanner sc = new Scanner(System.in);

		int numOfCase = sc.nextInt();
		while (numOfCase-- > 0) {
			int m, n;
			m = sc.nextInt();
			n = sc.nextInt();
			sc.nextLine();

			Queue<yee> q = new LinkedList<yee>();
			char[][] map = new char[m][n];
			for (int i = 0; i < m; i++) {
				String tmp = sc.nextLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}

			int startX = 0, startY = 0;
			int destX = 0, destY = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'Z') {
						for (int k = 0; k < 8; k++) {
							if (i + vec[k][0] >= 0 && j + vec[k][1] >= 0
									&& i + vec[k][0] < m && j + vec[k][1] < n
									&& map[i + vec[k][0]][j + vec[k][1]] == '.') {
								map[i + vec[k][0]][j + vec[k][1]] = 'D';
							}
						}
					} else if (map[i][j] == 'A') {
						startX = i;
						startY = j;
					} else if (map[i][j] == 'B') {
						destX = i;
						destY = j;
					}
				}
			}

			boolean flag = true;
			map[destX][destY] = '.';
			q.add(new yee(startX, startY, 0));
			while (!q.isEmpty()) {
				yee y = q.poll();
				if (y.i == destX && y.j == destY) {
					flag = false;
					System.out.println("Minimal possible length of a trip is "
							+ y.len);
					break;
				}

				for (int i = 0; i < 8; i++) {
					if (y.i + vec[i][2] >= 0 && y.j + vec[i][3] >= 0
							&& y.i + vec[i][2] < m && y.j + vec[i][3] < n
							&& map[y.i + vec[i][2]][y.j + vec[i][3]] == '.') {
						map[y.i + vec[i][2]][y.j + vec[i][3]] = 'V';
						q.add(new yee(y.i + vec[i][2], y.j + vec[i][3],
								y.len + 1));
					}
				}

			}

			if (flag) {
				System.out.println("King Peter, you can't go now!");
			}

		}

		sc.close();

	}

}

class yee {
	int i, j, len;

	yee(int i, int j, int len) {
		this.i = i;
		this.j = j;
		this.len = len;
	}
}