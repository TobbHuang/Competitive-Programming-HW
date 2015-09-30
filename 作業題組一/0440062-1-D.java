import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean isAB = false, isBA = false;

		String str = sc.nextLine();
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'A') {
				if (str.charAt(i + 1) == 'B' && !isAB) {
					isAB = true;
					i++;
					if (isBA) {
						break;
					}
				}
			} else if (str.charAt(i) == 'B') {
				if (str.charAt(i + 1) == 'A' && !isBA) {
					isBA = true;
					i++;
					if (isAB) {
						break;
					}
				}
			}
		}

		if (!isAB || !isBA) {
			isAB=false;
			isBA=false;
			for (int i = str.length()-1; i >=1; i--) {
				if (str.charAt(i) == 'A') {
					if (str.charAt(i - 1) == 'B' && !isAB) {
						isAB = true;
						i--;
						if (isBA) {
							break;
						}
					}
				} else if (str.charAt(i) == 'B') {
					if (str.charAt(i - 1) == 'A' && !isBA) {
						isBA = true;
						i--;
						if (isAB) {
							break;
						}
					}
				}
			}
		}

		sc.close();

		if (isAB && isBA) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
