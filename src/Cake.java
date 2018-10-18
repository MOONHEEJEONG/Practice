import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Cake {

	private static int N ;
	private static int[][] arr;
	private static int max ;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N= sc.nextInt();
			
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					arr[i][j]= sc.nextInt();
				}
			}
			
			int left;
			int right;
			max=0;
			
			for(int i=1; i<=N-2; i++) {
					for(int j=1; j<N-1; j++) {
						if((i+j)>=N) break;
						
						left = i;
						right =j;
						
						track(left,right);
						
					}
			}
			
			if(max==0) max=-1;
			System.out.println("#"+test_case+" "+max);
			
			
		}
	}
	
	static void track(int left, int right) {
		
		int count;
		boolean isReluctant;
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i=0; i<=N-(left+right+1); i++) {
			
			for(int j=left; j<=N-1-right; j++) {
				
				al.clear();
				count=0;
				isReluctant=false;
				
				al.add(arr[i][j]);
				count++;
				
				for(int l=1; l<=left; l++) {
					
					if(al.contains(arr[i+l][j-l])==false && isReluctant==false) {
					al.add(arr[i+l][j-l]);
					count++;}
					
					else {
						isReluctant=true;
						count=0;
						break;
					}
				}
				
				for(int d=1; d<=right; d++) {
					if(al.contains(arr[i+left+d][j-left+d])==false && isReluctant==false) {
					al.add(arr[i+left+d][j-left+d]);
					count++;}
					
					else {
						isReluctant=true;
						count=0;
						break;
					}
					
				}
				
				for(int u=1; u<=left; u++) {
					if(al.contains(arr[i+(left+right)-u][j+(right-left)+u])==false && isReluctant==false) {
					al.add(arr[i+(left+right)-u][j+(right-left)+u]);
					count++;}
					
					else {
						isReluctant=true;
						count=0;
						break;
					}
					
				}
				
				for(int p=1; p<right; p++) {
					
					if(al.contains(arr[i+right-p][j+right-p])==false && isReluctant==false) {
					al.add(arr[i+right-p][j+right-p]);
					count++;}
					else {
						isReluctant=true;
						count=0;
						break;
					}
				}
				
				if(count > max) max=count;
			}
		}
	}
}
