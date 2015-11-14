import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int tmp=t;
		while (tmp-- > 0) {
			int n = sc.nextInt();
			int[] crop = new int[n];

			sc.nextLine();
			String strTmp = sc.nextLine();
			for (int i = 0; i < strTmp.length(); i++) {
				if (strTmp.charAt(i) == '.') {
					crop[i] = 1;
				} else {
					crop[i] = 0;
				}
			}

			int count = 0;
			for (int i = 0; i < crop.length; i++) {
				if (crop[i] == 1) {
					count++;
					crop[i] = 0;
					if (i + 1 < crop.length)
						crop[i + 1] = 0;
					if (i + 2 < crop.length)
						crop[i + 2] = 0;

					i += 2;
				}
			}

			System.out.println("Case "+(t-tmp)+": "+count);

		}

		sc.close();

	}

}
