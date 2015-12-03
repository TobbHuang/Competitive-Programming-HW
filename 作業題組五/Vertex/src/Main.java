import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}

			graph = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			while (true) {
				int num1 = sc.nextInt();
				if (num1 == 0) {
					break;
				}

				while (true) {
					int num2 = sc.nextInt();
					if (num2 == 0) {
						break;
					}

					graph[num1 - 1].add(num2 - 1);

				}

			}

			int num1 = sc.nextInt();
			while (num1-- > 0) {
				ArrayList<Integer> output = new ArrayList<Integer>();
				ArrayList<Integer> track = new ArrayList<Integer>();
				int num2 = sc.nextInt();
				for (int i = 0; i < graph.length; i++) {
					if (!search(num2 - 1, i, track)) {
						output.add(i);
					}
				}
				System.out.print(output.size());
				for (int i = 0; i < output.size(); i++) {
					System.out.print(" " + (output.get(i) + 1));
				}
				System.out.println();
			}

		}

		sc.close();

	}

	static boolean search(int p, int q, ArrayList<Integer> track) {

		// 防止循环
		for (int i = 0; i < track.size(); i++) {
			if (track.get(i) == p) {
				return false;
			}
		}

		ArrayList<Integer> tmp=new ArrayList<Integer>();
		for (int i = 0; i < track.size(); i++) {
			tmp.add(track.get(i));
		}
		tmp.add(p);

		// 查找是否有直接通达的
		for (int i = 0; i < graph[p].size(); i++) {
			if (graph[p].get(i) == q) {
				return true;
			}
		}

		// 查找是否有间接通达的
		for (int i = 0; i < graph[p].size(); i++) {
			if (search(graph[p].get(i), q, tmp)) {
				return true;
			}
		}

		return false;

	}

}
