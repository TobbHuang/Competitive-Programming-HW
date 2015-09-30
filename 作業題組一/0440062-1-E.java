import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1, str2, str3;
		int letter1[] = new int[26];
		int letter2[] = new int[26];
		int letter3[] = new int[26];
		int num2 = 0, num3 = 0;// 字符串b和c的数量
		int num23 = 0;// 字符串b+c

		Scanner sc = new Scanner(System.in);

		str1 = sc.nextLine();
		str2 = sc.nextLine();
		str3 = sc.nextLine();

		sc.close();

		for (int i = 0; i < str1.length(); i++) {
			char tmp = str1.charAt(i);
			letter1[tmp - 'a']++;
		}
		for (int i = 0; i < str2.length(); i++) {
			char tmp = str2.charAt(i);
			letter2[tmp - 'a']++;
		}
		for (int i = 0; i < str3.length(); i++) {
			char tmp = str3.charAt(i);
			letter3[tmp - 'a']++;
		}

		int numOfB = 0;
		int temp[] = new int[26];
		for (int i = 0; i < 26; i++)
			temp[i] = letter1[i];
		while (true) {
			int numOfC = 1000000;
			for (int i = 0; i < 26; i++) {
				if (letter3[i] != 0) {
					numOfC = Math.min(numOfC, temp[i] / letter3[i]);
				}
			}

			if ((numOfB + numOfC) > num23) {
				num23 = numOfB + numOfC;
				num2 = numOfB;
				num3 = numOfC;
			}

			boolean m = false;
			for (int i = 0; i < 26; i++) {
				temp[i] -= letter2[i];
				if (temp[i] < 0) {
					m = true;
					break;
				}
			}
			if (m)
				break;
			numOfB++;

		}

		for (int i = 0; i < num2; i++) {
			System.out.print(str2);
		}
		for (int i = 0; i < num3; i++) {
			System.out.print(str3);
		}

		for (int i = 0; i < 26; i++) {
			letter1[i] -= (num2 * letter2[i] + num3 * letter3[i]);
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < letter1[i]; j++) {
				System.out.print((char) (i + 'a'));
			}
		}
		System.out.println();

	}

}
