import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int value = 0;

		int row = sc.nextInt();
		int column = sc.nextInt();

		int[][] goal = new int[row][column];
		int[][] operator = new int[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				operator[i][j] = 0;

		sc.nextLine();
		for (int i = 0; i < row; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == 'B') {
					goal[i][j] = -1;
				} else {
					goal[i][j] = 1;
				}
			}
		}
		sc.close();

		for (int i = row - 1; i >= 0; i--) {
			for (int j = column - 1; j >= 0; j--) {
				if (goal[i][j] != operator[i][j]) {
					value++;
					int tmp = goal[i][j] - operator[i][j];
					for (int m = 0; m <= i; m++) {
						for (int n = 0; n <= j; n++) {
							operator[m][n] += tmp;
						}
					}
				}
			}
		}
		
		System.out.println(value);

	}

}
