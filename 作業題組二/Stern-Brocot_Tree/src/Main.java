import java.util.Scanner;

public class Main {

	static long[] up;
	static long[] down;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int numOfCase = Integer.parseInt(sc.nextLine());
		for (int a = 0; a < numOfCase; a++) {

			up = new long[3];
			up[0] = 0;
			up[1] = 1;
			up[2] = 1;

			down = new long[3];
			down[0] = 1;
			down[1] = 1;
			down[2] = 0;

			String path = sc.nextLine();

			for (int i = 0; i < path.length(); i++) {
				long[] tmp1 = new long[3];
				long[] tmp2 = new long[3];
				switch (path.charAt(i)) {
				case 'L':
					tmp1[0] = up[0];
					tmp1[1] = up[0] + up[1];
					tmp1[2] = up[1];

					tmp2[0] = down[0];
					tmp2[1] = down[0] + down[1];
					tmp2[2] = down[1];

					break;
				case 'R':
					tmp1[0] = up[1];
					tmp1[1] = up[1] + up[2];
					tmp1[2] = up[2];

					tmp2[0] = down[1];
					tmp2[1] = down[1] + down[2];
					tmp2[2] = down[2];

					break;
				}

				for (int j = 0; j < 3; j++) {
					up[j] = tmp1[j];
					down[j] = tmp2[j];
				}

			}

			System.out.println(up[1] + "/" + down[1]);

		}

		sc.close();

	}

}
