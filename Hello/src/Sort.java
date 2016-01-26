
public class Sort {
	int[] listOfNums = {3,1,4,5,6};
	int start = listOfNums[0];
	int end = listOfNums[listOfNums.length-1];
	int mid = (start + end)/2;

	public static void selectionSorts (int[] listOfNums){
		int temp = 0;  	
		for (int i =0; i<listOfNums.length;i++){
			for (int subindex = i;subindex<listOfNums.length;subindex++){
				if (listOfNums[subindex]<listOfNums[i]){
					temp = listOfNums[i];
					listOfNums[i] = listOfNums[subindex];
					listOfNums[subindex]=temp;
				}
			}
		}
	}

	public static void insertionSorts (int[] listOfNums){
		int temp, previousIndex;
		for (int i = 0; i<listOfNums.length;i++){
			temp = listOfNums[i];
			previousIndex = i-1;
			while ((listOfNums[previousIndex]>temp)&& (previousIndex>0)){
				listOfNums[previousIndex + 1]= listOfNums[previousIndex];
				previousIndex-=1;
			}
			if (listOfNums[previousIndex] > temp){
				listOfNums[previousIndex + 1] = listOfNums[previousIndex];
				listOfNums[previousIndex] = temp;
			}
			else{
				listOfNums[previousIndex +1] = temp;
			}
		}
	}

	public static void merging (int[] listOfNums, int start, int end, int mid) {
		int[] temp = new int[listOfNums.length];
		int pos1 = start;
		int pos2 = mid;
		int spot = start;

		while (!(pos1 > mid && pos2 > end)){
			if ((pos1 > mid)||(pos2 <= end) && (listOfNums[pos2] < listOfNums[pos1])){
				temp[spot] = listOfNums[pos2];
				pos2 +=1;			
			}
			else{
				temp[spot] = listOfNums[pos1];
				pos1 +=1 ;
			}
			spot +=1;
		}
		for (int i = start; i <= end; i++){
			listOfNums[i] = temp[i];
		}
	}

	public static void mergeSort (int[] listOfNums, int start, int end){
		if (start < end){
			int mid = (start+end)/2;
			mergeSort(listOfNums, start, mid);
			mergeSort(listOfNums, mid+1, end);
			merging(listOfNums, start, mid, end);
		}
	}

	public static void bubbleSort (int[] listOfNums){
		int flag = 0;
		do{
			for (int k=0; k<listOfNums.length; k++){
				for (int i=0; i<listOfNums.length-1;i++){
					if (listOfNums[i] >listOfNums[i+1]){
						listOfNums[i] = listOfNums[i+1];
						listOfNums[i+1]=listOfNums[i];
						flag = 1;
					}
				}

			}
		}
		while(flag==1);
		
			
	}

	public static void quickSort (int[] listOfNums, int start, int end){
		int p=start,c=end,temp;
		int pivot = listOfNums[(p+c)/2];
		
		while(p<=c){
			while (listOfNums[p]<pivot){
				p++;
			}
			while (listOfNums[c]>pivot){
				c--;
			}
			if (p<=c){
				temp = listOfNums[p];
				listOfNums[p] = listOfNums[c];
				listOfNums[c] = temp;
				p++;
				c--;
				
			}
		}

	}
}


