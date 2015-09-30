import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		int m;
		
		while(true){
			m=sc.nextInt();
			if(m==0){
				break;
			}
			
			list.add(m);
			
		}
		sc.close();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i)<=100){
				System.out.println("f91("+list.get(i)+") = 91");
			} else{
				System.out.println("f91("+list.get(i)+") = "+(list.get(i)-10));
			}
		}
		
	}

}
