import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<String> sampleName = new ArrayList<String>();
	public static ArrayList<int[][]> data = new ArrayList<int[][]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();
			if (str.equals("end")) {
				break;
			}

			sampleName.add(str);
			int[][] a = new int[10][10];

			for (int i = 0; i < 10; i++) {
				str = sc.nextLine();
				for (int j = 0; j < 10; j++) {
					if (str.charAt(j) == '#')
						a[i][j] = 0;
					else
						a[i][j] = 1;
				}
			}
			data.add(a);

		}

		sc.close();

		// i为sample的序号
		for (int i = 0; i < sampleName.size(); i++) {

			int minStep = 1000;
			int step = 0;

			ArrayList<Integer> set = new ArrayList<Integer>();
			for (int j = 0; j < 10; j++) {
				set.add(j);
			}
			ArrayList<ArrayList<Integer>> list = getSubsets(set, 0);

			for (ArrayList<Integer> list1 : list) {

				int a[][]=new int[10][10];
				int b[][] = data.get(i);
				for(int j=0;j<10;j++){
					for(int k=0;k<10;k++){
						a[j][k]=b[j][k];
					}
				}

				step = 0;
				// 第一列switch灯
				for (int j = 0; j < list1.size(); j++) {
					step++;
					int m = list1.get(j);
					a[m][0] = switchLight(a[m][0]);
					a[m][1] = switchLight(a[m][1]);
					if (m != 0) {
						a[m - 1][0] = switchLight(a[m - 1][0]);
					}
					if (m != 9) {
						a[m + 1][0] = switchLight(a[m + 1][0]);
					}
				}

				for (int j = 1; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if (a[k][j - 1] == 1) {
							step++;
							a[k][j] = switchLight(a[k][j]);
							a[k][j - 1] = switchLight(a[k][j - 1]);
							if (j != 9) {
								a[k][j + 1] = switchLight(a[k][j + 1]);
							}
							if (k != 0) {
								a[k - 1][j] = switchLight(a[k - 1][j]);
							}
							if (k != 9) {
								a[k + 1][j] = switchLight(a[k + 1][j]);
							}
						}
					}
				}

				if (a[0][9] == 0 && a[1][9] == 0 && a[2][9] == 0
						&& a[3][9] == 0 && a[4][9] == 0 && a[5][9] == 0
						&& a[6][9] == 0 && a[7][9] == 0 && a[8][9] == 0
						&& a[9][9] == 0) {
					//System.out.println("success"+step);
					if (step < minStep) {
						minStep = step;
					}
				}

			}

			// System.out.println(minStep);
			if (minStep <= 100) {
				System.out.println(sampleName.get(i) + " " + minStep);
			} else {
				System.out.println(sampleName.get(i) + " -1");
			}

		}

	}

	public static int switchLight(int i) {
		if (i == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,
			int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> s : allsubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(s);
				newSubset.add(item);
				moresubsets.add(newSubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

}
