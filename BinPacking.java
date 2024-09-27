// ROGRAMMER: BRANDON THACH
// APRIL 8 2023

package csc241lab10;

import java.util.ArrayList;
import java.util.*;

class BinPacking {
	int capacity;
	int itemsToPack[] = new int[100];
	int binNumber;
	int totalNumBins;

public static void main(String args[]) {
	ArrayList<Integer> vect = new ArrayList<>();
	int pos = 0;
	int number = 0;
	int count = 1;
	int upperBound = 0;
	Scanner sc = new Scanner(System.in);

	System.out.println("how many items are to be packed? ");
	number = sc.nextInt();
	
	System.out.println("enter the bin capacity? ");
	upperBound = sc.nextInt();
	
	while (count <= number) {
		pos = getRandomValue(upperBound);
		vect.add(pos);
		count++;
	}
	
	System.out.println("-----------------------------");
	System.out.println("items to pack: ");
	print(vect);
	
	System.out.println("First Fit result:\n");
	// FIRST FIT ALGORITHM | next weight to be packed is placed in the lowest-number already-opened bin
	System.out.println(firstFit(vect, vect.size(), upperBound));
	System.out.println("---");
	System.out.println("Next Fit result:\n");
	// NEXT FIT ALGORITHM | open new bin if the next weight won't fit in the current bin -- current bin closes
	System.out.println(nextFit(vect, vect.size(), upperBound));
	
	
	sc.close();
}

public static int firstFit(ArrayList<Integer> array, int n, int c)
{
	int numBins = 0; // number of bins
	int[] spaceLeft = new int[n];
	
	for(int i = 0; i < n; i++)
	{
		int j;
		for(j = 0; j < numBins; j++)
		{
			if(spaceLeft[j] >= array.get(i))
			{
				spaceLeft[j] = spaceLeft[j] - array.get(i);
				break;
			}
		}
		
		if(j == numBins)
		{
			spaceLeft[numBins] = c - array.get(i);
			numBins++; // add another bin
		}
		System.out.println("Bin " + numBins + ": " + array.get(i));
	}
	
	System.out.print("Number of bins used: ");
	return numBins;
}

public static int nextFit(ArrayList<Integer> array, int n , int c)
{
	int numBins = 1, spaceLeft = c;
	
	for(int i = 0; i < n; i++)
	{
		if(array.get(i) > spaceLeft)
		{
			numBins++;
			spaceLeft = c - array.get(i);
		}
		else
		{
			spaceLeft -= array.get(i);
		}
	System.out.println("Bin " + numBins + ": " + array.get(i));
	}
	System.out.print("Number of bins used: ");
	return numBins;
}

public static int getRandomValue(int ub)
{
	Random r = new Random();
	int element = 0;
	int upperBound = ub;
	int lowerBound = 1;
	element = Math.abs(r.nextInt()) % upperBound + lowerBound;
	
	return element;
}
public static void print(ArrayList<Integer> a)
{
	for (int i = 0; i < a.size(); ++i)
		System.out.print(a.get(i) + " ");
	System.out.println("\n-----------------------------");
}

}