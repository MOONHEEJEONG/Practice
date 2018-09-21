import java.util.Scanner;

public class Bomb {

	
	public static void main(String[] args) {
	int test_case;
	int map_size;
	
	Scanner sc = new Scanner(System.in);

	
	test_case = sc.nextInt();
	map_size = sc.nextInt();
	String xy = sc.next();

	
	
	 int[][] map = new int[map_size][map_size];
	
	for(int i=0; i<map_size; i++) {
		for(int j=0; j<map_size; j++) {
			map[i][j]=0;
		}
	}
	
	
	
	String xy1, xy2, xy3;
	int x1, y1;
	
	int start=0;
	int end = xy.indexOf(",");
	
	if(end==-1) {
		xy1=xy;
		xy2=null;
		xy3=null;
	}else {
		xy1=xy.substring(start, end);
		xy=xy.substring(end+1, xy.length());
		end=xy.indexOf(",");
		
		if(end==-1) {
			xy2=xy;
			xy3=null;
		}else {
			
			xy2=xy.substring(start, end);
			xy3=xy.substring(end+1, xy.length());
		}
		
	}
		
	
	
	
	if(xy1!=null) {
	for(int i=0; i< xy1.length(); i=i+2) {
		
		int attack = 1;
		
		x1 = xy1.charAt(i)-'0';
			
		y1 = xy1.charAt(i+1)-'0';
		
		bomb1(x1,y1, map, map_size, attack);
				
	}
	
	}
	
	
	if(xy2!=null) {
	for(int i=0; i< xy2.length(); i=i+2) {
		
		int attack = 2;
		
		x1 = xy2.charAt(i)-'0';
		y1 = xy2.charAt(i+1)-'0';
		
		bomb1(x1,y1, map, map_size, attack);
				
		}
	}
	
	if(xy3!=null) {
	for(int i=0; i< xy3.length(); i=i+2) {
	
	int attack = 3;
	
	x1 = xy3.charAt(i)-'0';
	y1 = xy3.charAt(i+1)-'0';
	
	bomb1(x1,y1, map, map_size, attack);
		}		
	}

	
	for(int i=0; i<map_size; i++) {
		for(int j=0; j<map_size; j++) {
			System.out.print(map[i][j]+" ");
		}
		System.out.println();
	}
	
	
	}
	
	static void bomb1 (int x1, int y1, int[][] map, int map_size, int i) {
		
		map[x1][y1]=1;
		
			for(int j=1 ; j<=i && (x1-j)>=0 ; j++) {
			map[x1-j][y1]=1;}
	
		
			for(int j=1 ; j<=i && (x1+j)<map_size; j++) {
			map[x1+j][y1] = 1;	}
	
		
			for(int j=1 ; j<=i && y1-j>=0; j++) {
			map[x1][y1-j] = 1;	
			}
		
			
			for(int j=1 ; j<=i && y1+j<map_size; j++) {
			map[x1][y1+j] = 1;	}
		
		
	}
	
}
