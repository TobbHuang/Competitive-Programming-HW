import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int[] ai;

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		ai = new int[n];

		for (int i = 0; i < n; i++) {
			ai[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			ai[i] += ai[i - 1];
		}

		int searchNum = sc.nextInt();
		int[] searchList = new int[searchNum];
		for (int i = 0; i < searchNum; i++) {
			searchList[i] = sc.nextInt();
		}
		sc.close();

		for (int i = 0; i < searchNum; i++) {
			int head = 0, tail = n - 1;
			while ((tail - head) > 1) {
				int tmp = (tail + head) / 2;
				if (searchList[i] > ai[tmp]) {
					head = tmp;
				} else {
					tail = tmp;
				}
			}
			if (ai[head] >= searchList[i])
				System.out.println(head + 1);
			else
				System.out.println(tail + 1);
		}

	}

}
