
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class bricks
{	
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N,W,H;
			int[][] arr;
			
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			int max_w = W;
			int max_h = H;
			
			arr = new int[W][H];

			
			for(int i=0 ; i < W; i++) {
				for(int j=0; j < H; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			hit(arr, N , W ,H , max_w, max_h);
			System.out.println("max_count : " + max);

			
		}
	}
	
	
	static void hit(int[][] arr, int N , int W,int H, int max_w, int max_h) {
		if(N == 0)
			return ;
		
		int[][] copy;
		int[][] isVisited;
		copy = new int[max_w][max_h];
		isVisited= new int[max_w][max_h];
		
		max=0;
		
		for (int i=0; i<max_h; i++) {
			W=0; 
			

			while(W < max_w) {
				if(arr[W][i]!= 0 ) {
					System.out.println(" arr["+W+"]["+i+"]: " + arr[W][i]);

					break;}else if(W==max_w-1) {
						break;
					}

				else {
				W++;}
			}
			
			for(int a=0; a<max_w; a++) {
				for (int b=0; b<max_h; b++) {
					copy[a][b]=0;
				}
			}
			
			for(int a=0; a<max_w; a++) {
				for (int b=0; b<max_h; b++) {
					isVisited[a][b]=0;
				}
			}
			
			


			break_start(arr, W, i, copy, max_w, max_h, isVisited);
			break_calculate(arr, copy, max_w, max_h);
			
			hit(arr, N-1, W, H, max_w, max_h);

			if(N==1) {
				int count =0;
				
				for(int a=0; a<max_w; a++) {
					for (int b=0; b<max_h; b++) {
						if(arr[a][b]!=0) count++;
					}
				}
				
				if(count > max) {
					max=count;}
				
				//System.out.println("max_count : " + max);
			}
				
			

			}			
			
		
			
			
		
	}
	
	static void break_calculate(int[][] arr, int[][] copy, int max_w, int max_h) {
		
	// 폭탄 맞은 만큼 빼줌
		for(int i=0; i<max_w; i++) {
			for(int j=0; j<max_h; j++) {
				arr[i][j] = arr[i][j] - copy[i][j];
				if(arr[i][j]<0) arr[i][j]=0;
			}
		}
		
		/*System.out.println("copy : ");
		printarr(copy, max_w, max_h);
		System.out.println();

		System.out.println("arr: ");
		printarr(arr, max_w, max_h);

		*/
		//블록 떨어뜨려줌
		for(int i=0; i<max_w; i++) {
			for(int j=0; j<max_h; j++) {
				if((i-1)>=0 && arr[i][j]==0 && arr[i-1][j]>0) {
					for(int k=i; k>=0; k--) {
						if(k==0) {
							arr[0][j]=0;
						}else {
							
						arr[k][j]= arr[k-1][j];
						}
					}
				}
			}
		}
		
	//	System.out.println();

	//	System.out.println("result: ");
	//	printarr(arr, max_w, max_h);

		
		
		
	}
	
	
	static void break_start(int[][] arr,int W,int  H, int[][] copy, int max_w, int max_h, int[][] isVisited){
		

		System.out.println(" W&H " + W +" "+ H);
		int attack  = arr[W][H];
		
		copy[W][H] = copy[W][H]+1;
		
		
		
		if(isVisited[W][H]==1) return;
		
		isVisited[W][H]=1;

		if(attack <= 1 ) return; 
		

		
			
			//상
			for(int i=1; i<attack; i++) {

				if(W-i <0) break;
				
				copy[W-i][H]++; 
				

				if(arr[W-i][H] >1) {

					break_start(arr, W-i, H, copy, max_w, max_h, isVisited);
				}
				
			}
			
			//하
			for(int i=1; i<attack; i++) {

				if(W+i >= max_w) break;
				copy[W+i][H]++; 
				
				if(arr[W+i][H] >1) {

					break_start(arr, W+i, H, copy, max_w, max_h, isVisited);
				}
				
			}
			
			//좌
			
			for(int i=1; i<attack; i++) {
				if(H-i <0 ) break;
				copy[W][H-i]++; 
				
				if(arr[W][H-i] >1) {

					break_start(arr, W, H-i, copy, max_w, max_h, isVisited);
				}
				
			}
			
			//우
			for(int i=1; i<attack; i++) {
				if(H+i >= max_h) break;
				
				copy[W][H+i]++; 
				
				if(arr[W][H+i] >1) {

					break_start(arr, W, H+i, copy, max_w, max_h, isVisited);
				}
				
			}
			
					
			return;
			
		
		
	}
	
	
	static void printarr (int[][] arr, int max_w, int max_h) {
		
		for(int i=0; i<max_w; i++) {
			for(int j=0; j<max_h; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
	}
}