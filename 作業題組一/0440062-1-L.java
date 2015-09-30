import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n;
		long m;
		n = sc.nextInt();
		m = sc.nextLong();

		sc.close();
		
		String str=ten2two(m-1);

		int strLength=str.length();
		for(int i=n;i>strLength+1;i--){
			str="0"+str;
		}
		
		int head=0,tail=n-1;
		int print[]=new int[n];
		for(int i=0;i<str.length();i++){
			if(head==tail)
				break;
			
			if(str.charAt(i)=='0'){
				print[head]=i+1;
				head++;
			} else{
				print[tail]=i+1;
				tail--;
			}
		}
		print[head]=n;
		for(int i=0;i<print.length;i++){
			if(i!=0)
				System.out.print(" ");
			System.out.print(print[i]);
		}

	}

	static String ten2two(long n) {
		String str = "";

		while (true) {
			str = n % 2 + str;
			n /= 2;
			if (n == 0)
				break;
		}

		return str;
	}

}
