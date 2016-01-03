import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfTestcase = sc.nextInt();

		while (numOfTestcase-- > 0) {
			int m, n;
			m = sc.nextInt();
			n = sc.nextInt();

			int[][] map = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = -2;
				}
			}
			sc.nextLine();

			int startX = 0;
			int startY = 0;
			int destX = 0;
			int destY = 0;

			for (int i = 0; i < m; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < n; j++) {
					if (str.charAt(j) == 'Z') {
						map[i][j] = -1;
					} else if (str.charAt(j) == 'A') {
						startX = i;
						startY = j;
					} else if (str.charAt(j) == 'B') {
						destX = i;
						destY = j;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == -1) {
						int x, y;

						x = i - 2;
						y = j - 1;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i - 1;
						y = j - 2;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i + 1;
						y = j - 2;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i + 2;
						y = j - 1;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i - 2;
						y = j + 1;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i - 1;
						y = j + 2;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i + 1;
						y = j + 2;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}

						x = i + 2;
						y = j + 1;
						if (x >= 0 && x < m && y >= 0 && y < n
								&& map[x][y] == -2) {
							map[x][y] = -3;
						}
					}
				}
			}
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}

			map[startX][startY] = 0;
			map[destX][destY] = -2;

			Queue<Node> q = new LinkedList<Node>();
			q.add(new Node(startX, startY));

			while (!q.isEmpty()) {
				Node node = q.remove();

				if (node.x < 0 || node.x >= m || node.y < 0 || node.y >= n) {
					continue;
				}

				if (node.x == destX && node.y == destY) {
					break;
				}

				int x, y;

				x = node.x + 1;
				y = node.y;
				if (x < m && map[x][y] == -2) {
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
				if (y < n && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x;
				y = node.y - 1;
				if (y >= 0 && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x + 1;
				y = node.y - 1;
				if (x < m && y >= 0 && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x - 1;
				y = node.y - 1;
				if (x >= 0 && y >= 0 && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x + 1;
				y = node.y + 1;
				if (x < m && y < n && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

				x = node.x - 1;
				y = node.y + 1;
				if (x >= 0 && y < n && map[x][y] == -2) {
					q.add(new Node(x, y));
					map[x][y] = map[node.x][node.y] + 1;
				}

			}
			
			

			if (map[destX][destY] == -2) {
				System.out.println("King Peter, you can’t go now!");
			} else {
				System.out.println("Minimal possible length of a trip is "
						+ map[destX][destY]);
			}

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
