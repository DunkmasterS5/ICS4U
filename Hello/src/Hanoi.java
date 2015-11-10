
public class Hanoi {

	public static void main(String[] args) {
		int N=3;
		String Src="A";
		String Aux="B";
		String Dst="C";
		
		solve ( N,  Src,  Aux,  Dst);
		
		
	}			
		public static void solve(int N, String Src, String Aux, String Dst){
	    if (N == 0) 
	      return;
	    else
	      solve(N - 1, Src, Dst, Aux);
	     System.out.println( "Move from " + Src + " to " + Dst);
	      solve(N - 1, Aux, Src, Dst);
	     
			            
		
   }

}
