import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			int R, C;
			R = sc.nextInt();
			C = sc.nextInt();

			if (R == 0 && C == 0) {
				break;
			}

			int[][] map = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = -2;
				}
			}

			int n = sc.nextInt();
			while (n-- > 0) {
				int x = sc.nextInt();
				int m = sc.nextInt();

				while (m-- > 0) {
					map[x][sc.nextInt()] = -1;
				}
			}

			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int destX = sc.nextInt();
			int destY = sc.nextInt();

			map[startX][startY] = 0;

			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(startX, startY));

			while (!q.isEmpty()) {
				Node node = q.remove();

				if (node.x < 0 || node.x >= R || node.y < 0 || node.y >= C) {
					continue;
				}

				if (node.x == destX && node.y == destY) {
					break;
				}

				int x, y;

				x = node.x + 1;
				y = node.y;
				if (x < R && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x - 1;
				y = node.y;
				if (x >= 0 && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x;
				y = node.y + 1;
				if (y < C && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x;
				y = node.y - 1;
				if (y >= 0 && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

			}

			System.out.println(map[destX][destY]);

		}

		sc.close();

	}

}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
