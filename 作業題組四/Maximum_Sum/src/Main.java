import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[][] data=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				data[i][j]=sc.nextInt();
		
		sc.close();
		
		int max=0;
		for(int i=0;i<n;i++){
			// 矩形从第i行开始
			for(int j=0;j<n;j++){
				for(int k=j;k<n;k++){
					// j为左端点，k为右端点
					int tmp=sum(data,0,i,j,k);
					if(tmp>=0){
						max=Math.max(tmp, max);
						
						for(int m=i+1;m<n;m++){
							// 从i+1行开始试矩阵
							tmp=sum(data,tmp,m,j,k);
							if(tmp>=0){
								max=Math.max(tmp, max);
							} else{
								break;
							}
						}
						
					}
					
				}
			}
			
		}
		
		System.out.println(max);
		
	}
	
	static int sum(int[][] data,int m,int i,int j,int k){
		// m为基数，i为行index，j为左端点，k为右端点
		int sum=0;
		for(int tmp=j;tmp<=k;tmp++){
			sum+=data[i][tmp];
		}
		
		return sum+m;
		
	}

}
