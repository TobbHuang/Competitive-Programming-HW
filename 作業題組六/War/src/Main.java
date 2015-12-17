import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] same = new int[2 * n];
		for (int i = 0; i < same.length; i++)
			same[i] = -1;

		while (true) {
			int c, a, b;
			c = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();

			if (c == 0 && a == 0 && b == 0)
				break;

			switch (c) {
			case 1:
				if (find(a + n, same) == find(b, same)) {
					System.out.println("-1");
				} else {
					merge(a, b, same);
					merge(a + n, b + n, same);
				}
				break;
			case 2:
				if (find(a, same) == find(b, same)) {
					System.out.println("-1");
				} else {
					merge(a, b + n, same);
					merge(a + n, b, same);
				}
				break;
			case 3:
				if (find(a, same) == find(b, same)) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case 4:
				if (find(a, same) == find(b + n, same)) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}

		}

		sc.close();

	}

	static int find(int a, int[] same) {
		return (same[a] == -1) ? a : (same[a] = find(same[a], same));
	}

	static void merge(int a, int b, int[] same) {
		if (find(b, same) != find(a, same)) {
			same[find(b, same)] = find(a, same);
		}
	}

}
