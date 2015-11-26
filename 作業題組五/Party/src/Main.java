import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Node> tree = new ArrayList<Node>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			tree.add(new Node());
		}
		
		for (int i = 0; i < num; i++) {
			int tmp = sc.nextInt();
			if (tmp == -1) {
				tree.get(i).parentNode = root;
				root.childNode.add(tree.get(i));
			} else {
				tree.get(i).parentNode = tree.get(tmp - 1);
				tree.get(tmp - 1).childNode.add(tree.get(i));
			}
		}
		sc.close();

		System.out.println(findDeepth(root, 0));

	}

	static int findDeepth(Node root, int n) {
		if (root.childNode.size() == 0) {
			return n;
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < root.childNode.size(); i++) {
				list.add(findDeepth(root.childNode.get(i), n + 1));
			}
			int tmp = -1;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > tmp) {
					tmp = list.get(i);
				}
			}
			return tmp;
		}
	}

}

class Node {
	public ArrayList<Node> childNode;
	public Node parentNode;

	Node() {
		childNode = new ArrayList<Node>();
	}

}
