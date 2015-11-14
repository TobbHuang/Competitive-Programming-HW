import java.util.Scanner;


public class Main {
	
	static int sumCount;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n,a,b,k;
		n=sc.nextInt();
		a=sc.nextInt();
		b=sc.nextInt();
		k=sc.nextInt();
		sc.close();
		
		takeLift(a, 0, n, b, k);
		
		System.out.println(sumCount);
		
	}
	
	static void takeLift(int currentFloor,int currentCount,int n,int b,int k){
		if(currentCount==k){
			sumCount++;
			return;
		}
		
		int tmp=Math.abs(currentFloor-b);
		for(int i=1;i<tmp;i++){
			if(currentFloor+i>n){
				break;
			}
			takeLift(currentFloor+i,currentCount+1,n,b,k);
		}
		
		for(int i=1;i<tmp;i++){
			if(currentFloor-i<1){
				break;
			}
			takeLift(currentFloor-i,currentCount+1,n,b,k);
		}
		
	}

}
