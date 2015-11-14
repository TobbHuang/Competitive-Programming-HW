import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();

		while (numOfCase-- > 0) {
			int head = 0;
			int M = sc.nextInt();

			ArrayList<Integer> indexSelected = new ArrayList<Integer>();
			ArrayList<int[]> coordinate = new ArrayList<int[]>();
			while (true) {
				int[] tmp = new int[2];
				tmp[0] = sc.nextInt();
				tmp[1] = sc.nextInt();
				if (tmp[0] == 0 && tmp[1] == 0) {
					break;
				}
				coordinate.add(tmp);
			}

			while (true) {
				int index = -1;
				int tail = 0;
				for (int i = 0; i < coordinate.size(); i++) {
					int[] tmp = coordinate.get(i);
					if (tmp[0] <= head && tmp[1] > head && tmp[1] > tail) {
						index = i;
						tail = tmp[1];
					}
				}
				if (index == -1) {
					System.out.println("0");
					System.out.println();
					break;
				} else {
					indexSelected.add(index);
					head = tail;
				}

				if (head >= M) {
					System.out.println(indexSelected.size());
					for (int i = 0; i < indexSelected.size(); i++) {
						int[] tmp = coordinate.get(indexSelected.get(i));
						System.out.println(tmp[0] + " " + tmp[1]);
					}

					break;
				}
			}

		}

		sc.close();

	}

}
