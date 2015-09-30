import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int[] a = new int[10];
	public static ArrayList<String>[] print;
	public static ArrayList<Integer> num = new ArrayList<Integer>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);

		while (true) {
			int temp = sc.nextInt();
			if (temp == 0) {
				break;
			}
			num.add(temp);
		}
		sc.close();
		

		long time1=System.currentTimeMillis();

		print = new ArrayList[num.size()];
		for (int i = 0; i < print.length; i++) {
			print[i] = new ArrayList<String>();
		}

		permutation(0);

		for (int i = 0; i < print.length; i++) {
			ArrayList<String> list = print[i];
			if (list.size() == 0) {
				System.out.println("There are no solutions for " + num.get(i)
						+ ".");
			} else {
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}

			}
			if (i != print.length - 1)
				System.out.println();
		}
		
		long time2=System.currentTimeMillis();
		
		//System.out.println(time2-time1);

	}

	public static void permutation(int position) {
		int i, j;
		if (position == 10) {

			for (int k = 0; k < print.length; k++) {
				if (((double) (a[0] * 10000 + a[1] * 1000 + a[2] * 100 + a[3]
						* 10 + a[4]) / (double) (a[5] * 10000 + a[6] * 1000
						+ a[7] * 100 + a[8] * 10 + a[9])) == num.get(k)) {

					if (a[5] == 0) {
						print[k].add((a[0] * 10000 + a[1] * 1000 + a[2] * 100
								+ a[3] * 10 + a[4])
								+ " / 0"
								+ (a[6] * 1000 + a[7] * 100 + a[8] * 10 + a[9])
								+ " = " + num.get(k));
					} else {
						print[k].add((a[0] * 10000 + a[1] * 1000 + a[2] * 100
								+ a[3] * 10 + a[4])
								+ " / "
								+ (a[5] * 10000 + a[6] * 1000 + a[7] * 100
										+ a[8] * 10 + a[9])
								+ " = "
								+ num.get(k));
					}

					// 如果有同样的输入数字
					for (int m = k + 1; m < print.length; m++) {
						if (num.get(k) == num.get(m)) {
							if (a[5] == 0) {
								print[m].add((a[0] * 10000 + a[1] * 1000 + a[2]
										* 100 + a[3] * 10 + a[4])
										+ " / 0"
										+ (a[6] * 1000 + a[7] * 100 + a[8] * 10 + a[9])
										+ " = " + num.get(k));
							} else {
								print[m].add((a[0] * 10000 + a[1] * 1000 + a[2]
										* 100 + a[3] * 10 + a[4])
										+ " / "
										+ (a[5] * 10000 + a[6] * 1000 + a[7]
												* 100 + a[8] * 10 + a[9])
										+ " = " + num.get(k));
							}
						}
					}
					
					break;

				}
			}

		} else {
			for (i = 0; i <= 9; i++) {
				boolean ok = true;
				for (j = 0; j < position; j++)
					if (a[j] == i) {
						ok = false;
						break;
					}
				if (ok) {
					a[position] = i;
					permutation(position + 1);
				}
			}
		}
	}

}
