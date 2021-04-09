import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Solution{
 
	public static void main(String args[]) throws Exception{
 
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(sc,pw);
		sc.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(Scanner sc,PrintWriter pw) throws Exception{
		
		int T = sc.nextInt();	
		for(int i = 0;i < T;i++){
			int N = sc.nextInt();	
			int A[] = new int[N];
			int M = 2*10000001;
			int count[] = new int[M];
			int sum = 0;
			for(int j = 0;j < N;j++){
				A[j] = sc.nextInt();	
				sum = sum + Math.abs(A[j]);
				
			}
			long ans = 0;
			count[sum]++;
			for(int j = 0;j < N;j++){
				sum += A[j];
				for(int k = 0;k*k <= sum;k++){
					ans += count[sum-k*k];
				}
				count[sum]++;
			}
			
			pw.println("Case #" + (i+1) + ": "+ans);
			
		}
		
		
		

	}
	
}




