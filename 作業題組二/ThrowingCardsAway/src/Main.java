import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			if (num == 0)
				break;

			int head = 0, tail = num;
			int[] a = new int[1000000];
			for (int i = 0; i < num; i++) {
				a[i] = i + 1;
			}

			System.out.print("Discarded cards:");
			while ((tail - head) > 1) {
				if (head != 0) {
					System.out.print(",");
				}
				System.out.print(" " + a[head]);
				a[tail] = a[head + 1];
				head += 2;
				tail++;
			}
			System.out.println();
			System.out.println("Remaining card: " + a[head]);

		}

		sc.close();

	}

}
