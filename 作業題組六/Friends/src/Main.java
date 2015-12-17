import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int numOfCase = sc.nextInt();
		while (numOfCase-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int max = 0;

			boolean[] isViested = new boolean[n];
			for (int i = 0; i < n; i++) {
				isViested[i] = false;
			}

			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < m; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list.get(from - 1).add(to - 1);
				list.get(to - 1).add(from - 1);
			}

			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < list.size(); i++) {
				if (isViested[i])
					continue;

				stack.push(i);

				int tmp = 1;
				isViested[i] = true;

				while (!stack.empty()) {
					int pop = stack.pop();
					ArrayList<Integer> tmpList = list.get(pop);

					for (int j = 0; j < tmpList.size(); j++) {
						if (!isViested[tmpList.get(j)]) {
							tmp++;
							stack.push(tmpList.get(j));
							isViested[tmpList.get(j)] = true;
						}
					}

				}

				max = Math.max(max, tmp);

			}

			System.out.println(max);

		}

		sc.close();

	}

}
