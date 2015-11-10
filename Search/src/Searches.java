
public class Searches {

	int [] a = {};
	double [] b = {};
	String [] c = {};
	int target = 7;
	double target2 = 5.0;
	String word;



	public static int linearSearch (int[] a, int target){  
		for (int i=0;i<a.length;i++){
			if (a[i] == target)
				return (i);

		}
		return (-1);
	}

	public static int linearSearch (double[] a, double target){
		{
			for (int z = 0;z<a.length;z++)
				if (a[z] == target)
					return (z);				
		}
		return (-1);
	}

	public static int linearSearch (String[] c, String word){
		{
			for (int a = 0;a<c.length;a++)
				if (c[a].equalsIgnoreCase(word))
					return a;			
		}
		return (-1);
	}




	public static int SearchBinary (int [] a, int target){
		int beginIndex = 0;
		int endIndex = a.length-1;
		int midIndex = (beginIndex+endIndex)/2;		

		while (beginIndex <= endIndex){
			midIndex = (beginIndex+endIndex)/2;				
			if (a[midIndex] == target){
				return midIndex;
			}
			else if (a[midIndex]<target){
				beginIndex = midIndex+1;
			}
			else if (a[midIndex]>target){
				endIndex = midIndex-1;
			}
		}
		return (-1);		

	}

	public static int SearchBinary (double [] b, double target2){
		int beginIndex = 0;
		int endIndex = b.length-1;
		int midIndex = (beginIndex+endIndex)/2;		

		while (beginIndex <= endIndex){
			midIndex = (beginIndex+endIndex)/2;
			if (b[midIndex] == target2){
				return midIndex;
			}
			else if (b[midIndex]<target2){
				beginIndex = midIndex+1;
			}
			else if (b[midIndex]>target2){
				endIndex = midIndex-1;
			}
		}
		return (-1);		

	}


	public static int SearchBinary (String [] c, String word){
		int beginIndex = 0;
		int endIndex = c.length-1;
		int midIndex = (beginIndex+endIndex)/2;		

		while (beginIndex <= endIndex){
			midIndex = (beginIndex+endIndex)/2;
			if (c[midIndex] == word){
				return midIndex;
			}
			else if (c[midIndex].equalsIgnoreCase(word)){
				beginIndex = midIndex+1;
			}
			else if (c[midIndex].equalsIgnoreCase(word)){
				endIndex = midIndex-1;
			}
		}
		return (-1);		


	}
}
