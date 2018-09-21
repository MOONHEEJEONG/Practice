import java.util.Scanner;

public class Palindrome {
 
	public static void main(String[] args) {
		
		int test_case;
		
		Scanner sc = new Scanner(System.in);
		
		test_case = sc.nextInt();
		String result = null;
		int input ;
		
		for(int i=0; i<test_case; i++) {
			
			
			Palindrome flip = new Palindrome();
			input = sc.nextInt();
			
			result = flip.isPalindrome(input);
			
			System.out.println(result);
			
			
			
		}
	}
	
	String isPalindrome (int input) {
		
		int[] original = new int[9];
		int[] reverse = new int[9];
		int[] sum = new int[9];
		int i=1;
		int length=0;
		
		String result = "yes";
		
		while(true) {
			
						
			reverse[i-1]=input %10;
			input = input/10;
			
			if(input ==0)
				break;			
			
			i++;
						
		}
		
		length = i;
		
		for(int j=0; j<length; j++) {
			original[j] = reverse[length-j-1];
			
			
			sum[j]= original[j]+reverse[j];
		}
		
		if(sum[0]>=10) {
			sum[1]= sum[0]%10;
			sum[0]= 1;
			length++;
			
		}
		
		
		for(int j=0; j<length/2; j++) {
			if(sum[j] != sum[length-j-1])
				result = "no";
		}
		
		
		
		return result;
	}
}
