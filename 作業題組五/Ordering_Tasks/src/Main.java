import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] order;
	static int n;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			n = sc.nextInt();
			int m = sc.nextInt();

			if (m == 0 && n == 0) {
				break;
			}

			order = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				order[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				order[num2 - 1].add(num1 - 1);
			}

			ArrayList<Integer> output = new ArrayList<Integer>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			while (output.size() < n) {
				for (int i = 0; i < n; i++) {
					if (order[i] != null && order[i].size() == 0) {
						tmp.add(i);
						// System.out.println("add " + i);
					}
				}

				for (int i = 0; i < tmp.size(); i++) {
					// System.out.println(tmp.get(i));
					output.add(tmp.get(i));
					order[tmp.get(i)] = null;
					refreshOrder(tmp.get(i));

				}
				// System.out.println("output size: " + output.size());
				tmp.clear();

			}

			for (int i = 0; i < output.size(); i++) {
				if (i != output.size() - 1) {
					System.out.print(output.get(i) + 1 + " ");
				} else {
					System.out.println(output.get(i) + 1);
				}
			}

		}

		sc.close();

	}

	static void refreshOrder(int i) {
		for (int j = 0; j < n; j++) {
			if (order[j] != null) {
				for (int k = 0; k < order[j].size(); k++) {
					// System.out.println("j k " + j + " " + k);
					if (order[j].get(k) == i) {
						// System.out.println(j + " removes " +
						// order[j].get(k));
						order[j].remove(k);
						break;
					}
				}
			}
		}
	}

}
