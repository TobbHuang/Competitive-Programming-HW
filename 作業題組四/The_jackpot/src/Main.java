import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			int max = 0;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				max += tmp;
				if(max<=0){
					max=0;
					continue;
				}
				ans = Math.max(ans, max);
			}

			if (ans == 0) {
				System.out.println("Losing streak.");
			} else {
				System.out
						.println("The maximum winning streak is " + ans + ".");
			}
		}

		sc.close();

	}

}
