import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<int[]> list = new ArrayList<int[]>();
	public static int[] a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int m, n;
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n];

		sc.close();

		// 枚举出所有排列
		new Main().permutation(n, 0);
		
		//计算fp
		int[] fp = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < n; j++) {
				fp[i] += new Main().findMin(0, 1000000, j, list.get(i), n);
			}
			//System.out.println(fp[i]);
		}
		
		// 找出最大值
		int curMax=0;
		for(int i=0;i<fp.length;i++){
			if(fp[i]>curMax){
				curMax=fp[i];
			}
		}
		
		// 找出第m个排列
		int index=0;
		for(int i=0;i<fp.length;i++){
			//System.out.println(i);
			if(fp[i]==curMax){
				index++;
				
				if(index==m){
					for(int j=0;j<n;j++){
						System.out.print(list.get(i)[j]+" ");
					}
				}
				
			}
		}

	}

	public void permutation(int n, int position) {
		int i, j;
		if (position == n) {
			int[] b = new int[n];
			for (int k = 0; k < n; k++) {
				b[k] = a[k];
			}
			list.add(b);
		} else {
			for (i = 1; i <= n; i++) {
				boolean ok = true;
				for (j = 0; j < position; j++)
					if (a[j] == i) {
						ok = false;
						break;
					}
				if (ok) {
					a[position] = i;
					permutation(n, position + 1);
				}
			}
		}
	}

	public int findMin(int sum, int min, int position, int[] b, int n) {
		min = Math.min(min, b[position]);
		sum += min;
		if (position == n - 1) {
			return sum;
		} else {
			return findMin(sum, min, position + 1, b, n);
		}
	}
}
