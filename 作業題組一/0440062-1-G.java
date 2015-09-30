public class Main {

	public static boolean[][] route = new boolean[5][5];
	public static int[] line = new int[8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// init data
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j)
					route[i][j] = false;
				else
					route[i][j] = true;
			}
		}
		route[0][3] = false;
		route[3][0] = false;
		route[1][3] = false;
		route[3][1] = false;

		find(0, 0);
		
	}

	static void find(int step, int start) {
		if (step == 8) {
			System.out.print("1");
			for (int i = 0; i < 8; i++) {
				System.out.print(line[i]+1);
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (route[start][i]) {
				line[step] = i;
				
				// 设为不通达，然后递归
				route[start][i] = false;
				route[i][start] = false;
				
				find(step + 1, i);
				
				// 递归完毕，数据恢复
				route[start][i] = true;
				route[i][start] = true;
			}
		}

	}

}
