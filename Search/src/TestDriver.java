
public class TestDriver {

	public static void main(String[] args) {

		int location1;		
		int[] array1 ={3,6,8,9,10,11,23,34,37,41,56};
		double[] array2 = {2.0,3.0,5.5,9.9,10.1,20,4,30.0};
		String[] array3 ={"dog","egg","Slam","THE","ball"};
		

		
		location1 = Searches.linearSearch(array1, 56);
		if (location1 == -1){
			System.out.println("Sorry, number not found in array.");
		}
		else {
		System.out.println ("First occurrence is element " + location1);	
		}
		
		location1 = Searches.linearSearch(array2, 5.5);
		if (location1 == -1){
			System.out.println("Sorry, number not found in array.");
		}
		else{
			System.out.println ("First occurrence is element " + location1);
		}
		
		location1 = Searches.linearSearch(array3,"ball");
		if (location1 == -1){
			System.out.println("Sorry, word not found in array.");
		}
		else{
			System.out.println("First occurrence is element " + location1);
		}
		
		
		location1 = Searches.SearchBinary(array1, 11);
		if (location1 == -1){
			System.out.println("Sorry, number not found in array.");
		}
		else{
			System.out.println("First occurrence is element " + location1);
		}
		
		location1 = Searches.SearchBinary(array2, 9.9);
		if (location1 == -1){
			System.out.println("Sorry, number not found in array.");
		}
		else{
			System.out.println("First occurrence is element " + location1);
		}
		
		location1 = Searches.SearchBinary(array3, "the");
		if (location1 == -1){
			System.out.println("Sorry, number not found in array.");
		}
		else{
			System.out.println("First occurrence is element " + location1);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
