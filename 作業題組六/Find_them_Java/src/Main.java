import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int numOfCase = sc.nextInt();

		while (numOfCase-- > 0) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] same = new int[2 * n + 1];
			for (int i = 0; i < same.length; i++)
				same[i] = -1;

			sc.nextLine();

			while (m-- > 0) {

				String[] str = sc.nextLine().split(" ");
				int a = Integer.parseInt(str[1]) - 1;
				int b = Integer.parseInt(str[2]) - 1;

				if (str[0].equals("D")) {
					merge(a, b + n, same);
					merge(a + n, b, same);
				} else {
					if (find(a, same) == find(b, same)
							|| find(a + n, same) == find(b + n, same)) {
						System.out.println("In the same gang.");
					} else if (find(a + n, same) == find(b, same)
							|| find(a, same) == find(b + n, same)) {
						System.out.println("In the different gangs.");
					} else {
						System.out.println("Not sure yet.");
					}
				}

			}

		}

		sc.close();

	}

	static int find(int x, int[] same) {
		return (same[x] == -1 ? x : (same[x] = find(same[x], same)));
	}

	static void merge(int x, int y, int[] same) {
		if (find(y, same) != find(x, same)) {
			same[find(y, same)] = find(x, same);
		}
	}

}
