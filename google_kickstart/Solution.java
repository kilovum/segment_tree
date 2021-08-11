import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Solution{
	int N;
	long tree1[];
	long tree2[];
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			long A[] = new long[N];
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < N;j++){
				A[j] = Long.parseLong(st.nextToken());
			}
			tree1 = new long[2*N];
			tree2 = new long[2*N];
			for(int j = 0;j < N;j++){
				tree1[N+j] = A[j];
				tree2[N+j] = (j+1)*A[j];
				if((j+1)%2 == 0){
					tree1[N+j] *= -1;
					tree2[N+j] *= -1;
				}
			}
			build();
			long ts = 0;
			for(int j = 0;j < Q;j++){
				st = new StringTokenizer(br.readLine());
				String o = st.nextToken();
				
				if(o.equals("Q")){
					//System.out.println(Arrays.toString(tree1));
					//System.out.println(Arrays.toString(tree2));
					int L = Integer.parseInt(st.nextToken());
					int R = Integer.parseInt(st.nextToken());
					//System.out.println(sum(L-1,R-1,tree2)+" "+sum(L-1,R-1,tree1));
					//System.out.println((sum(L-1,R-1,tree2) - sum(L-1,R-1,tree1)*(L-1)));
					if(L%2 == 0){
						ts -= (sum(L-1,R-1,tree2) - sum(L-1,R-1,tree1)*(L-1));
					}
					else{
						ts += (sum(L-1,R-1,tree2) - sum(L-1,R-1,tree1)*(L-1));
					}
				}
				else{
					int X = Integer.parseInt(st.nextToken());
					long V = Long.parseLong(st.nextToken());
					if(X%2 == 0){
						add(X-1,-V,tree1);
						add(X-1,-X*V,tree2);
					}
					else{
						add(X-1,V,tree1);
						add(X-1,X*V,tree2);
					}
					
				}
			}
			
			
				
			
			
			pw.println("Case #" + (i+1) + ": "+ts);
			
		}
		
		
		

	}
	void build(){
		for(int i = N-1;i >= 0;i--){
			tree1[i] = tree1[2*i] + tree1[2*i+1];
			tree2[i] = tree2[2*i] + tree2[2*i+1];
		}
	}
	long sum(int a ,int b,long tree[]){
		long s = 0;
		a += N;
		b += N;
		while(a <= b){
		
			if(a%2 == 1){
				s += tree[a++];
			}
			if(b%2 == 0){
				s += tree[b--];
			}
			a /= 2;
			b /= 2;
		}
		return s;
	}
	void add(int k,long x,long tree[]){
		k += N;
		tree[k] = x;
		for(k = k/2;k >= 1;k = k/2){
			tree[k] = tree[2*k]+tree[2*k+1];
		}
	}
}





