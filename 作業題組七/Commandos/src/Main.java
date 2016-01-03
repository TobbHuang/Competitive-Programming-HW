import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int numOfCase = sc.nextInt();
		for (int n = 1; n <= numOfCase; n++) {
			int num = sc.nextInt();
			int edge = sc.nextInt();

			int[][] map = new int[num][num];
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					map[i][j] = 100000;
				}
				map[i][i] = 0;
			}

			for (int i = 0; i < edge; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
				map[b][a] = 1;
			}

			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					for (int k = 0; k < num; k++) {
						if (map[j][k] > map[j][i] + map[i][k]) {
							map[j][k] = map[j][i] + map[i][k];
						}
					}
				}
			}

			int from = sc.nextInt();
			int to = sc.nextInt();
			int time = 0;
			for (int i = 0; i < num; i++) {
				if (time < map[from][i] + map[i][to]) {
					time = map[from][i] + map[i][to];
				}
			}

			System.out.println("Case " + n + ": " + time);

		}

		sc.close();

	}
}
