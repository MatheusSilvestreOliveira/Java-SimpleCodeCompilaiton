package codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorting {
	
	public void execute() {
		List<Integer> randomList = this.DefaultList();
		this.BubbleSort(randomList);
		this.MergeSort(randomList, 0, randomList.size()-1);
	}
	
	private void BubbleSort(List<Integer> list) {		
		// Get the size of the list
		int listSize = list.size();
		// This is the counter of the comparisons made
		int nComp = 0;
		
		System.out.println("List with " + listSize + " elements before sorting :");
		System.out.println(list);
		
		// This loop will make sure all of the elements is compared
		for (int i=0; i < listSize-1; i++) {
			// This loop will compare the elements, hence -i since theres is no need to compare the last element every time
			for (int j=0; j < listSize-i-1; j++) {
				nComp ++;
				// Compare the two adjacent elements
				if (list.get(j) > list.get(j+1)) {
					// Make the swap with the help of a temporary variable
					int swap = list.get(j+1);
					list.set(j+1, list.get(j));
					list.set(j, swap);
				}
			}
		}
		System.out.println();
		System.out.println("List after sorting process :");
		System.out.println(list);
		System.out.println("Number of comparisons made: " + nComp);
	}
	
	private void MergeSort(List<Integer> list, int l, int r) {
		// l = left, r = right, first iteration l=0 and r=list.size()
		if( l < r ) {
			// Divide the list in two other, m = middle
			int m = (l + r) / 2;
			// Calls himself to sort the halves
			this.MergeSort(list, l, m);
			this.MergeSort(list, m+1, r);
			// Merge the sorted halves
			this.Merge(list, l, m, r);
		}
	}
	
	private void Merge(List<Integer> list, int l, int m, int r) {
		// n1 and n2 determines how many elements are in the sublists, n1 being left and n2 being right
		int n1 = m - l + 1;
		int n2 = r - m;
		
		// Divide the sublists in temporary left and right
		int left[]= new int[n1];
		int right[]= new int[n2];
		
		// Put the data from the list in the temporary lists
		for (int i=0; i<n1;i++) {
			left[i] = list.get(l+i);
		}
		for (int j=0; j<n2;j++) {
			right[j] = list.get(m+1+j);
		}
		
		// Index of the temporary lists
		int i=0, j=0;
		// Index of the sorting list
		int k=l;
		
		// Merge the temporary lists to the sorting list
		// Logic is: if index from left is lower than right, put left in the list and increment left, else, put right in the list and increment right
		while(i<n1 && j<n2) {
			if(left[i] <= right[j]) {
				list.set(k, left[i]);
				i++;
			} else {
				list.set(k, right[j]);
				j++;
			}
			k++;
		}
		
		// Remeaning values in lists are already sorted and is put in the sorted list, left first.
		while(i<n1) {
			list.set(k, left[i]);
			i++;
			k++;
		}
		while(j<n2) {
			list.set(k, right[j]);
			j++;
			k++;
		}		
	}
	
	
	private List<Integer> DefaultList(){
		// This code creates a random list with 20 elements
		List<Integer> randomList = new ArrayList<>();
		Random random = new Random();

		for (int x=0 ; x<20 ; x++) {
			//                     max = 100  min = -50
			randomList.add(random.nextInt(100 + 50) - 50);
		}
		return randomList;
	}

}
