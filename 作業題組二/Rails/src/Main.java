import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			int numOfTrains = sc.nextInt();
			if (numOfTrains == 0) {
				break;
			}

			while (true) {
				int tmp = sc.nextInt();
				if (tmp == 0) {
					break;
				}

				int[] per = new int[numOfTrains];
				per[0] = tmp;
				for (int i = 1; i < numOfTrains; i++) {
					per[i] = sc.nextInt();
				}

				// 栈
				int[] stack = new int[numOfTrains];
				int i = 0;
				int pos = 0;
				int currTrain = 1;
				stack[pos] = currTrain;
				while (true) {
					if (pos != -1 && per[i] == stack[pos]) {
						// 出栈
						pos--;
						i++;
					} else {
						// 入栈
						currTrain++;
						if (currTrain > numOfTrains)
							break;

						pos++;
						stack[pos] = currTrain;
					}
				}
				if (pos == -1)
					System.out.println("Yes");
				else
					System.out.println("No");

			}

			System.out.println();

		}

		sc.close();

	}

}
