import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Leg[] leg;
		int emergyCount = 0;
		int minEmergy = 100000000;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		leg = new Leg[n];
		for (int i = 0; i < n; i++) {
			leg[i] = new Leg(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			leg[i].emergy = sc.nextInt();
		}
		sc.close();

		Arrays.sort(leg, new LegEmergyComparator());

		while (true) {
			int maxLength = 0, maxCount = 0;
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			for (int i = 0; i < leg.length; i++) {
				if (leg[i] != null) {
					if (leg[i].length > maxLength) {
						maxLength = leg[i].length;
						maxCount = 1;
						list1.clear();
						list1.add(i);
					} else if (leg[i].length == maxLength) {
						maxCount++;
						list1.add(i);
					}
				}
			}

			if (maxCount > n / 2) {
				break;
			}

			int emergy1 = 0, emergy2 = 0;

			// 计算砍最大的腿的能量
			for (int i = 0; i < maxCount; i++) {
				emergy1 += leg[list1.get(i)].emergy;
			}

			// 计算砍小腿的能量
			int index = -1;
			for (int i = 0; i < (n - 2 * maxCount + 1); i++) {
				// 找一个能砍的
				while (true) {
					index++;
					if (leg[index] != null && leg[index].length != maxLength) {
						break;
					}
				}
				emergy2 += leg[index].emergy;
			}

			emergy2 += emergyCount;
			if (emergy2 < minEmergy) {
				minEmergy = emergy2;
			}

			emergyCount += emergy1;
			if (emergyCount >= minEmergy) {
				break;
			} else {
				// 砍大腿
				for (int i = 0; i < list1.size(); i++) {
					leg[list1.get(i)] = null;
				}
				n -= list1.size();
			}
			
		}

		if (emergyCount < minEmergy)
			minEmergy = emergyCount;
		System.out.println(minEmergy);

	}

}

class Leg {

	int length, emergy;

	public Leg(int length, int emergy) {
		this.length = length;
		this.emergy = emergy;
	}

	public Leg(int length) {
		this.length = length;
	}
}

class LegEmergyComparator implements Comparator<Leg> {

	@Override
	public int compare(Leg o1, Leg o2) {
		// TODO Auto-generated method stub
		return o1.emergy - o2.emergy;
	}

}
