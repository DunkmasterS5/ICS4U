package Nguyen;

import java.util.ArrayList;
/**
 * The class where all the searches are placed/happen
 * @author 322211632
 *
 */

public class Searches {

	int [] a = {};
	double [] b = {};
	String [] c = {};
	int target = 7;
	double target2 = 5.0;
	String word;


    /**
     * Linear Search Method integer
     * @param a
     * @param target
     * @return
     */
     
	public static int linearSearch (int[] a, int target){  
		for (int i=0;i<a.length;i++){
			if (a[i] == target)
				return (i);

		}
		return (-1);
	}

	/**
	 * Linear search method double
	 * @param a
	 * @param target
	 * @return
	 */
	
	public static int linearSearch (double[] a, double target){
		{
			for (int z = 0;z<a.length;z++)
				if (a[z] == target)
					return (z);				
		}
		return (-1);
	}
	/**
	 * Linear search method strings
	 * @param c
	 * @param word
	 * @return
	 */

	public static int linearSearch (String[] c, String word){
		{
			for (int a = 0;a<c.length;a++)
				if (c[a].equalsIgnoreCase(word))
					return a;			
		}
		return (-1);
	}
	/**
	 * Linear search using the contestant information
	 * @param contestants
	 * @param b
	 * @return
	 */
			
	public static int linearSearch (ArrayList<ContestantInformation> contestants, ContestantInformation b){  
		for (int i=0;i<contestants.size();i++){
			if (contestants.get(i).equalsIgnoreCase(b)){
				return (i);
			}			
		}
		return (-1);
	}
	
	/**
	 * Binary Search method integer
	 * @param a
	 * @param target
	 * @return
	 */

	public static int SearchBinary (int[]a,int target){
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

	/**\
	 * binary search double
	 * @param b
	 * @param target2
	 * @return
	 */
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

	/**
	 * Binary search string
	 * @param c
	 * @param word
	 * @return
	 */
	public static int SearchBinary (String [] c, String word){
		int beginIndex = 0;
		int endIndex = c.length-1;
		int midIndex = (beginIndex+endIndex)/2;		

		while (beginIndex <= endIndex){
			midIndex = (beginIndex+endIndex)/2;
			if (c[midIndex] == word){
				return midIndex;
			}
			else if (c[midIndex].compareTo(word)>0){
				beginIndex = midIndex+1;
			}
			else if (c[midIndex].compareTo(word)<0){
				endIndex = midIndex-1;
			}
		}
		return (-1);		
	}
	
	/**
	 * Binary Search using the contestants information
	 * @param contestants
	 * @param f
	 * @return
	 */
	public static int SearchBinary (ArrayList<ContestantInformation> contestants, ContestantInformation f){
		int beginIndex = 0;
		int endIndex = contestants.size()-1;
		int midIndex = (beginIndex+endIndex)/2;

		while (beginIndex <= endIndex){
			midIndex = (beginIndex + endIndex)/2;
			if (contestants.get(midIndex)==f){
				return midIndex;
			}
			else if (contestants.get(midIndex).compareTo(f)>0){
				beginIndex = midIndex +1;
			}
			else if (contestants.get(midIndex).compareTo(f)<0){
				endIndex = midIndex-1;
			}

		}
		return (-1);

	}
	
	/**
	 * Binary Search utilizing a helper method and recursion
	 * @param aL
	 * @param target
	 * @return
	 */
		
	public int binarySearch(ArrayList<String>aL,String target){
		return binarySearch(aL,target,0,aL.size()-1);
	}
	
	private int binarySearch(ArrayList<String>aL,String target, int beginIndex,int endIndex){
		if (beginIndex>endIndex)
			return -1;
		int mid = (beginIndex+endIndex)/2;
		if (aL.get(mid).compareTo(target)==0)
			return mid;
		else if (aL.get(mid).compareTo(target)<0)
			return binarySearch(aL,target,mid+1,endIndex);
		else
			return binarySearch(aL,target,beginIndex,mid-1);
	}
	
	
}
