import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int index = 0;

		while (true) {
			int[] number = new int[1000000];
			index++;
			int numOfQueue = sc.nextInt();
			if (numOfQueue == 0) {
				break;
			}

			for (int i = 0; i < numOfQueue; i++) {

				int tmp = sc.nextInt();
				for (int j = 0; j < tmp; j++) {
					number[sc.nextInt()] = i;
				}

			}

			LinkedList<Integer> bigQueue = new LinkedList<Integer>();
			LinkedList<Integer>[] smallQueue = new LinkedList[numOfQueue];
			for(int i=0;i<numOfQueue;i++){
				smallQueue[i]=new LinkedList<Integer>();
			}

			System.out.println("Scenario #" + index);

			while (true) {
				String cmd = sc.next();

				if (cmd.equals("ENQUEUE")) {
					int tmp = sc.nextInt();
					int num = number[tmp];
					if (smallQueue[num].isEmpty()) {
						bigQueue.add(num);
					}
					smallQueue[num].add(tmp);
				} else if (cmd.equals("DEQUEUE")) {
					int num = bigQueue.getFirst();
					System.out.println(smallQueue[num].getFirst());
					smallQueue[num].removeFirst();
					if (smallQueue[num].isEmpty())
						bigQueue.removeFirst();
				} else {
					break;
				}
			}
			
			System.out.println();

		}

		sc.close();

	}

}
