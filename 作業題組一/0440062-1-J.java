import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,l,r,x;
		int count=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		l=sc.nextInt();
		r=sc.nextInt();
		x=sc.nextInt();
		
		int[] num=new int[n];
		for(int i=0;i<n;i++){
			num[i]=sc.nextInt();
		}
		
		sc.close();
		
		
		int[] max=new int[(int) Math.pow(2, n)];
		int[] min=new int[(int) Math.pow(2, n)];
		int[] sum=new int[(int) Math.pow(2, n)];
		for(int i=0;i<max.length;i++){
			max[i]=0;
			min[i]=1000001;
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<Math.pow(2, i);j++){
				int index=(int) (j+Math.pow(2, i));
				sum[index]=sum[j]+num[i];
				max[index]=Math.max(max[j], num[i]);
				min[index]=Math.min(min[j], num[i]);
				if((max[index]-min[index])>=x&&sum[index]>=l&&sum[index]<=r){
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
